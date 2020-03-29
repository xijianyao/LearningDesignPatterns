import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCahce {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t writing" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t complete writing");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        rwLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t reading");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t complete read" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }

    }
}

/*
 * 读写锁
 *小总结。读读能共存，读写不能共存，写写不能共存
 *
 * 写操作：原子+独占，整个过程必须是一个完整的统一体，
 *
 * */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCahce myCahce = new MyCahce();
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCahce.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCahce.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
