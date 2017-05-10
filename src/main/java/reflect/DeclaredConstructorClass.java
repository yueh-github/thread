package reflect;

import entity.Person;

import java.lang.reflect.Constructor;

/**
 * Created by yuehao on 2017/5/9.
 */
public class DeclaredConstructorClass {


    public static void main(String[] args) throws Exception{
        Person person = constructorClass();
        person.fun();
    }

    //获取类的含参私有构造函数，并实例化类

    private static Person constructorClass() throws Exception {
        Class clazz = Class.forName("entity.Person");
        Constructor constructor = clazz
                .getDeclaredConstructor(new Class[]{String.class});
        constructor.setAccessible(true);

        Person person = (Person) constructor
                .newInstance(new Object[]{"I'm a reflect name!"});
        return person;
    }
}
