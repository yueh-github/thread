package lesson_one.create_thread;

/**
 * 通过继承Thread类来创建线程
 * Created by yuehao on 2017/4/27.
 */
public class CreateThredByExtends extends Thread {

    private String name;

    public CreateThredByExtends(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.yield();
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "开始启动了~" + " 第几次运行呢？第" + i + "次运行~");
        }
    }
}
