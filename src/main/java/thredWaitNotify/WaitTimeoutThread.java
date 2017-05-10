package thredWaitNotify;

/**
 * Created by yuehao on 2017/5/10.
 */
public class WaitTimeoutThread {

    public static void main(String[] args) throws Exception{
        DemoThread demoThread = new DemoThread("t1");

        synchronized (demoThread) {
            System.out.println("启动" + demoThread.getName() + "线程");
            demoThread.start();

            System.out.println("线程进入等待，等待10秒~");
            demoThread.wait(2000);

            System.out.println("等待10秒完毕，开始执行~~~~~~");
        }
    }
}
