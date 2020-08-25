package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Node> tmp = new ArrayList<>();
        List<Node> current = new ArrayList<>();
        Set<Integer> contains = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!contains.contains(nums[i])){
                tmp.add(new Node(nums[i],i));
                contains.add(nums[i]);
            }
        }
        contains.clear();
        while (tmp.size()!=0){
            current = new ArrayList<>();
            for (Node tmpNode : tmp){
                int k = tmpNode.lastIndex+1;
                while (k<nums.length){
                    if (contains.contains(nums[k])){
                        k++;
                        continue;
                    }
                    Node add = tmpNode.add(nums[k], k);
                    if (null != add){
                        contains.add(nums[k]);
                        current.add(add);
                        result.add(add.list);
                    }
                    k++;
                }

                contains.clear();
            }
            tmp = current;
        }
        return result;
    }
    class Node{
        ArrayList<Integer> list;
        int lastIndex;
        public Node add(int value,int index){
            if (list.get(list.size()-1).intValue() >value){
                return null;
            }
            Node node = new Node();
            node.list = (ArrayList<Integer>) this.list.clone();
            node.list.add(value);
            node.lastIndex = index;
            return node;
        }

        public Node() {
        }

        public Node(int value , int index) {
            list = new ArrayList<>();
            list.add(value);
            lastIndex = index;
        }

    }

    public static void main(String[] args) {
        Q491 q491 = new Q491();
        int[] a = new int[]{4,6,7,7};
        List<List<Integer>> subsequences = q491.findSubsequences(a);
        System.out.println(subsequences);
    }
}
