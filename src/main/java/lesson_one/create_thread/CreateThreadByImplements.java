package lesson_one.create_thread;

/**
 * 通过实现runnable接口来创建线程
 * Created by yuehao on 2017/4/27.
 */
public class CreateThreadByImplements implements Runnable {

    private String name;

    public CreateThreadByImplements(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "开始启动了~" + " 第几次运行呢？第" + i + "次运行~");
        }
    }
}
