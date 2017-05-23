package callable;

import java.util.concurrent.Callable;

/**
 * Created by yuehao on 2017/5/22.
 */
public class CallableTest implements Callable {


    private String name;

    public CallableTest(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(this.name + " is running");
        return this.name;
    }
}
