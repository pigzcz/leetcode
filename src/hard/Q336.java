package hard;

import java.util.*;

/**
 * 336. 回文对
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2：
 *
 * 输入：["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 */
public class Q336 {

    /**
     * 用来构建字典树
     */
    static class Tree{
        public char value;
        public int endIndex = -1;
        public String endString;

        public Tree(char value) {
            this.value = value;
        }

        public Tree(char value, int endIndex,String endString) {
            this.value = value;
            this.endIndex = endIndex;
            this.endString = endString;
        }

        public Map<Character,Tree> children;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Tree zTree = getZTree(words);
        int i = 0;
        int emptyIndex = -1;
        for (String tmp : words){
            if (tmp.equals("")){
                emptyIndex = i;
            }
            i++;
        }

        i =0;
        for (String tmp:words){
            List<Integer> z = findZ(tmp, zTree,true);
            if (null != z){
                for (Integer zz : z){
                    List<Integer> zzz = new ArrayList<>();
                    if (i!=zz.intValue()){
                        zzz.add(zz);
                        zzz.add(i);
                        res.add(zzz);
                    } else {
                        if (emptyIndex != -1){
                            zzz.add(emptyIndex);
                            zzz.add(i);
                            res.add(zzz);
                            zzz = new ArrayList<>();
                            zzz.add(i);
                            zzz.add(emptyIndex);
                            res.add(zzz);
                        }

                    }
                }
            }
            i++;
        }

        Tree dTree = getDTree(words);
        i =0;
        for (String tmp : words){
            List<Integer> d = findD(tmp, dTree,false);
            if (null != d){
                for (Integer dd : d){
                    List<Integer> ddd = new ArrayList<>();
                    if (i != dd.intValue()){
                        ddd.add(i);
                        ddd.add(dd);
                        res.add(ddd);
                    }
                }
            }
            i++;
        }
        return res;
    }

    public List<Integer> findZ(String word ,Tree zTree,boolean reverse){
        String s = new StringBuilder(word).reverse().toString();
        return findD(s,zTree,reverse);
    }

    public List<Integer> findD(String word, Tree dTree,boolean reverse){

        char[] chars = word.toCharArray();
        Map<Character,Tree> children = dTree.children;
        Tree current = null;
        int start = 0;
        for (int i =0;i<chars.length;i++){
            char c = chars[i];
            if (null == children){
                return null;
            }
            Tree tree = children.get(c);
            if (null == tree){
                return null;
            }
            current = tree;
            children = tree.children;
            start++;
        }
        List<Integer> res = new ArrayList<>();
        findD(start,current,res,reverse);
        return res;
    }
    public void findD(int subStart,Tree dTree,List<Integer> res,boolean reverse){
        if (null != dTree){
            if (dTree.endIndex != -1){
                String substring = dTree.endString.substring(subStart, dTree.endString.length());
                String s = new StringBuilder(substring).reverse().toString();
                if (reverse){
                    if (substring.equals(s)){
                        res.add(dTree.endIndex);
                    }
                } else {
                    if (substring.equals(s) && !s.equals("")){
                        res.add(dTree.endIndex);
                    }
                }

            }
            Map<Character, Tree> children = dTree.children;
            if (null != children){
                for (Map.Entry<Character,Tree> entry : children.entrySet()){
                    findD(subStart,entry.getValue(),res,reverse);
                }
            }
        }
    }

    Tree getZTree(String[] words){
        Tree root = new Tree('-');
        int k =0;
        for (String tmp : words){
            Tree tree = root;
            char[] chars = tmp.toCharArray();

            for (int i =0;i<chars.length;i++){
                char t = chars[i];
                if (tree.children == null){
                    tree.children = new HashMap<>();
                }
                Tree cT = tree.children.get(t);
                if (cT == null){
                    if (i == chars.length-1){

                        cT = new Tree(t,k,tmp);
                    } else {
                        cT = new Tree(t);
                    }

                    tree.children.put(t,cT);
                } else {
                    if (i == chars.length-1){
                        cT.endIndex = k;
                        cT.endString = tmp;
                    }
                }
                tree = cT;
            }

            k++;
        }
        return root;
    }
    Tree getDTree(String[] words){
        Tree root = new Tree('-');
        int k =0;
        for (String tmp : words){
            Tree tree = root;
            String reverse = new StringBuilder(tmp).reverse().toString();
            char[] chars = reverse.toCharArray();

            for (int i =0;i<chars.length;i++){
                char t = chars[i];
                if (tree.children == null){
                    tree.children = new HashMap<>();
                }
                Tree cT = tree.children.get(t);
                if (cT == null){
                    if (i == chars.length-1){
                        cT = new Tree(t,k,reverse);
                    } else {
                        cT = new Tree(t);
                    }

                    tree.children.put(t,cT);
                } else {
                    if (i == chars.length-1){
                        cT.endIndex = k;
                        cT.endString = reverse;
                    }
                }

                tree = cT;
            }

            k++;
        }
        return root;
    }
    public static void main(String[] args) {
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        Q336 q336 = new Q336();
        Tree dTree = q336.getDTree(words);
        Tree zTree = q336.getZTree(words);


        List<List<Integer>> lists = q336.palindromePairs(words);
        System.out.println("d");
    }

}
