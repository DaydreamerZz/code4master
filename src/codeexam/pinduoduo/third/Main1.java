package codeexam.pinduoduo.third;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/21 14:58
 * @desc :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().toLowerCase();
        HashSet<Character> set = new HashSet<>();
        set.add(',');
        set.add('.');
        set.add('!');
        set.add('?');
        set.add(':');
        set.add(';');
//        String line = scanner.nextLine();
        String[] split = line.split(" ");
        ArrayList<String> tmpList = new ArrayList<>();
        for(int i = 0; i < split.length; i++){
            if(split[i].length() == 0)
                continue;
            char c = split[i].charAt(split[i].length()-1);
            if(set.contains(c)){
                String substring = split[i].substring(0, split[i].length() - 1);
                split[i] = substring;

            }
            boolean flag = false;
            for(int j = 0; j < split[i].length()-1; j++){
                if(set.contains(split[j].charAt(j))){
                    String[] split1 = split[j].split(split[j].charAt(j) + "");
                    for(String s : split1){
                        tmpList.add(s);
                    }
                    flag = true;
                }
            }
            if(!flag)
                tmpList.add(split[i]);
        }

        split = new String[tmpList.size()];
        for(int i = 0; i < split.length; i++){
            split[i] = tmpList.get(i);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(String str : split){
            if(map.get(str) == null){
                map.put(str, 1);
            }else{
                map.put(str, map.get(str)+1);
            }
        }

        /*Iterator<Map.Entry<String, Integer>> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry<String, Integer> next = iterator1.next();
            String key = next.getKey();
            int value = next.getValue();
            System.out.println(key + " " + value);
        }*/

        String maxStr = "";
        int maxValue = -1;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            int value = next.getValue();
            if(value > maxValue){
                maxValue = value;
                maxStr = key;
            }
        }

//        System.out.println(maxStr);

        HashSet<String> resSet = new HashSet<>();
        Iterator<Map.Entry<String, Integer>> iterator2 = map.entrySet().iterator();
        while(iterator2.hasNext()){
            Map.Entry<String, Integer> next = iterator2.next();
            String key = next.getKey();
            int value = next.getValue();
            if(value == maxValue){
                resSet.add(key);
            }
        }
        Iterator<String> iterator1 = resSet.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next() + " ");
        }
        return;
    }
}

/*
i
 */