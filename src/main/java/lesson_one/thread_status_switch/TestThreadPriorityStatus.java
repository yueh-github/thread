package lesson_one.thread_status_switch;

/**
 * Created by yuehao on 2017/4/27.
 */
public class TestThreadPriorityStatus {

    public static void main(String[] args) {
        ThreadPriorityStatus threadPriorityStatus0 = new ThreadPriorityStatus("线程0");
        threadPriorityStatus0.start();
    }
}
