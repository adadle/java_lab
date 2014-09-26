package org.tony.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by TonyLee on 2014/9/26.
 * By IDEA
 */
public class StartThread {

    public static void main(String[] args) {

        //线程启动的两种方式
//        A a = new A();
//        a.start();


//        new Thread(new B()).start();

        //使用Executor
//        ExecutorService exec = Executors.newCachedThreadPool();

//        ExecutorService exec = Executors.newFixedThreadPool(3);

        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new ListOff());
        }
        exec.shutdown();





    }
}

class ListOff implements Runnable {

    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public ListOff() {}

    //通过构造函数修改静态变量
    public ListOff(int countDown) {
        this.countDown = countDown;
    }


    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : " LiftOff !");
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status() + "\t");
            Thread.yield();
        }
    }
}


class B implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("---");
            Thread.yield();
        }
    }
}


class A extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("---");
        }
    }

}


