package reflect;

import com.alibaba.fastjson.JSON;
import entity.Person;

import java.lang.reflect.Constructor;

/**
 * Created by yuehao on 2017/5/9.
 */
public class ConstructorClass {

    public static void main(String[] args) throws Exception {
//        Person person = constructor();
//        person.fun();

        constructorClass();
    }

    //获取类的无参构造函数，并实例化类
    private static Person constructor() throws Exception {
        Class clazz = Class.forName("entity.Person");
        Constructor constructor = clazz.getConstructor(null);
        Person person = (Person) constructor.newInstance(null);
        return person;
    }


    private static void constructorClass() throws Exception {

        Class<?> clazz = Class.forName("entity.Person");

        Constructor<?> cons[] = clazz.getConstructors();

        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1) {
                    System.out.print(clazzs[j].getName());
                } else {
                    System.out.print(clazzs[j].getName() + ",");
                }
            }
        }
    }
}
