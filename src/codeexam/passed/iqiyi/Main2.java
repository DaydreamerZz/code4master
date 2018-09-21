package codeexam.passed.iqiyi;

import java.util.*;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/15/2018 9:56 AM
 * desc  :
 */
/*
3 4 2
5 3 1
B 1
A 2
A 2
A 3
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, P;
        N = scanner.nextInt();
        M = scanner.nextInt();
        P = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> A = new ArrayList<>(N);
        for(int i = 0; i < N; i++){
            A.add(scanner.nextInt());
        }
        scanner.nextLine();
        char type;
        int value;
        for(int i = 0; i < M; i++){
            String[] split = scanner.nextLine().split(" ");
            value = Integer.parseInt(split[1]);
            if("A".equalsIgnoreCase(split[0])){ //购买
                A.set(value-1, A.get(value-1) + 1);
            }else{ //吃
                A.set(value-1, A.get(value-1) - 1);
            }

        }
        int targetValue = A.get(P-1);

        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

//        System.out.println(A);
        ArrayList<Integer> rankList = new ArrayList<>(N);
        rankList.add(0, 1);
        for(int i = 1; i < A.size(); i++){
            if(A.get(i) == A.get(i-1)){
                rankList.add(i, rankList.get(i-1));
            }else{
                rankList.add(i, rankList.get(i-1)+1);
            }
        }
//        System.out.println(rankList);

        int i = A.indexOf(targetValue);
        System.out.println(rankList.get(i));

        return;
    }
}
