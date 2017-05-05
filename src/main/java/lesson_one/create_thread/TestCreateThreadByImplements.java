package lesson_one.create_thread;

/**
 * Created by yuehao on 2017/4/27.
 */
public class TestCreateThreadByImplements {

    public static void main(String[] args) {
        CreateThreadByImplements createThreadByImplements0 = new CreateThreadByImplements("线程0");
        Thread thread0 = new Thread(createThreadByImplements0);
        thread0.start();

        CreateThreadByImplements createThreadByImplements1 = new CreateThreadByImplements("线程1");
        Thread thread1 = new Thread(createThreadByImplements1);
        thread1.start();
    }
}
