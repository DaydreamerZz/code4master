package codeexam.bytedance.first;

import java.util.Scanner;
import java.util.TreeMap;

/*

6
1,10
5,16
16,32
32,45
78,94
200,220
 */

public class Main22 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int lineNum = Integer.valueOf(s.nextLine());
        TreeMap<Integer, Integer> map = new TreeMap();
        int start = -1;
        int end = -1;
        boolean firstKey = true;
        boolean newLine = true;

        for (int i = 0; i < lineNum; i++) {
            String line = s.nextLine();
            for (String str1 : line.split(";")) {
                String a = str1.split(",")[0];
                String b = str1.split(",")[1];
                map.put(Integer.valueOf(a), Integer.valueOf(b));
            }
        }

        for (int key : map.keySet()) {
            if (newLine) {
                if (firstKey) {
                    firstKey = false;
                    start = key;
                    end = map.get(key);
                }
                newLine=false;
            }
            if (key <= end) {
                int temp = map.get(key);
                if (temp < end)
                    continue;
                end = temp;
                continue;
            }
            System.out.print(start + "," + end+";");
            start = key;
            end = map.get(key);
            newLine=true;
        }
        System.out.print(start+","+end);
    }
}