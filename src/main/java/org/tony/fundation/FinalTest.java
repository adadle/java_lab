package org.tony.fundation;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by TonyLee on 2014/10/13.
 * By IDEA
 */
public class FinalTest {


    static final Set<String> set = new TreeSet<String>();

    static final String s = "final";

    public static void main(String[] args) {
        set.add("aaa");
//        s = "xxx";
    }
}
