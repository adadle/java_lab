package org.tony.concurrency;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by TonyLee on 2014/10/13.
 * By IDEA
 */
public class Collections {


    public static enum BOLT_COMMAND{
        $TRIGGER_TIME_INTERVAL$,//indicate time pass
        $TRIGGER_COMMAND$//command
    }

    public static void main(String[] args) {
//        test1();
//        test12();
//        System.out.println(BOLT_COMMAND.$TRIGGER_COMMAND$.toString());

        test();
        test11();
    }

    static void test11(){
        List<Map<String,String>> list = new LinkedList<Map<String, String>>();

        list.add(new HashMap<String, String>());

        Map<String, String> timeMap = list.get(0);
        timeMap.put("1","1");
//        timeMap.clear();

        System.out.println(list.get(0));

    }



    static void test(){
        AtomicReference<Map<String,String>> atomTimeMap = new AtomicReference<Map<String,String>>();
        atomTimeMap.set(new HashMap<String,String>());

        Map<String, String> timeMap = atomTimeMap.get();
        timeMap.put("1","1");
        timeMap.clear();


        System.out.println(atomTimeMap.get().get("1"));



    }


    static void test12(){
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<String>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set.size());
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
    }

    static void test1(){
        Set<String> set = new TreeSet<String>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set.size());
    }



}
