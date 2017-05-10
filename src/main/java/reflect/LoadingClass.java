package reflect;

import entity.Person;

/**
 * Created by yuehao on 2017/5/9.
 */
public class LoadingClass {


    public static void main(String[] args) {

    }


    // 加载类的3种方法
    private void loading_class_one() throws Exception {
        Class clazz = Class.forName("entity.Person");
    }

    private void loading_class_two() {
        Class clazz = new Person().getClass();
    }

    private void loading_class_three() {
        Class clazz = Person.class;
    }
}
