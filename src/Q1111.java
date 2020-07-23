import java.util.LinkedList;

public class Q1111 {
    public int[] maxDepthAfterSplit(String seq) {
        boolean last=true;
        LinkedList<Boolean> zhan = new LinkedList<>();
        char[] chars = seq.toCharArray();
        int [] res = new int[chars.length];
        for (int i=0;i<chars.length; i++){
            char data = chars[i];
            if (data=='('){
                zhan.add(last);
                res[i]=last?1:0;
                last=!last;
            } else {
                Boolean index = zhan.pollLast();
                res[i]=index?1:0;
                last=!last;
            }
        }

        return res;

    }
    class Node{
        public char val;
        public int index;
        public Node(char val,boolean index){
            this.val=val;
            this.index=index?1:0;
        }

    }
}
