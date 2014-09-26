package org.tony.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by TonyLee on 2014/9/24.
 * By IDEA
 */
public class StopThread1 {

    private  boolean req;

    public static void main(String[] args) throws InterruptedException {
        final StopThread1 s = new StopThread1();
        System.out.println("req now is : "+ s.req);
        Thread runThread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i =0 ;
                while (! s.req){
                    i++;
                    System.out.println("now i: "+i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        runThread.start();
        //JAVA SE 5/6 style.
        TimeUnit.SECONDS.sleep(1);

        s.req = true;
    }

}
