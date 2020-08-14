package easy;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Q20 {
    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList();
        if (s == null){
            return false;
        }
        if (s.equals("")){
            return true;
        }
        int length = s.length();
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Set<Character> set = new HashSet<>();
        set.add('{');
        set.add('(');
        set.add('[');

        for (int i = 0;i<length;i++){
            if (set.contains(s.charAt(i))){
                queue.push(s.charAt(i));
            }
            if (map.containsKey(s.charAt(i))){
                if (queue.size() == 0){
                    return false;
                }
                Character pop = queue.pop();
                Character character = map.get(s.charAt(i));
                if (!pop.equals(character)){
                    return false;
                }
            }
        }
        return queue.size() == 0;
    }

    public static void main(String[] args) {
        Q20 q20 = new Q20();
        boolean valid = q20.isValid("{{}}()(((())))");
        System.out.println(valid);
    }
}
