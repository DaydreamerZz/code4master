import java.util.Scanner;

public class MyThread implements Runnable {

    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(LCS("1A2C3D4B56", "B1D23CA45B6A"));
       /* MyThread aVolatile = new MyThread();
        new Thread(aVolatile, "thread A").start();


        System.out.println("main 线程正在运行");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String value = sc.next();
            if (value.equals("1")) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        aVolatile.stopThread();
                    }
                }).start();

                break;
            }
        }

        System.out.println("主线程退出了！");*/

    }

    private void stopThread() {
        flag = false;
    }

    public static int LCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[m][n];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], chars1[i] == chars2[0] ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], chars1[0] == chars2[i] ? 1 : 0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
