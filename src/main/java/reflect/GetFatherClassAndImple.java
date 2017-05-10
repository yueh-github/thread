package reflect;

/**
 * Created by yuehao on 2017/5/9.
 */
public class GetFatherClassAndImple {

    public static void main(String[] args) throws Exception {
        Class<?> fatherClass = getFatherClass();
        System.out.println("fatherClass:" + fatherClass.getName());


        getImple();
    }


    //获取父类
    private static Class<?> getFatherClass() throws Exception {

        Class<?> clazz = Class.forName("entity.Person");


        Class<?> fatherClazz = clazz.getSuperclass();


        return fatherClazz;
    }

    //获取实现的接口
    private static void getImple() throws Exception {
        Class<?> clazz = Class.forName("entity.Person");
        Class<?> intes[] = clazz.getInterfaces();

        for (int i = 0; i < intes.length; i++) {
            System.out.println(intes[i].getName());
        }
    }
}
