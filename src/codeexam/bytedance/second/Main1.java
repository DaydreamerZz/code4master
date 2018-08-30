package codeexam.bytedance.second;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/25 9:38
 * @desc :
10
0
5 3 0
8 4 0
9 0
9 0
3 0
0
7 9 0
0
9 7 0
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        boolean[] isVisited = new boolean[len+1];
        for(int i = 0; i < len; i++){
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            LinkedList<Integer> curLink = new LinkedList<>();
            for(String tmp : split){
                int tmpValue = Integer.parseInt(tmp);
                if(tmpValue != 0)
                    curLink.add(tmpValue);
                else
                    break;
            }
            map.put(i+1, curLink);
        }
        Map<Integer, LinkedList<Integer>> resMap = new HashMap<>();

        Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, LinkedList<Integer>> next = iterator.next();
            int key = next.getKey();

            if(isVisited[key]){
                continue;
            }
            LinkedList<Integer> valueList = next.getValue();
            if(valueList.isEmpty()){
                resMap.put(key, null);
                isVisited[key] = true;
            }else{
                LinkedList<Integer> tmpList = resMap.get(key);
                if(tmpList == null){
                    tmpList = new LinkedList<>();
                }
                isVisited[key] = true;
                Queue<Integer> queue = new ArrayDeque<>();
                for(int i = 0; i < valueList.size(); i++){
                    queue.add(valueList.get(i));
                }
                while(!queue.isEmpty()){
                    Integer poll = queue.poll();
                    tmpList.add(poll);

                    LinkedList<Integer> integers = map.get(poll);
                    if(isVisited[poll])
                        continue;
                    else {
                        isVisited[poll] = true;
                        for (Integer x : integers) {
                            queue.add(x);
                        }
                    }
                }
                resMap.put(key, tmpList);
            }

        }

        Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator2 = resMap.entrySet().iterator();
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        while(iterator2.hasNext()){
            Map.Entry<Integer, LinkedList<Integer>> next = iterator2.next();
            Integer key = next.getKey();
            LinkedList<Integer> valueList = next.getValue();
            list.add(valueList);

        }
        int count = list.size();
        for(int i = 0; i < list.size(); i++){
            LinkedList<Integer> integers = list.get(i);
            if(integers == null){
                continue;
            }
            for(int j = 0; j < list.size(); j++){
                LinkedList<Integer> integers1 = list.get(j);
                if(integers1 == null)
                    continue;
                if(j == i)
                    continue;
                boolean flag = true;
                for(Integer tmp : integers){
                    if(!integers1.contains(tmp)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    count--;
                }
            }
        }

//        Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator3 = resMap.entrySet().iterator();
//        while(iterator3.hasNext()){
//            Map.Entry<Integer, LinkedList<Integer>> next = iterator3.next();
//            System.out.println(next.getKey() + " " +next.getValue());
//        }


        /*Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, LinkedList<Integer>> next = iterator.next();
            System.out.println(next.getKey() + " " +next.getValue());
        }*/

        System.out.println(count);
//        System.out.println(resMap.size());
        return;
    }
}

