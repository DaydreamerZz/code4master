import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/7 16:43
 * @desc :
 */
public class T5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] split = scanner.nextLine().split(",");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] += arr[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
//        System.out.println(Arrays.deepToString(dp));
        return;
    }
}
