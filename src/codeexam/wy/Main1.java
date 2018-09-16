package codeexam.wy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/16/2018 6:20 PM
 * desc  :
 */
/*
[1531324800][login],{"roleid":"1"}
[1531364400][login],{"roleid":"4"}
[1531368000][logout],{"roleid":"1"}
[1531371600][other],{"roldid":"4"}
[1531371600][logout],{"roleid":"4"}
[1531371540][login],{"roleid":"3"}
[1531375200][logout],{"roleid":"3"}
 */
public class Main1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, int[]> map = new TreeMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = reader.readLine();
        while(line != null && line.trim().length() > 0) {

            String[] split = line.split(",");
            String left = split[0];
            String right = split[1];
            int lIndex = left.lastIndexOf("[") + 1;
            int rIndex = left.lastIndexOf("]");
            String substringType = left.substring(lIndex, rIndex);
//            System.out.println(substring);
            if(substringType.equalsIgnoreCase("other")){
                line = reader.readLine();
                if(line == null || line.length() <= 1)
                    break;
                continue;
            }
            lIndex = left.indexOf("[")+1;
            rIndex = left.indexOf("]");
            String substringTime = left.substring(lIndex, rIndex);
            Integer time = Integer.valueOf(substringTime);
            lIndex = right.indexOf(":") + 2;
            rIndex = right.lastIndexOf("\"");
            String subStringId = right.substring(lIndex, rIndex);
            if(substringType.equalsIgnoreCase("login")){
                int[] values = map.get(subStringId);
                if(values == null){
                    values = new int[2];
                    values[0] = time;
                    map.put(subStringId, values);
                }else{
                    values[0] = time;

                }
            }else{
                int[] values = map.get(subStringId);
                if(values == null){
                    values = new int[2];
                    values[1] = time;
                    map.put(subStringId, values);
                }else{
                    values[1] = time;
                }
            }
            line = reader.readLine();
            if(line == null || line.length() <= 1)
                break;
        }



        Iterator<Map.Entry<String, int[]>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, int[]> next = iterator.next();
//System.out.println(next.getKey() + " " + next.getValue()[0] + " " + next.getValue()[1]);
            list.add(next.getValue());
            idList.add(next.getKey());
        }

//System.out.println();
        /*for(int i = 0; i < list.size(); i++){
            System.out.println(idList.get(i) + " : " + list.get(i)[0] + " " + list.get(i)[1]);

        }*/
//System.out.println();

        TreeMap<Double, String[]> resMap= new TreeMap<>();
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                double d = calculate(list, i , j);
                resMap.put(d, new String[]{idList.get(i), idList.get(j)});
            }
        }

        /*Iterator<Map.Entry<Double, String[]>> iterator3 = resMap.entrySet().iterator();
        while(iterator3.hasNext()){
            Map.Entry<Double, String[]> next = iterator3.next();
            System.out.println(next.getKey() + " : " + next.getValue()[0] + " " + next.getValue()[1]);
        }*/


        HashSet<String> set = new HashSet<>();
        Iterator<Map.Entry<Double, String[]>> iterator1 = resMap.entrySet().iterator();
        Map.Entry<Double, String[]> minOne = iterator1.next();
        set.add(minOne.getValue()[0]);
        set.add(minOne.getValue()[1]);
        double min = minOne.getKey();
        while (iterator1.hasNext()){
            Map.Entry<Double, String[]> next = iterator1.next();
            if(next.getKey() - min <= 0.001){
                set.add(minOne.getValue()[0]);
                set.add(minOne.getValue()[1]);
            }else
                break;

        }

        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        return;
    }

    private static double calculate(ArrayList<int[]> list, int i, int j) {
        int[] ints1 = list.get(i);
        int[] ints2 = list.get(j);
        int start1 = ints1[0];
        int end1 = ints1[1];
        int start2 = ints2[0];
        int end2 = ints2[1];
        int start = Math.min(start1, start2);
        int end = Math.max(end1, end2);

        int abs = Math.abs(end - start);

        int duration = (end1 - start1) + (end2 - start2);
        double d = (double)(abs * 2) / duration;
        return d;


        /*int[] ints1 = list.get(i);
        int[] ints2 = list.get(j);
        int start1 = ints1[0];
        int end1 = ints1[1];
        int start2 = ints2[0];
        int end2 = ints2[1];
        int start = Math.max(start1, start2);
        int end = Math.min(end1, end2);

        int abs = Math.abs(start - end);

        int duration = (end1 - start1) + (end2 - start2);
        double d = (double)(abs * 2) / duration;
        return d;*/
    }
}
