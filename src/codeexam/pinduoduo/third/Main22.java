package codeexam.pinduoduo.third;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/21 14:58
 * @desc :
 */
public class Main22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        HashMap<Integer, Integer> resMap = new HashMap<>();
        int preCount = getValue(arr, 1);
        resMap.put(1, preCount);
        for (int i = 2; i < n; i++) {
            int cur = getValue(arr, i);
            /*if (cur == preCount) {
                System.out.println(i-1);
                return;
            }
            preCount = cur;*/
            if(resMap.get(cur) == null){
                resMap.put(i, cur);
            }
        }


        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = resMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            int key = next.getKey();
            int value = next.getValue();
//            System.out.println(next.getKey() + " " + next.getValue());
            if(value < min){
                min = value;
                minIndex = key;
            }
        }
        System.out.println(minIndex);
        return;

    }

    private static int getValue(int[] arr, int volumn) {
        int[] cache = new int[volumn];
        for(int i = 0; i < volumn; i++){
            cache[i] = -1;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] % volumn;
            if (cache[key] == -1) {
                cache[key] = arr[i];
                res++;
            } else{
                if(cache[key] == arr[i]){
                    continue;
                }else{
                    cache[key] = arr[i];
                    res++;
                }


                /*boolean full = true;
                for(int j = 0; j < volumn; j++){
                    if(cache[j] == -1){
                        full = false;
                        break;
                    }
                }

                if(!full){//美满
                    if()
                    cache[key] = arr[i];
//                    res++;
                }else{
                    //满了
                    cache[key] = arr[i];
                    res++;
                }*/
            }
        }
        return res;
    }
}
