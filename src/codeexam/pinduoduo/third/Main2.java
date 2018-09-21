package codeexam.pinduoduo.third;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/21 14:58
 * @desc :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }



        int preCount = getValue(arr, 1);
        for (int i = 2; i < n; i++) {
            int cur = getValue(arr, i);
            if (cur == preCount) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(n);
        return;

    }

    private static int getValue(int[] arr, int volumn) {
        ArrayList<String> list = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(volumn*2, 0.75f, true);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.size() == 0) {
                list.add(String.valueOf(arr[i]));
                map.put(String.valueOf(arr[i]), 1);
                res++;
            } else if (map.size() < volumn) {

                if(map.get(String.valueOf(arr[i])) != null){
                    continue;
                }else {
                    map.put(String.valueOf(arr[i]), 1);
                    res++;
                }
               /*
                if (list.contains(String.valueOf(arr[i]))) {
                    continue;
                } else {
                    list.add(String.valueOf(arr[i]));
                    res++;
                }*/

            } else{
                String key = "";
                Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    key = iterator.next().getKey();
                }
                map.remove(key);
                map.put(String.valueOf(arr[i]), 1);

                //map.remove(volumn);
                /*list.remove(list.size()-1);
                list.add(String.valueOf(arr[i]));*/
                res++;
            }
        }
        return res;
    }
}
