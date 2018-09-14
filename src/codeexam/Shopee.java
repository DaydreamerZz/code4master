package codeexam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/12 17:17
 * @desc :
 */
public class Shopee {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();


        try {
            if (line.indexOf(" ") != -1) { //10 转 16 0 255 0 to 00FF00
                String[] split = line.split(" ");
                if (split.length != 3) {
                    System.out.println("error");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    if (split[i].length() > 3) {
                        System.out.println("error");
                        return;
                    } else {
                        int tmp = Integer.parseInt(split[i]);
                        if (tmp > 255 || tmp < 0) {
                            System.out.println("error");
                            return;
                        }
                        String s = Integer.toHexString(tmp);
                        if (s.length() == 1) {
                            sb.append("0");
                        }
                        String s1 = s.toUpperCase();
                        sb.append(s1);
                    }
                }
                System.out.println(sb.toString());


            } else { //16 转 10 334455 to 51 68 85
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i <= 9; i++) {
                    set.add((char) ('0' + i));
                }
                for (char i = 'A'; i <= 'F'; i++) {
                    set.add(i);
                    set.add((char) (i + 32));
                }

                if (line.length() != 6) {
                    System.out.println("error");
                    return;
                }
                for (int i = 0; i < 6; i++) {
                    char c = line.charAt(i);
                    if (!set.contains(c)) {
                        System.out.println("error");
                        return;
                    }
                }
                int x, y, z;
                String substring = line.substring(0, 2);
                x = Integer.parseInt(substring, 16);
                substring = line.substring(2, 4);
                y = Integer.parseInt(substring, 16);
                substring = line.substring(4, 6);
                z = Integer.parseInt(substring, 16);

                StringBuilder sb = new StringBuilder();
                if (x < 256 && y < 256 && z < 256) {
                    sb.append(x + " " + y + " " + z);
                    System.out.println(sb.toString());
                } else {
                    System.out.println("error");
                    return;
                }

            }
        }catch (Exception e){
            System.out.println("error");
            return;
        }
        return;
    }


}
