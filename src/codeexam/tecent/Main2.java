package codeexam.tecent;

import java.util.*;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/16/2018 9:59 AM
 * desc  :
 */
/*
4 3
2 1
3 2
4 3
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        int[][] arr = new int[m][2];
        for(int i = 0; i < m; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            scanner.nextLine();
        }

        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = arr[i][0];
            int y = arr[i][1];
            list.add(new int[]{x, y});
            while(true) {
                int next = getNext(y, arr);
                if(next == x || next == -1){
                    break;
                }
                int[] tmpArr = new int[2];
                tmpArr[0] = x;
                tmpArr[1] = next;
                list.add(tmpArr);
                y = next;
            }
        }
        //System.out.println(list);
        int[][] res = new int[n][2];
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            res[x-1][0]++;
            res[y-1][1]++;
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            if(res[i][0] < res[i][1])
                count++;
        }
        System.out.println(count);


//        for()


        /*HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            int[] ints = list.get(i);
            if(map.get(ints[0]) == null){
                map.put(ints[0], 1);
            }else{
                map.put(ints[0], map.get(ints[0]) + 1);
            }
        }*/

        return;
    }

    private static int getNext(int y, int[][] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] == y){
                return arr[i][1];
            }
        }
        return -1;
    }
}
