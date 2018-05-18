package imp.consistenthash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/18 15:00
 * @desc :
 */
public class ConsistentHash<T> {

    private final HashService hashService; //提供高效的哈希方法，没有采用默认的哈希方法
    private final int numberOfReplicas; //虚拟节点的个数
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>(); //虚拟节点组成的一个哈希环, key是哈希值，value是server节点

    /*
    @param servers是真实节点的ip
     */
    public ConsistentHash(HashService hashService, int numberOfReplicas, Collection<T> servers){
        this.hashService = hashService;
        this.numberOfReplicas = numberOfReplicas;

        for(T server : servers){
            add(server);
        }
    }

    public void add(T server) {
        for(int i = 0; i < numberOfReplicas; i++){
            circle.put(hashService.hash(server.toString() + i), server);
        }
    }

    public void remove(T node){
        for(int i = 0; i < numberOfReplicas; i++){
            circle.remove(hashService.hash(node.toString() + i));
        }
    }

    /*
    通过hash值得到对应的真实服务器
     */
    public T get(String key){
        if(circle.isEmpty())
            return null;
        long hash = hashService.hash(key);

        if(!circle.containsKey(hash)){
            SortedMap<Long, T> biggerServer = circle.tailMap(hash);
            hash = biggerServer.isEmpty() ? circle.firstKey() : biggerServer.firstKey();
        }
        return circle.get(hash);

    }
}
