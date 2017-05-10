package reflect;

import entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by yuehao on 2017/5/9.
 */
public class GetField {


    public static void main(String[] args) throws Exception {
//        System.out.println(getName());
        getField();
    }


    //获取类的字段
    private static Object getName() throws Exception {
        Class clazz = Class.forName("entity.Person");
        Constructor constructor = clazz
                .getDeclaredConstructor(new Class[]{String.class});

        // 由于构造函数是 private 的，所以需要获取控制权限
        constructor.setAccessible(true);

        Person person = (Person) constructor
                .newInstance(new Object[]{"I'm a reflect name!"});
        Field field = clazz.getField("name");
        Object object = field.get(person);

        Class type = field.getType();
        System.out.println(type);
        return object;
    }


    //获取一个类的所有属性
    private static void getField() throws Exception {
        Class clazz = Class.forName("entity.Person");

        Field[] field = clazz.getDeclaredFields();

        for (int i = 0; i < field.length; i++) {
            int mo = field[i].getModifiers();

            System.out.println("mo:" + mo);
            //访问权限
            String priv = Modifier.toString(mo);

            System.out.println("priv:" + priv);
            Class<?> type = field[i].getType();

            //字段的类型
            System.out.println("type.getName:" + type.getName());
            //字段名称
            System.out.println("field.getName:" + field[i].getName());
        }
    }
}
