package reflect;

import entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yuehao on 2017/5/9.
 */
public class GetMethod {


    public static void main(String[] args) throws Exception {
        getMethod();
        getMethod("执行带参数的方法");
    }

    //获取并调用类的无参方法
    private static void getMethod() throws Exception {
        Class clazz = Class.forName("entity.Person");
        Constructor constructor = clazz.getConstructor(null);
        Person person = (Person) constructor.newInstance(null);
        Method method = clazz.getMethod("fun", null);
        method.invoke(person, null);
    }


    //获取并调用类的含参方法
    private static void getMethod(String string) throws Exception {
        Class clazz = Class.forName("entity.Person");
        Constructor constructor = clazz.getConstructor(null);
        Person person = (Person) constructor.newInstance(null);
        Method method = clazz.getMethod("fun", new Class[]{String.class,Integer.class});
        method.invoke(person,new Object[]{string,1});
    }
}
