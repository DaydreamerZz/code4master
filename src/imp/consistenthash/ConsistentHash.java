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

    private final HashService hashFunction;
    private final int numberOfReplicas; //虚拟节点
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>(); //虚拟节点组成哈希环

    public ConsistentHash(HashService hashFunction, int numberOfReplicas, Collection<T> nodes){
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for(T node : nodes){
            add(node);
        }
    }

    public void add(T node) {
        for(int i = 0; i < numberOfReplicas; i++){
            circle.put(hashFunction.hash(node.toString() + i), node);
        }
    }

    public void remove(T node){
        for(int i = 0; i < numberOfReplicas; i++){
            circle.remove(hashFunction.hash(node.toString() + i));
        }
    }

    public T get(String key){
        if(circle.isEmpty())
            return null;
        long hash = hashFunction.hash(key);

        if(!circle.containsKey(hash)){
            SortedMap<Long, T> biggerServer = circle.tailMap(hash);
            hash = biggerServer.isEmpty() ? circle.firstKey() : biggerServer.firstKey();
        }
        return circle.get(hash);

    }
}
