package imp.consistenthash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/18 15:19
 * @desc :
 */
public class TestHashCircle {
    private static final String IP_PREFIX = "192.168.1.";

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();

        ArrayList<Server<String>> nodes = new ArrayList<Server<String>>();

        for (int i = 1; i <= 10; i++) {
            map.put(IP_PREFIX + i, 0);
            Server<String> server = new Server<>(IP_PREFIX + i, "server" + i);
            nodes.add(server);
        }

        HashService hashService = new HashServiceImp();
        ConsistentHash<Server<String>> consistentHash = new ConsistentHash<Server<String>>(hashService, 200, nodes);

        System.out.println(consistentHash.toString());

        for (int i = 0; i < 5000; i++) {
            String data = UUID.randomUUID().toString() + i;
            Server<String> server = consistentHash.get(data);

            map.put(server.getIp(), map.get(server.getIp()) + 1);
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get("192.168.1." + i));
        }
        return;
    }
}
