package codeexam.alibaba;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/7/2018 7:47 PM
 * desc  :
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        split = scanner.nextLine().split(",");
        int x1, y1, x2, y2, x3, y3, x4, y4;
        int[] xs = new int[4];
        int[] ys = new int[4];
        x1 = Integer.parseInt(split[0]);
        y1 = Integer.parseInt(split[1]);
        x2 = Integer.parseInt(split[2]);
        y2 = Integer.parseInt(split[3]);
        x3 = Integer.parseInt(split[4]);
        y3 = Integer.parseInt(split[5]);
        x4 = Integer.parseInt(split[6]);
        y4 = Integer.parseInt(split[7]);
        xs[0] = x1; xs[1] = x2; xs[2] = x3; xs[3] = x4;
        ys[0] = y1; ys[1] = y2; ys[2] = y3; ys[3] = y4;

        int minx = xs[0], minxy = 0;
        int maxy = ys[0], maxyx = 0;
        for(int i = 1; i < 4; i++){
            if(xs[i] < minx){
                minx = xs[i];
                minxy = ys[i];
            }else if(xs[i] == minx){
                if(ys[i] < minxy){
                    minx = xs[i];
                    minxy = ys[i];
                }
            }
            if(ys[i] > maxy) {
                maxy = ys[i];
                maxyx = xs[i];
            }else if(ys[i] == maxy){
                if(xs[i] > maxyx){
                    maxy = ys[i];
                    maxyx = xs[i];
                }
            }
        }

        boolean res = checkIn(x, y, minx, minxy, maxyx, maxy);
//        System.out.println(res);
        if(res){
            System.out.println("yes,0");
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < 4; i++){
                int absx = Math.abs(x - xs[i]);
                int absy = Math.abs(y - ys[i]);
                double sqrt = Math.sqrt(absx * absx + absy * absy);
                list.add((int) sqrt);
            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
//            System.out.println(list);
            System.out.println("no," + list.get(0));
        }
        return;
    }

    private static boolean checkIn(int x, int y, int minx, int minxy, int maxyx, int maxy) {
        if(x < minx)
            return false;
        if(x > maxyx)
            return false;
        if(y < minxy)
            return false;
        if(y > maxy)
            return false;
        return true;
    }
}
