package threadPriority;

/**
 * Created by yuehao on 2017/5/10.
 */
public class PriorityThread {


    public static void main(String[] args) {
        TestTread t1 = new TestTread("t1");
        TestTread t2 = new TestTread("t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }

    static class TestTread extends Thread {

        public TestTread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()
                        + "(" + Thread.currentThread().getPriority() + ")"
                        + ", loop " + i);
            }
        }
    }
}
