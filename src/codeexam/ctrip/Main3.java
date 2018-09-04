package codeexam.ctrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/4/2018 7:46 PM
 * desc  :
 */
/*
2
p 1 1
p 2 2
g 1
p 2 102
p 3 3
g 1
g 2
g 3
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = reader.readLine();
        int len = Integer.parseInt(line);

        String op, key, value = null;
//        Queue<String[]> lru = new ArrayDeque<String[]>();
        ArrayList<String> lru = new ArrayList<>();
        HashMap<String, String> lruValue = new HashMap<>();

        line = reader.readLine();
        while(line != null && line.trim().length() > 0){
            String[] split = line.split(" ");

            op = split[0];
            if(op.equalsIgnoreCase("p")){
                key = split[1];
                value = split[2];
                //
                if(lru.size() >= len && !lru.contains(key)){ //如果长度超过
                    lru.remove(len-1);
                    lru.add(0, key);
                    lruValue.put(key, value);
                }else if(lru.size() >= len && lru.contains(key)){
                    lruValue.put(key, value);
//                    lru.remove(key);
                }else if(lru.size() < len && !lru.contains(key)){ //没超过
                    lruValue.put(key, value);
                    lru.add(0, key);
                }else{
                    lruValue.put(key, value);
                }
            }else{
                key = split[1];

                if(!lru.contains(key))
                    System.out.println("-1");
                else {
                    String s = lruValue.get(key);
                    lru.remove(key);
                    lru.add(0, key);
                    System.out.println(s);
                }
            }
            line = reader.readLine();
        }

        /*while (scanner.hasNext()){
            line = scanner.nextLine();
            String[] split = line.split(" ");

            op = split[0];
            if(op.equalsIgnoreCase("p")){
                key = split[1];
                value = split[2];
                //

                if(lru.size() >= len && !lru.contains(key)){ //如果长度超过
                    lru.remove(len-1);
                    lru.add(0, key);
                    lruValue.put(key, value);
                }else if(lru.size() >= len && lru.contains(key)){
                    lruValue.put(key, value);
//                    lru.remove(key);
                }else if(lru.size() < len && !lru.contains(key)){ //没超过
                    lruValue.put(key, value);
                    lru.add(0, key);
                }else{
                    lruValue.put(key, value);
                }
                *//*if(lru.size() >= len && !lru.contains(key)){ //如果长度超过
                    lru.remove(len-1);
                    lru.add(0, key);
                    lruValue.put(key, value);
                }else{
                    lruValue.put(key, value);
//                    lru.remove(key);
                    if(lru.contains(key))
                        continue;
                    lru.add(key);
                }*//*
            }else{
                key = split[1];

                if(!lru.contains(key))
                    System.out.println("-1");
                else {
                    String s = lruValue.get(key);
                    lru.remove(key);
                    lru.add(0, key);
                    System.out.println(s);
                }
            }

        }*/
        return;
    }
}
