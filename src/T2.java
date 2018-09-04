/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/4/2018 7:07 PM
 * desc  :
 */
public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();
        /*int[] a = new int[]{

        }
        t2.sort();*/
        return;
    }

    public void sort(Comparable[] a) {
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

    public boolean compareElement(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
