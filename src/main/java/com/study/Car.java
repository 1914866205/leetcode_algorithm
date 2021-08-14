package com.study;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName Car.java
 * @Description TODO
 * @createTime 2021年06月19日 19:43:00
 */
public class Car {
    public static void main(String[] args) {
        //car.class的模板反射对象，全局唯一
        //类是一个模板，是抽象的，对象是具体的
        Class<Car> carClass = Car.class;
        System.out.println(carClass);
        System.out.println("***********************");
        //car的名字在栈里面，数据引用在堆中
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        System.out.println("***********************");
        // 对象转化为模板
        Class<? extends Car> a1Class = car1.getClass();
        Class<? extends Car> a2Class = car2.getClass();
        Class<? extends Car> a3Class = car3.getClass();
        System.out.println(a1Class.hashCode());
        System.out.println(a2Class.hashCode());
        System.out.println(a3Class.hashCode());
        System.out.println("***********************");
        //模板转化为类加载器
        ClassLoader classLoader = a1Class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        //AppClassLoader 应用程序加载器
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        //ExtClassLoader 扩展加载器
        System.out.println(parent1);
        System.out.println("***********************");
    }
}
