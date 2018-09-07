import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/7 15:07
 * @desc :
 */

public class T3 {


	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC, StringBuilder sb) {
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				//System.out.print(m[tR][i] + ",");
				sb.append(m[tR][i] + ",");

			}
		} else if (tC == dC) {
			for (int i = tR; i <= dR; i++) {
				//System.out.print(m[i][tC] + ",");
				sb.append(m[i][tC] + ",");
			}
		} else {
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
//				System.out.print(m[tR][curC] + " ");
				sb.append(m[tR][curC] + ",");
				curC++;
			}
			while (curR != dR) {
//				System.out.print(m[curR][dC] + " ");
				sb.append(m[curR][dC] + ",");
				curR++;
			}
			while (curC != tC) {
//				System.out.print(m[dR][curC] + " ");
				sb.append(m[dR][curC] + ",");
				curC--;
			}
			while (curR != tR) {
//				System.out.print(m[curR][tC] + " ");
				sb.append(m[curR][tC] + ",");
				curR--;
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        while(true) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            scanner.nextLine();
            if(row == -1 && col == -1)
                break;
            int[][] array = new int[row][col];
            for(int i = 0; i < row; i++){
                String[] split = scanner.nextLine().split(" ");
                for(int j = 0; j < split.length; j++){
                    array[i][j] = Integer.parseInt(split[j]);
                }
            }

            int tR = 0;
            int tC = 0;
            int dR = row - 1;
            int dC = col - 1;
            StringBuilder sb = new StringBuilder();
            while (tR <= dR && tC <= dC) {
                printEdge(array, tR++, tC++, dR--, dC--, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }

	}

}
