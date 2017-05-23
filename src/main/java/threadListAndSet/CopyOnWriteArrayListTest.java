package threadListAndSet;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yuehao on 2017/5/15.
 */
public class CopyOnWriteArrayListTest {

//    private static List list = new ArrayList();

    private static List list = new CopyOnWriteArrayList();


    public static void main(String[] args) {
        TestThread t1 = new TestThread("t1");

        TestThread t2 = new TestThread("t2");

        t1.start();
        t2.start();
    }

    private static void printAll() {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    static class TestThread extends Thread {


        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                list.add(i);
                printAll();
            }
        }
    }
}
