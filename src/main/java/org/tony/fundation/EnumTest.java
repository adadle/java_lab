package org.tony.fundation;

/**
 * Created by TonyLee on 2014/10/31.
 * By IDEA
 */
public class EnumTest {


    public static void main(String[] args) {
        System.out.println(E.A);



        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    E.A.setA(10000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    E.A.setA(0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t2.start();


        while(true){
            System.out.println("-----"+E.A.getA());
        }



    }
}


enum E{

    A(0,0),B(0,1);

    int a;
    int b;
    private E(int a, int b){
        this.a = a;
        this.b = b;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String toString(){
        return "a:"+a+",b:"+b;
    }
}
