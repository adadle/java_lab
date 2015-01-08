package org.tony.util;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by TonyLee on 2014/11/28.
 * By IDEA
 */
public class CTest {

    public static void main(String[] args) {
       long a =1000;
        NumberFormat  nf = NumberFormat.getIntegerInstance();
//        nf.setDecimalSeparatorAlwaysShown(false);
        nf.setGroupingUsed(false);
        System.out.println(nf.format(a));



    }








    private static int shard(){
//        String mid = "dff2b044578f53375185690aee87dbc250edafac";
//        String mid="c0f725e81da97aa1cd55bf87919265f18b3f2e86";
        String mid="3eaa9a52-99ca-3d85-8e5a-b86901a8b709";
        int absHash = Math.abs(mid.hashCode());
        int N = 32;
        System.out.println(absHash);
        int mod = absHash%N;

        System.out.println(mod);
        return mod;
    }
}
