package codeexam.pinduoduo.sec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 8/30/2018 6:59 PM
 * desc  :
 *
3 4
COKE
TARN
SHOW
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>();
        scanner.nextLine();
        for(int i = 0; i < a; i++){
            list.add(scanner.nextLine());
        }

        /*MyComparator comparator = new MyComparator(0);
        Collections.sort(list, comparator);

        System.out.println(list);*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < b; i++){
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            sb.append(list.get(0).charAt(0));
            int size = list.size();
            for(int j = 0; j < size; j++){
                String s = list.get(j);
                String gsub = s.substring(1, s.length());
                list.remove(0);
                list.add(gsub);
            }

        }
        System.out.println(sb.toString());
        return;
    }
}
class MyComparator implements Comparator<String> {

    int index = 0;
    public MyComparator(int index){
        this.index = index;
    }
    @Override
    public int compare(String o1, String o2) {
        return o1.charAt(0) - o2.charAt(0);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
