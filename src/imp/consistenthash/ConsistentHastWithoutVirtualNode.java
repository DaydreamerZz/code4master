package imp.consistenthash;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/5/17 16:15
 * @desc   : 一致性hash算法，没有虚拟节点的实现
 */
public class ConsistentHastWithoutVirtualNode {

    /*
    服务器列表
     */
    private static String[] servers = {
            "192.168.0.0:111",
            "192.168.0.1:111",
            "192.168.0.2:111",
            "192.168.0.3:111",
            "192.168.0.4:111"
    };

    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();


    /*
    初始化
     */
    static{
        for(int i =0; i < servers.length; i++){
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合， hash value: " + hash);
            sortedMap.put(hash, servers[i]);
        }
    }

    /*
    没有采用系统的hash方法，因为系统提供的hash方法，利用ip地址字符串来进行去hash，之间的差距太小，所以采用其他的hash方法
     */
    private static int getHash(String serverIpStr) {
        final int p = 16777619;
         int hash = (int)2166136261L;
         for (int i = 0; i < serverIpStr.length(); i++)
             hash = (hash ^ serverIpStr.charAt(i)) * p;
         hash += hash << 13;
         hash ^= hash >> 7;
         hash += hash << 3;
         hash ^= hash >> 17;
         hash += hash << 5;
         if(hash < 0){
             hash = Math.abs(hash);
         }
         return hash;
    }

    public static void main(String[] args) {
        String[] nodes = {
                "127.0.0.1:1111",
                "221.226.0.1:2222",
                "10.211.0.1:3333"
        };

        Iterator<Map.Entry<Integer, String>> iterator = sortedMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }


        for(int i = 0; i < nodes.length; i++){
            System.out.println("[" + nodes[i] + "]的hash值为: " + getHash(nodes[i]) + ", 被分配到: " + getServer(nodes[i]));
        }

//        System.out.println(getServer(""));

        return;
    }

    private static String getServer(String node) {
      int hash = getHash(node);

        SortedMap<Integer, String> biggerNodes = sortedMap.tailMap(hash);
        if(biggerNodes.size() == 0){
            return sortedMap.get(sortedMap.firstKey());
        }
        return biggerNodes.get(biggerNodes.firstKey());


//        return  "";
    }
}
