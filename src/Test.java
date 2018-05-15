import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/14 12:02
 * @desc :
 */
public class Test {

    public static void main(String[] args) {

        /*while (scanner.hasNext()){
            String s = scanner.nextLine();
            if(s.trim().length() <= 1)
                break;
            list.add(s);
        }

        System.out.println(list);*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s;
            s = br.readLine();
            while(s != null && s.trim().length() > 0){
                System.out.println(s);
                s = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
