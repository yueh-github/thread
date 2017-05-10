package threadSleep;

/**
 * Created by yuehao on 2017/5/10.
 */
public class LockSleepThread {

    private static Object object = new Object();

    public static void main(String[] args) {
        TestThread t1 = new TestThread("t1");
        TestThread t2 = new TestThread("t2");

        t1.start();
        t2.start();

    }

    //主线程main中启动了两个线程t1和t2。t1和t2在run()会引用同一个对象的同步锁，即synchronized(obj)。
    // 在t1运行过程中，虽然它会调用Thread.sleep(100)；但是，t2是不会获取cpu执行权的。因为，t1并没有释放“obj所持有的同步锁”！

    static class TestThread extends Thread {
        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    if (i % 2 == 0)
                        try {
                            Thread.sleep(5000);
                        } catch (Exception ex) {

                        }
                }
            }
        }
    }
}
