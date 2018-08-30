package algo.bbase.dp;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/30 17:43
 * @desc :
 */
public class N5LongestIncSeq {

    public static void main(String[] args) {

        N5LongestIncSeq longestIncSeq = new N5LongestIncSeq();
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        longestIncSeq.getLIS(arr);


        return;
    }

    private void getLIS(int[] arr) {
        int[] dp = getdp(arr);
    }

    private int[] getdp(int[] arr) {
        int[] dp = new int[arr.length];

        return dp;
    }
}
