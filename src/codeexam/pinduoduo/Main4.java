package codeexam.pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/5 20:09
 * @desc :
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = 0; i < split.length; i++){
            numberList.add(Integer.parseInt(split[i]));
        }

        ArrayList<Integer> res = new ArrayList<>();
       //System.out.println(miniTimes(numberList, 0, res));

        miniTimes(numberList, 0, res);
        System.out.println(res.toString());

        System.out.println(res.get(((res.size())/2)));

        return;
    }

    private static int miniTimes(ArrayList<Integer> numberList, int count, ArrayList<Integer> res) {
        if(numberList.size() == 0){
            res.add(count);
            return count;
        }
        int firstElem = numberList.get(0);
        //case 1 increase
        ArrayList<Integer> newListAfterIncr = new ArrayList<>();
        for(int i = 1; i < numberList.size(); i++){
            if(numberList.get(i) <= firstElem) //增序，留下小的
                newListAfterIncr.add(numberList.get(i));
            else{
                firstElem = numberList.get(i);
            }
        }
        int x = miniTimes(newListAfterIncr, count+1, res);
        //case 2 decrease
        ArrayList<Integer> newListAfterDecr = new ArrayList<>();
        for(int i = 1; i < numberList.size(); i++){
            if(numberList.get(i) >= firstElem) //降序，留下大的
                newListAfterIncr.add(numberList.get(i));
            else
                firstElem = numberList.get(i);
        }
        int y = miniTimes(newListAfterDecr, count+1, res);

        return Math.min(x, y);
    }
}
