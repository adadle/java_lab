package org.tony.fundation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by TonyLee on 2014/10/11.
 * By IDEA
 */
public class Exceptions {


    public static void main(String[] args)  {
        //主动抛异常后，程序继续执行？
        //需要做异常处理，如果该处进行catch，则继续执行；如果该方法向上抛出，执行时

//       test(args);
        /*try {
            test1(args);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        test4();

    }



    static void test4(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        String s ="2014-11-26 11:34:20";
        String s1 ="2014-11-26 11:34:50";
        try {

            int  flag = timeFormat.parse(s).compareTo(timeFormat.parse(s1));
            System.out.println(flag);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    static  void test(String [] args){
        if(args.length == 0){
            try {
                throw new Exception("error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("run ");
    }

    static  void test1(String [] args) throws Exception {
        if(args.length == 0){
            throw new Exception("error");
        }

        System.out.println("run ");
    }
}
