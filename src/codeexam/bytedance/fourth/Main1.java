package codeexam.bytedance.fourth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/20 18:56
 * @desc :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split("/");
//System.out.println(Arrays.toString(split));

        ArrayList<String> resList = new ArrayList<>();
        boolean flag = false;
        for(String str : split){
            if(str.equals("")){
                continue;
            }else if(str.equals(".")){
                continue;
            }else if(str.equals("..")){
                if(resList.size() == 0){
                    flag = true;
                    break;
                }
                resList.remove(resList.size()-1);
            }else {
                resList.add(str);
            }
        }
//System.out.println(resList);
        if(flag || resList.size() == 0){
            System.out.println("/");
            return;
        }
        StringBuilder sb = new StringBuilder();

        sb.append("/");
        for(String str : resList){
            sb.append(str + "/");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return;
    }
}
