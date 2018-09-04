package codeexam.ctrip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/4/2018 7:32 PM
 * desc  :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        int target = Integer.parseInt(scanner.nextLine());
        int number, start, end;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < count;  i++){
            number = scanner.nextInt();
            start = scanner.nextInt();
            end = scanner.nextInt();
            scanner.nextLine();
//            System.out.println(number + start);
            if(start <= target && end >= target){
                list.add(number);
            }
        }

        if(list.size() == 0){
            System.out.println("null");
            return;
        }
        Collections.sort(list);
        for(Integer i : list){
            System.out.println(i);
        }
        return;
    }
}
