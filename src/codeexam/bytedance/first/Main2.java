package codeexam.bytedance.first;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/12 9:51
 * @desc :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        line = scanner.nextLine().trim();
        int lineNumber = Integer.parseInt(line);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < lineNumber; i++){
            line = scanner.nextLine();
            String[] split = line.split(";");
            for(String s : split) {
                list.add(s);
            }
        }
        ArrayList<Integer[]> intList = new ArrayList<>();
        Integer[] number2 = null;
        for(String s : list){
            number2 = new Integer[2];
            String[] split = s.split(",");
            number2[0] = Integer.parseInt(split[0]);
            number2[1] = Integer.parseInt(split[1]);
            intList.add(number2);
        }
        intList.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        /*for(Integer[] integers : intList){
            System.out.println(Arrays.toString(integers));
        }*/

        Stack<Integer[]> stack = new Stack<>();
        stack.push(intList.get(0));
        ArrayList<Integer[]> resList = new ArrayList<>();
        for(int i = 1; i < intList.size(); i++){
            Integer[] peek = stack.peek();
            Integer[] current = intList.get(i);
            if(current[0] <= peek[1]){ //组合
                Integer[] tmp = new Integer[2];
                tmp[0] = peek[0];
                tmp[1] = current[1];
                stack.pop();
                stack.push(tmp);
            }else{
                stack.push(current);
            }
        }

        Stack<Integer[]> stack1 = new Stack<>();
        while(!stack.isEmpty()){
//            System.out.println(Arrays.toString(stackqueue.popMin()));
            stack1.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack1.isEmpty()){
            Integer[] pop = stack1.pop();
            sb.append(pop[0] + "," + pop[1] + ";");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return;
    }
}
