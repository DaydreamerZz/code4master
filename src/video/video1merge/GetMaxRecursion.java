package video.video1merge;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 13:02
 * @desc :
 */
public class GetMaxRecursion {

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        System.out.println(getMax(array, 0, array.length-1));
        return;
    }

    private static int getMax(int[] array, int left, int right) {
        if(left == right)
            return array[left];

        int mid = left + ((right - left) >> 1);
        int leftMax = getMax(array, left, mid);
        int rightMax = getMax(array, mid+1, right);
        return leftMax > rightMax ? leftMax : rightMax;
    }
}
