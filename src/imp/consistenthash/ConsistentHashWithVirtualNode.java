package imp.consistenthash;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/5/17 16:58
 * @desc   : 一致性hash算法，有虚拟节点的实现
 * 如何解决虚拟节点到真实节点的映射问题，简单的办法：
 * 给每个真实结点后面根据虚拟节点加上后缀再取Hash值，比如"192.168.0.0:111"就把它变成"192.168.0.0:111&&VN0"到"192.168.0.0:111&&VN4"，VN就是Virtual Node的缩写，还原的时候只需要从头截取字符串到"&&"的位置就可以了。
 */
public class ConsistentHashWithVirtualNode {

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

    private static List<String> realNodes = new LinkedList<String>();

    private static SortedMap<Integer, String> virtualNodes = new TreeMap<Integer, String>();

    /*
    每个真实节点对应的虚拟节点的数量
     */
    private static int virtualNodesNumber = 5;

    static{
        for(String node : servers){
            realNodes.add(node);
        }
        for(String node : servers){
            for(int j = 0; j < virtualNodesNumber; j++){
                String virtualNodeName = node + "&&VN" + j;
                int hash = getHash(virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                 virtualNodes.put(hash, virtualNodeName);
            }
        }
    }

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

    private static String getServer(String node) {
      int hash = getHash(node);

        SortedMap<Integer, String> biggerNodes = virtualNodes.tailMap(hash);
        String virtualNodeName;
        if(biggerNodes.size() == 0){
            virtualNodeName = virtualNodes.get(virtualNodes.firstKey());
        }else {
            virtualNodeName = biggerNodes.get(biggerNodes.firstKey());
        }
        return virtualNodeName.substring(0,virtualNodeName.indexOf("&&"));


//
    }

    public static void main(String[] args) {

        String[] nodes = {
                "127.0.0.1:1111",
                "221.226.0.1:2222",
                "10.211.0.1:3333"
        };

        /*Set<Integer> integers = sortedMap.keySet();
        for(Integer i : integers){
            System.out.println(sortedMap.get(i) + " " + i);
        }*/

        for(int i = 0; i < nodes.length; i++){
            System.out.println("[" + nodes[i] + "]的hash值为: " + getHash(nodes[i]) + ", 被分配到: " + getServer(nodes[i]));
        }
    }
}
