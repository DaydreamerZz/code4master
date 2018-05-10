package simple;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/5/5 23:42
 * @desc   :
 */
public class PartOne {

    public static void main(String[] args) {

//        System.out.println(gcd(15, 35));

        return;
    }


    public static int gcd(int p, int q){
        if(p == 0)
            return q;
        if(p < q){
            int tmp = p + q;
            p = tmp - p;
            q = tmp - p;
        }
        int r = p % q;
        while(r != 0){
            p = q;
            q = r;
            r = p % q;
        }
        return q;

    }

}

