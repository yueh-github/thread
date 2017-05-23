package executor;

/**
 * Created by yuehao on 2017/5/22.
 */
public class MyRunnable implements Runnable {


    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is running");
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
