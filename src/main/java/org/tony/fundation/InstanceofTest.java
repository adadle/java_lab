package org.tony.fundation;

/**
 * Created by TonyLee on 2014/9/24.
 * By IDEA
 *
 *
 *
 * instanceof的使用学习
 */
public class InstanceofTest {

    public static void main(String[] args) {
        //子类继承
        Son son = new Son();
        System.out.println(son instanceof Parent); //true

        //接口实现的为true
        String a="1";
        System.out.println(a instanceof CharSequence); //true
    }
}

abstract  class Parent{

}


class Son extends  Parent{

}
