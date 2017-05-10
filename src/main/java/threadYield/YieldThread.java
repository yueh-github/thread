package threadYield;

/**
 * Created by yuehao on 2017/5/10.
 */

public class YieldThread {

    public static void main(String[] args) {

        TestThread t1 = new TestThread("t1");

        TestThread t2 = new TestThread("t2");

        t1.start();
        t2.start();

    }

    //在使用yield的时候虽然你做了线程让步，但是不一定会让步成功，因为你只是让自己的线程处于了就绪状态，还是有几率会被cpu选中进行执行任务~
    //“线程t1”在能被4整数的时候，并没有切换到“线程t2”。这表明，yield()虽然可以让线程由“运行状态”进入到“就绪状态”；
    // 但是，它不一定会让其它线程获取CPU执行权(即，其它线程进入到“运行状态”)，即使这个“其它线程”与当前调用yield()的线程具有相同的优先级。


    static class TestThread extends Thread {
        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);

                if (i % 4 == 0)
                    Thread.yield();
            }
        }
    }
}
