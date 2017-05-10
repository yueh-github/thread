package thredWaitNotify;

/**
 * Created by yuehao on 2017/5/10.
 */
public class WaitThread {

    public static void main(String[] args) throws Exception{
        NotifyThred notifyThred = new NotifyThred("t1");

        synchronized (notifyThred){
            System.out.println("启动 " + notifyThred.getName() + "线程");
            notifyThred.start();

            System.out.println("当前线程进入等待,等待唤醒~~~");
            notifyThred.wait();

            System.out.println("线程被唤醒，继续执行哦~");

        }
    }
}
