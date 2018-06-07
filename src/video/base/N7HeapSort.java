package video.base;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 17:05
 * @desc :
 */
public class N7HeapSort {

    public static void main(String[] args) {
//        int[] array = new int[]{5, 2, 2,2,2,2,2,5, 6,0, 3, 7, 1};
        int[] array = new int[]{5, 2, 1, 6, 3, 7, 0};
        heapSort(array);
//        System.out.println(Arrays.toString(array));
//        int i = (int)(Math.random() * (array.length));
//        array[0] = 0;
//        heapify(array, 0, array.length);

        System.out.println(Arrays.toString(array));
        return;
    }

    //index位置的值发生了变化，重新构建堆
    private static void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest;
            if(left + 1 >= heapSize)
                largest = left;
            else{
                if(array[left] > array[left+1])
                    largest = left;
                else
                    largest = left + 1;
            }
//            largest = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if(largest == index)
                break;
            swap(array, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapSort(int[] array) {
        //根据数组得到大根堆
        for(int i = 0; i < array.length; i++){
            heapInsert(array, i);
        }
        System.out.println("big heap: " + Arrays.toString(array));


        int len = array.length;
        swap(array, 0, --len);
        System.out.println(Arrays.toString(array));
        while(len > 0){
            heapify(array, 0, len); //传入的len是当前要heapify数组的长度，是数组长，所以heapify内部判断右节点是否越界的时候，要判断>=heapSize
            System.out.println(Arrays.toString(array));
            swap(array, 0, --len);
        }


        System.out.println("sorted: " + Arrays.toString(array));

    }

    private static void heapInsert(int[] array, int index) {
        while(array[index] > array[(index-1)/2]){ //这里不能用(index-1)>>1, 当index=0的时候，(0-1)/2 = 0，而（0-1) >> 1 = -1;
            swap(array, index, (index-1)>>1);
            index = (index-1) >> 1;
        }
    }

    private static void swap(int[] array, int i, int j) {
         array[i] = array[i] ^ array[j];
         array[j] = array[i] ^ array[j];
         array[i] = array[i] ^ array[j];
    }
}
