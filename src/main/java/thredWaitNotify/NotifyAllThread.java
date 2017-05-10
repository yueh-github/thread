package thredWaitNotify;

/**
 * Created by yuehao on 2017/5/10.
 */
public class NotifyAllThread {

    private static Object obj = new Object();

    public static void main(String[] args) {

        TestThread t1 = new TestThread("t1");

        TestThread t2 = new TestThread("t2");

        TestThread t3 = new TestThread("t3");

        t1.start();
        t2.start();
        t3.start();


        System.out.println(Thread.currentThread().getName() + " 开始睡觉5秒");
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " 唤醒睡觉的线程~~~");
            obj.notifyAll();
        }
    }

    static class TestThread extends Thread {

        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                synchronized (obj) {
                    System.out.println("线程进入等待 " + Thread.currentThread().getName() + " waiting....");
                    obj.wait();

                    System.out.println("线程被唤醒开始执行 ~~~~~" + " continue");
                }
            } catch (Exception ex) {

            }

        }
    }
}
