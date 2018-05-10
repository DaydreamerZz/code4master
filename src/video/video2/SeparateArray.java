package video.video2;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 14:42
 * @desc : 分成左右两部分，左侧小于pivot，右侧大于pivot; 荷兰国旗问题
 */
public class SeparateArray {

    public static void main(String[] args) {
        int[] array1 = {4, 2, 9, 1, 0, 8, 5, 2};
        separate1(array1, 5);
        System.out.println(Arrays.toString(array1)); //[4, 2, 1, 0, 2, 8, 5, 9], 如果pivot在数组中，那么不能很好的处理。

        int[] array2 = {4, 2, 9, 1, 0, 8, 5, 2}; //[4, 2, 2, 1, 0, 5, 8, 9]
        separate2(array2, 2);
        System.out.println(Arrays.toString(array2));
        return;
    }

    private static void separate1(int[] array, int pivot) {
        int lessIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                if (array[lessIndex + 1] != array[i]) {
                    int tmp = array[lessIndex + 1];
                    array[lessIndex + 1] = array[i];
                    array[i] = tmp;
                }
                lessIndex++;
            }
        }
    }

    private static void separate2(int[] array, int pivot) {
        int lessIndex = -1;
        int moreIndex = array.length;
        for (int i = 0; i < moreIndex; i++) {
            if (array[i] < pivot) {
                if (array[lessIndex + 1] != array[i]) {
                    int tmp = array[lessIndex + 1];
                    array[lessIndex + 1] = array[i];
                    array[i] = tmp;
                }
                lessIndex++;
            } else if (array[i] > pivot) {
                int tmp = array[moreIndex - 1];
                array[moreIndex - 1] = array[i];
                array[i] = tmp;
                moreIndex--;
                i--;
            } else {
                continue;
            }
        }
    }
}
