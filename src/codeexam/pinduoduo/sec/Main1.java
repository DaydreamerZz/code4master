package codeexam.pinduoduo.sec;

import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 8/30/2018 6:58 PM
 * desc  :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = Integer.parseInt(scanner.nextLine());
        int normalAttack = Integer.parseInt(scanner.nextLine());
        int buffedAttack = Integer.parseInt(scanner.nextLine());

        int res = 0;
        if(hp % buffedAttack == 0){
            res = (hp / buffedAttack);
            res += res;
        }else {
            int res1 = allAttack(hp, normalAttack);
            int res2 = allBuff(hp, buffedAttack);
//            System.out.println(Math.min(res1, res2));
            res = Math.min(res1, res2);
        }
        System.out.println(res);


        return;
    }

    private static int allBuff(int hp, int buffedAttack) {
        int x = hp / buffedAttack;
        int y = hp % buffedAttack;
        if(y == 0)
            return x*2;
        else
            return x*2+1;
    }

    private static int allAttack(int hp, int normalAttack) {
        int x = hp / normalAttack;
        int y = hp % normalAttack;
        if(y == 0)
            return x;
        else
            return x+1;
    }
}
