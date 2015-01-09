package org.tony.util;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by TonyLee on 2014/11/28.
 * By IDEA
 */
public class CTest {

    public static void main(String[] args) throws ParseException {
       long a =1000;
        String b ="10%";
        NumberFormat  nf = NumberFormat.getPercentInstance();
//        nf.setDecimalSeparatorAlwaysShown(false);
        nf.setGroupingUsed(false);
        System.out.println(nf.parse(b));


        System.out.println(Timestamp.valueOf("2014-01-01 1:00:00").toString());


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
