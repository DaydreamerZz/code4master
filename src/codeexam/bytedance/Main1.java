package codeexam.bytedance;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/12 9:51
 * @desc :
 */

public class Main1 {

    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M); //right
        infect(m, i - 1, j, N, M); //left
        infect(m, i, j + 1, N, M); //upper
        infect(m, i, j - 1, N, M); //under
        infect(m, i + 1, j + 1, N, M);
        infect(m, i + 1, j - 1, N, M);
        infect(m, i - 1, j + 1, N, M);
        infect(m, i - 1, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {
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
        };
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));

    }

}
