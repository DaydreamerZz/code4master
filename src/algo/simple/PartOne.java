package algo.simple;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/5/5 23:42
 * @desc   :
 */
public class PartOne {

    public static void main(String[] args) {

        int a = 15;
        int b = 35;
        int c = a + b;
        a = a > b ? a : b;
        b = c - a;

        int d = gcd(a, b);
        System.out.println(d);
        System.out.println(d + " " + a * b / d);

        return;
    }


    public static int gcd(int p, int q){
        if(p == 0)
            return q;
        //ensure p bigger than q
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

