package video.video3queuestack;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 21:23
 * @desc :
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25},
        };

        System.out.println(Arrays.deepToString(matrix));
        return;
    }

    public static void rotateEdge(int[][] matrix, int lx, int ly, int rx, int ry){
        int times = ly - lx;
        int tmp;
        for(int i = 0; i < times; i++){

        }
    }
}
