import java.util.concurrent.TimeUnit;

class TestData {
    volatile int number = 0;

    public void add() {
        this.number = 60;
    }

    //number前面加了的是volatile，不保证原子性的
    public void addPlusPlus() {
        number++;
    }
}


/*
 *1 验证volatile的可见性
 *   1.1加入 int number = 0 ，number变量在未添加volatile之前，是不具有可见性的
 *   1.2添加了volatile，可以解决可见性问题
 *
 *
 *2 验证volatile不保证原子性
 *   2.1原子性指的是什么意思？
 *       不可分割，完整性，某个线程在做具体业务的时候，中间不可以加塞或者分隔。需要整体完整
 *       要么同时成功，要么同时失败。
 *
 *   2.2volatile不保证原子性的案例演示
 *
 *
 *
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {
        TestData data = new TestData();

        for (int i = 1; i <= 40; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    data.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        //需要等待上面20个线程计算完成之后，再用main线程取得最终的结果值
        //暂停一会线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + data.number);
    }


    //volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    public static void seeOkByVolatile() {
        TestData data = new TestData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.add();
            System.out.println(Thread.currentThread().getName() + "\t update number to " + data.number);
        }, "aaa").start();

        while (data.number == 0) {
//            System.out.println(Thread.currentThread().getName() + "\t 0");
        }

        System.out.println(Thread.currentThread().getName() + "\t mission over" + data.number);

    }
}
