package entity;

import java.io.Serializable;

/**
 * Created by yuehao on 2017/5/9.
 */
public class Person extends Animal implements Fly, Serializable {

    public String name = "default name";
    public int[] array = new int[10];

    public Person() {
        System.out.println(name);
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println("数组长度：" + array.length);
    }

    public Person(String name) {
        this.name = name;
        System.out.println(name);
    }

    public Person(String name, Integer i) {
        System.out.println(name);
        System.out.println(i);
    }

    public void fun() {
        System.out.println("打印fun方法内容~~");
    }

    public void fun(String name) {
        System.out.println(name);
    }

    public void fun(String name, Integer i) {
        System.out.println(name);
        System.out.println(i);
    }

    @Override
    public void eat() {
        System.out.println("person 在吃西餐，或者其他食物");
    }

    @Override
    public void fly() {
        System.out.println("person 可以飞翔~~飞起来~");
    }
}
