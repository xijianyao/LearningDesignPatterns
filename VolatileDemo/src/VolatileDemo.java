import java.util.concurrent.TimeUnit;

class TestData {
    volatile int number = 0;

    public void add() {
        this.number = 60;
    }
}


public class VolatileDemo {
    public static void main(String[] args) {
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
