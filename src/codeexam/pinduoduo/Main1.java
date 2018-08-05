package codeexam.pinduoduo;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/5 18:50
 * @desc :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = scanner.nextInt();
        int key = scanner.nextInt();
        scanner.nextLine();
        int[][] relations = new int[lineNumber][lineNumber];
        //init
        for(int i = 0; i < lineNumber; i++){
            for(int j = 0; j < lineNumber; j++){
                relations[i][j] = -1;
            }
        }

        for(int i = 0; i < lineNumber; i++){
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            for(int j = 0; j < split.length; j++){
                relations[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(getFridens(relations, lineNumber, key));
        return;
    }

    private static int getFridens(int[][] relations, int lineNumber, int key) {
        int[] target = relations[key];
        ArrayList<Integer> targetList = new ArrayList<>();
        for(int i = 0; i < target.length; i++){
            if(target[i] == -1)
                break;
            targetList.add(target[i]);
        }

        HashMap<Integer, Integer> resMap = new HashMap<>();

        for(int i = 0; i < lineNumber; i++){
            if(i == key)
                continue;
            int[] tmp = relations[i];
            int value = compare(target, tmp);
            resMap.put(i, value);
//            resList.add(value);
        }

        Set<Integer> integers = resMap.keySet();
        Iterator<Integer> iterator = integers.iterator();
        int largestValue = -1;
        int largestIndex = -1;
        while(iterator.hasNext()){

            Integer next = iterator.next();
            if(targetList.contains(next))
                continue;
            int curValue = resMap.get(next);
            if(curValue > largestValue){
                largestValue = curValue;
                largestIndex = next;

            }
        }
        /*for(int i = 0; i < resList.size(); i++){
            if(resList.get(i) > largestValue){
                largestValue = resList.get(i);
                largestIndex = i;
            }
        }*/


        if(largestValue == 0)
            return -1;
        else
            return largestIndex;
    }

    private static int compare(int[] target, int[] tmp) {
        int res = 0;
        for(int i = 0; i < target.length; i++){
            int x = target[i];
            if(x == -1)
                break;
            for(int j = 0; j < target.length; j++){
                if(tmp[j] == -1)
                    break;
                if(tmp[j] == x)
                    res ++;
            }
        }
        return res;
    }
}
