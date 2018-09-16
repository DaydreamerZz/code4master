package codeexam.wy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/16/2018 6:20 PM
 * desc  :
 */

/*
7
1 21 168 110
2 24 170 120
3 26 170 130
4 22 173 120
5 23 180 130
6 24 100 32
7 18 210 140

2
1 1 2 1
2 2 1 3


1
1 21 168 110

3
1 21 168 110
2 24 170 120
3 26 170 130

 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if(n == 1)
            return;
        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
            arr[i][3] = scanner.nextInt();
            scanner.nextLine();
        }
        ArrayList<ArrayList<double[]>> res = new ArrayList<>();
//        ArrayList<double[]> resList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<double[]> resList = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                else{
                    double value = getValue(i, j, arr);
                    /*if(value - 20.0 > 0.001)
                        continue;*/

                    double[] curRes = new double[3];
                    curRes[0] = arr[i][0];
                    curRes[1] = arr[j][0];
                    curRes[2] = value;
                    resList.add(curRes);
                }
            }
            res.add(resList);
        }
        //System.out.println();
        double min = Double.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < res.size(); i++) {
            min = Double.MAX_VALUE;
            index = 0;
            ArrayList<double[]> doubles = res.get(i);
            for (int j = 0; j < doubles.size(); j++) {

                double[] doubles1 = doubles.get(j);
//                System.out.println(doubles1[0] + " " + doubles1[1] + " " + doubles1[2]);
                if (Double.compare(doubles1[2], min) < 0) {
                    min = doubles1[2];
                    index = j;
                }

            }
            double[] minOne = doubles.get(index);
            int first = (int) minOne[0];
            int second = (int) minOne[1];
            double third =  minOne[2];
            /*NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            nf.setRoundingMode(RoundingMode.UP);
            String format = nf.format(third);*/

            third = (double) Math.round(third*100) / 100;
            if(third > 20.0 && third - 20.0 > 0.001){
                continue;
            }

            String str = String.valueOf(third);
            int pointIndex =  str.indexOf(".");
            if(pointIndex == -1){
                StringBuilder sb = new StringBuilder(str);
                sb.append(".00");
                str = sb.toString();
            }
            if(str.length() - pointIndex != 3){
                StringBuilder sb = new StringBuilder(str);
                sb.append("0");
                str = sb.toString();
            }
            pointIndex =  str.indexOf(".");
            if(str.length() - pointIndex != 3){
                StringBuilder sb = new StringBuilder(str);
                sb.append("0");
                str = sb.toString();
            }
            /*BigDecimal bg = new BigDecimal(third).setScale(2, RoundingMode.UP);
            third = bg.doubleValue();*/
            System.out.println(first + " " + second + " " + str);
        }
        return;
    }

    private static double getValue(int i, int j, int[][] arr) {
        int x1 = arr[i][1];
        int y1 = arr[i][2];
        int z1 = arr[i][3];

        int x2 = arr[j][1];
        int y2 = arr[j][2];
        int z2 = arr[j][3];
        int tmp = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) + (z1-z2) * (z1-z2);
        return Math.sqrt(tmp);
//        return (double) tmp;
    }
}
