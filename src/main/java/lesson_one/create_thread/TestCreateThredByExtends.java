package lesson_one.create_thread;

/**
 * Created by yuehao on 2017/4/27.
 */
public class TestCreateThredByExtends {

    //CreateThredByExtends
    public static void main(String[] args) {
        CreateThredByExtends createThredByExtends0 = new CreateThredByExtends("线程0");
        createThredByExtends0.start();

        CreateThredByExtends createThredByExtends1 = new CreateThredByExtends("线程1");
        createThredByExtends1.start();
    }
}
