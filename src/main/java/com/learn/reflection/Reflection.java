package com.learn.reflection;

import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.learn.reflection.Human");
        System.out.println(c1.hashCode());

        Class<?> c2 = Class.forName("com.learn.reflection.Human");
        System.out.println(c2.hashCode());

        Field name = c2.getField("name");
        System.out.println(name);
    }

}

interface live{

}
interface dede{

}
class Human implements live,dede{


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human(){

    }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

     public String name;
     public int age;

}