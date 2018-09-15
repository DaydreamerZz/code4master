package codeexam.huawei;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/15 22:07
 * @desc :
 */
/*
BACCAAHEFGHFF
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();

            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < chars.length; i++) {
                if (map.keySet().contains(chars[i])) {
                    map.put(chars[i], map.get(chars[i]) + 1);
                    continue;
                } else {
                    map.put(chars[i], 1);
                }
            }
            boolean flag = false;
            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                if (next.getValue() == 1) {
                    System.out.println(next.getKey());
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(-1);

        }
        return;
    }
}
