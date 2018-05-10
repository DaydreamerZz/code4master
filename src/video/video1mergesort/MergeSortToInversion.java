package video.video1mergesort;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 10:57
 * @desc : 逆序对的个数
 * [4, 3, 5, 2, 1]
 * 4右边比4小的数：3, 2, 1
 * 3右边比3小的数：2, 1
 * 5右边比5小的数：2, 1
 * 2右边比2小的数：1
 * 1右边比1小的数：
 * 总共8对
 */
public class MergeSortToInversion {

    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 5, 2, 1};
        System.out.println(mergeSort(array, 0, array.length-1));
        System.out.println(Arrays.toString(array));
        return;
    }

    private static int mergeSort(int[] array, int left, int right) {
        if(left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        return mergeSort(array, left, mid)
                + mergeSort(array, mid+1, right)
                + merge(array, left, mid, right);
    }
    private static int merge(int[] array, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int l1 = left, l2 = mid + 1;
        int helperIndex  = 0;
        int result = 0;

        while(l1 <= mid && l2 <= right){
            result += array[l1] > array[l2] ? (right-l2+1) : 0;
            helper[helperIndex++] = (array[l1] < array[l2] ? array[l2++] : array[l1++]);
        }
        while(l1 <= mid){
            helper[helperIndex++] = array[l1++];
        }
        while(l2 <= right){
            helper[helperIndex++] = array[l2++];
        }
        for(int i = 0; i < helper.length; i++){
            array[left+i] = helper[i];
        }
        return result;
    }
}
