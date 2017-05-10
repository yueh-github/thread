package threadYield;

/**
 * Created by yuehao on 2017/5/10.
 */
public class LockYieldThread {


    private static Object object = new Object();

    public static void main(String[] args) {
        TestTread t1 = new TestTread("t1");
        TestTread t2 = new TestTread("t2");
        t1.start();
        t2.start();
    }

    //如果两个线程之间持有同一个锁，那么做线程让步的时候是不会释放锁的

    //主线程main中启动了两个线程t1和t2。t1和t2在run()会引用同一个对象的同步锁，即synchronized(obj)。
    // 在t1运行过程中，虽然它会调用Thread.yield()；但是，t2是不会获取cpu执行权的。因为，t1并没有释放“obj所持有的同步锁”！

    static class TestTread extends Thread {
        public TestTread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object){
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);

                    if (i % 4 == 0)
                        Thread.yield();
                }
            }
        }
    }
}
