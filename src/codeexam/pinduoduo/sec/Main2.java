package codeexam.pinduoduo.sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 8/30/2018 6:58 PM
 * desc  :
 */
/*
x
o
.
.
o
x
.
o
x
.
o
 */
public class Main2 {

    public static char GOODS = 'x';
    public static char EMPTY = 'o';
    public static char NOTHING = '.';


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        char[][] chars = new char[row][col];
        String line = null;
        for(int i = 0; i < row; i++){
            line = scanner.nextLine();
            chars[i] = line.toCharArray();
        }

//        System.out.println(Arrays.deepToString(chars));
        /*for(int i = 0; i < row; i++){
            System.out.println(Arrays.toString(chars[i]));
        }*/

        for(int i = 0; i < col; i++){
            figure(chars, row, i);
        }

        /*for(int i = 0; i < row; i++){
            System.out.println(Arrays.toString(chars[i]));
        }*/
        String str = null;
        for(int i = 0; i < row; i++){
            str = new String(chars[i]);
            System.out.println(str);
        }
        return;
    }

    //对index列进行修改
    private static void figure(char[][] chars, int row, int index) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < row; i++){
            if(chars[i][index] == EMPTY){
                if(i == row-1){ //如果这个空格在最后了
                    chars[i][index] = NOTHING;
                }else{
                    if(chars[i+1][index] == GOODS)
                        continue;
                    else if(chars[i+1][index] == EMPTY){
                        //或许往下都是空的或者是没有；
                        boolean flag = true;
                        for(int j = i + 1; j < row; j++){
                            if(chars[j][index] == GOODS){
                                flag = false;
                                break;
                            }
                        }
                        if(flag == true){ //说明往下都是空格的，可以情况能够
                            for(int j = i; j < row; j++){
                                chars[j][index] = NOTHING;
                            }
                            return;
                        }
                    } else { //这个空格下面是NOTHING，空格下一位
                        chars[i][index] = NOTHING;
                        chars[i+1][index] = EMPTY;
                    }
                }

            }else{
                continue;
            }

        }
    }
}
