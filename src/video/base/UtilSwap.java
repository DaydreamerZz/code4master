package video.base;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/6/8 19:19
 * @desc :
 */
public class UtilSwap {

    //如果arr中交换的包含0，那么以后就GG了
    /*public static void swapInt(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }*/

    public static void swapInt(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void main(String[] args) {

        return;
    }
}
