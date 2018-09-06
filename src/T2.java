import java.util.Arrays;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/4/2018 7:07 PM
 * desc  :
 */
public class T2 {

<<<<<<< HEAD
    public static void main(String[] args) {
        T2 t2 = new T2();
        int[] a = new int[]{15, 0, 6, 9, 3};
        t2.sort(a);
        System.out.println(Arrays.toString(a));
        return;
    }

    public void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;// 1, 4, 13, 40, ...
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i;  j >= h && compareElement(a[j],  a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public boolean compareElement(int v, int w) {
        return (v - w) > 0;
    }

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
=======
    {
        System.out.println("in brace");
    }

    static {
        System.out.println("in static");
    }
    public static void main(String[] args) {
        T2 t2 = new T2();
    }


>>>>>>> 147dc68ff057ec2b517a0adccb1955578eb99845
}
