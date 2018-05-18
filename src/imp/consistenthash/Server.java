package imp.consistenthash;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/18 14:55
 * @desc :
 */
public class Server<T> {

    private String ip;
    private String name;

    public Server(String ip, String name){
        this.ip = ip;
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        /*return "Server{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                '}';*/
        return ip;
    }
}
