package codeexam.bytedance.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/12 9:51
 * @desc :
 */

public class Main11 {

    public static int count(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        int[] value = new int[1];
        value[0] = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    value[0] = 0;
                    infect(m, i, j, N, M, value);
//                    System.out.println(value[0]);
                    list.add(value[0]);
                }
            }
        }
        /*list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/
        System.out.println(res);
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M, int[] value) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        value[0] += 1;
        m[i][j] = 2;
        infect(m, i + 1, j, N, M, value); //right
        infect(m, i - 1, j, N, M, value); //left
        infect(m, i, j + 1, N, M, value); //upper
        infect(m, i, j - 1, N, M, value); //under
        infect(m, i + 1, j + 1, N, M, value);
        infect(m, i + 1, j - 1, N, M, value);
        infect(m, i - 1, j + 1, N, M, value);
        infect(m, i - 1, j - 1, N, M, value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        line = scanner.nextLine();
        String[] split = line.split(",");
        int m = Integer.parseInt(split[0]);
//        int n = Integer.parseInt(split[1]);
        int[][] arr = new int[m][m];
        for(int i = 0; i < m; i++){
            line = scanner.nextLine();
            split = line.split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

//        Arrays.deepToString(arr);

        /*int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        };*/
        count(arr);

    }

}
