import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


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


        /*Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 129;
        Integer f = 129;
        System.out.println(c == d);
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(e == f);*/


        HashMap<Integer, String> hashMap = new HashMap<>();


        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 1, true);

        linkedHashMap.put(3,"3");
        linkedHashMap.put(1,"1");
        linkedHashMap.put(2,"2");
        linkedHashMap.get(3);
        Iterator<Map.Entry<Integer, String>> iterator = linkedHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + next.getValue());
        }

        LinkedList<Integer> linkedList = new LinkedList<>();

        Deque<Integer> deque = new ArrayDeque<>();


        BlockingQueue queue = new ArrayBlockingQueue(10);



        Stack<Integer> stack = new Stack<>();


        Vector<Integer> vector = new Vector<>();

        /*Set<Integer> set = new HashSet<>();
>>>>>>> 7af9428dbd0553d35fc623b81c9c8d0f0ab3e304
        set.add(1);
        set.add(3);
        set.add(2);
        Iterator<Integer> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

<<<<<<< HEAD

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


=======
        set = new LinkedHashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }*/


        ArrayList<Integer> arrayList = new ArrayList<>();
//        ListIterator<Integer> listIterator = arrayList.listIterator();
        for(int i = 0; i < 10; i++){
            arrayList.add(i);
        }


//        Collections.unmodifiableList();
//        Collections.synchronizedList()

        Iterator<Integer> iterator1 = arrayList.iterator();
        while(iterator1.hasNext()){
            Integer next = iterator1.next();
            if(next == 2){
                arrayList.remove(2);
            }
        }

    }
}
