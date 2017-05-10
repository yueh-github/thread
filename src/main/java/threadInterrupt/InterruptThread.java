package threadInterrupt;

/**
 * Created by yuehao on 2017/5/10.
 */
public class InterruptThread {

    public static void main(String[] args) throws Exception {
        TestThread t1 = new TestThread("t1");

        System.out.println("启动线程 " + t1.getName());
        t1.start();
        System.out.println("查看当前线程状态 " + t1.getState());

        Thread.sleep(5000);

        t1.interrupt();

        System.out.println("查看当前线程状态 " + t1.getState());

        Thread.sleep(1000);

        System.out.println("查看当前线程状态 " + t1.getState());
    }


    //interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。
    //区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。

    static class TestThread extends Thread {
        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                int i = 0;
                while (!isInterrupted()) {
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
                }
            } catch (InterruptedException ex) {
                System.out.println("捕捉到异常，终止线程");
            }
        }
    }
}
