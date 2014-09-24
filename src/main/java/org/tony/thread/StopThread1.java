package org.tony.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by TonyLee on 2014/9/24.
 * By IDEA
 */
public class StopThread1 {

    private static boolean req;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("req now is : "+req);
        Thread runThread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i =0 ;
                while (!req){
                    i++;
                    System.out.println("now i: "+i);
                }
            }
        });

        runThread.start();
        TimeUnit.SECONDS.sleep(1);
        req = true;
    }

}
