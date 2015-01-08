package org.tony.fundation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TonyLee on 2014/10/10.
 * By IDEA
 */
public class Obj {
    public static void main(String[] args) {
        Object o = new String("123232");
        System.out.println(o.toString());

        String a = "123a";
//        System.out.println(Long.valueOf(a));
        testPrint();
    }



    static void testPrint(){
        String [] a = new String[]{"b","a"};
        System.out.println(a);
    }

    static  void testMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","a");
        System.out.println(map);

    }
}
