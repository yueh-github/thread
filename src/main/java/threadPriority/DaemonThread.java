package threadPriority;

/**
 * Created by yuehao on 2017/5/10.
 */
public class DaemonThread {

    public static void main(String[] args) {
        TestTread t1 = new TestTread("t1");

        DaemonTestTread daemonTestTread = new DaemonTestTread("d1");
        daemonTestTread.setDaemon(true);

        t1.start();
        daemonTestTread.start();


        System.out.println("main 线程终止~~~");
    }

    //(01) 主线程main是用户线程，它创建的子线程t1也是用户线程。
    //(02) t2是守护线程。在“主线程main”和“子线程t1”(它们都是用户线程)执行完毕，只剩t2这个守护线程的时候，JVM自动退出。

    static class TestTread extends Thread {
        public TestTread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
            }

        }
    }

    static class DaemonTestTread extends Thread {

        public DaemonTestTread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true)
                System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop ");
        }
    }
}
