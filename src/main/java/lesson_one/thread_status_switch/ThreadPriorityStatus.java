package lesson_one.thread_status_switch;

/**
 * Created by yuehao on 2017/4/27.
 */
public class ThreadPriorityStatus extends Thread {


    private String name;

    public ThreadPriorityStatus(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程为：" + name);
        }
    }
}
