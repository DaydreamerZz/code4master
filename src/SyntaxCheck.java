import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/7 15:50
 * @desc :
 */
public class SyntaxCheck {

    public static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) {
        for(char tmp = 'a'; tmp <= 'z'; tmp++){
            set.add(tmp);
        }
        set.add('<'); set.add('>'); set.add('=');

        int i = new SyntaxCheck().hasSyntaxError("<div><a></a></div>");
        System.out.println(i);
        return;
    }
    public int hasSyntaxError(String input){
        if(input == null || input.length() == 0)
            return 1;
        StringBuilder sb = new StringBuilder(input);
        Stack<String> stack = new Stack<>();
//<div id="a<1" tag="div"><a></a></div>
        //检查非法属性
        int curIndex = sb.indexOf("\"");
        int lastIndex = 0;
        if(curIndex != -1) { //存在属性
            while (curIndex != -1) {
                lastIndex = sb.indexOf("\"", curIndex);
                String substring = sb.substring(curIndex, lastIndex + 1);
                if(!checkTag(substring)){ //检查tag字符是否符合
                    return 0;
                }
                if(sb.charAt(lastIndex+1) != '>' && sb.charAt(lastIndex+1) != ' '){ //检查tag之间的空格
                    return 0;
                }
                int tmpIndex = sb.indexOf("<", curIndex+1);
                if(tmpIndex != 0){ //删除tag中的<，为后面做准备
                    sb.deleteCharAt(tmpIndex);
                }
                curIndex = sb.indexOf("\"", lastIndex);
            }
        }

//<div id="a1" tag="div"><a></a></div>
//<div><a></a></div>
        //检查标签顺序
        curIndex = sb.indexOf("<");
        while(curIndex != -1){
            lastIndex = sb.indexOf(">", curIndex);
            String substring = sb.substring(curIndex+1, lastIndex);
            if(substring.contains("/")){ //带有"/",需要出站
                if(sb.charAt(lastIndex) == '/'){ //类似<div />
                    continue;
                }else {
                    String pop = stack.pop();
                    if (!substring.startsWith(pop.substring(pop.length()))) {//如果不能够和栈里面上一个匹配，说明便签的顺序有问题
                        return 0;
                    }
                }
            }
            stack.push(substring);
            curIndex = sb.indexOf("<", lastIndex);
        }

        return 1;

    }

    private boolean checkTag(String substring) {
        char[] chars = substring.toCharArray();
        for(char c : chars){
            if(!set.contains(c))
                return false;
        }
        return true;
    }
}
