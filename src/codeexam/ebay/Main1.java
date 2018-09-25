package codeexam.ebay;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/25/2018 7:00 PM
 * desc  :
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

        int[][] array = new int[3][3];
        int i = countIslands(array);
        System.out.println((int)(Math.random()*3));

    }
}
