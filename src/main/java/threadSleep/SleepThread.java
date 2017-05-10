package threadSleep;

/**
 * Created by yuehao on 2017/5/10.
 */
public class SleepThread {

    public static void main(String[] args) {

        TestThread t1 = new TestThread("t1");

        TestThread t2 = new TestThread("t2");

        t1.start();

        t2.start();
    }


    //sleep() 的作用是让当前线程休眠，即当前线程会从“运行状态”进入到“休眠(阻塞)状态”。sleep()会指定休眠时间，
    // 线程休眠的时间会大于/等于该休眠时间；在线程重新被唤醒时，它会由“阻塞状态”变成“就绪状态”，从而等待cpu的调度执行。


    //程序比较简单，在主线程main中启动线程t1。t1启动之后，当t1中的计算i能被4整除时，t1会通过Thread.sleep(5000)休眠5秒。

    static class TestThread extends Thread {
        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                if (i % 4 == 0)
                    try {
                        Thread.sleep(5000);
                    } catch (Exception ex) {

                    }
            }
        }
    }
}
