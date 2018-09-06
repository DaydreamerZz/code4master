import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        return;*/


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        Vector<Integer> vector = new Vector<>();
        vector.add(1);

        Hashtable<Integer, String> table = new Hashtable<>();



        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        Iterator<Integer> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }


        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(2);
        Iterator<Integer> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        HashMap<Integer, String> hashMap = new HashMap<>();
        for(int i = 0; i < 10; i++){
            hashMap.put(i, i+"");
        }


    }
}
