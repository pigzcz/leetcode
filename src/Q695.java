import java.util.*;

public class Q695 {
    public int maxDistance(int[][] grid) {
        boolean allIsand = true;
        boolean allSea = true;
        Map<Integer,Set<Integer>> island = new HashMap<>();

        Map<Integer,Set<Integer>> sea = new HashMap<>();
        for (int k=0;k<grid.length;k++){
            for (int f=0;f<grid[0].length;f++){
                if (grid[k][f] == 1){
                    Set<Integer> integers = island.get(k);
                    if (null == integers){
                        integers=new HashSet<>();
                    }
                    integers.add(f);
                    island.put(k,integers);
                    allSea =false;
                }
                if (grid[k][f] == 0){
                    allIsand=false;
                    Set<Integer> integers = sea.get(k);
                    if (null ==integers){
                        integers = new HashSet<>();
                    }
                    integers.add(f);
                    sea.put(k,integers);
                }
            }
        }
        if (allIsand||allSea){
            return -1;
        }

        int max=0;

        for (Map.Entry<Integer,Set<Integer>> entry : sea.entrySet()) {
            Integer i = entry.getKey();
            Set<Integer> value = entry.getValue();

            for (Integer j : value) {

                int tmpMin = -1;

                Set<Integer> islandSet = island.get(i);
                if (null != islandSet) {
                    for (Integer islandJ : islandSet) {
                        if (tmpMin == -1) {
                            tmpMin = Math.abs(islandJ - j);
                        } else {
                            tmpMin = Math.min(tmpMin, islandJ - j);
                        }
                    }
                }



                int left = i-1;
                while (left>=0){
                    if (Math.abs(left-i)>=tmpMin&&tmpMin!=-1){
                        break;
                    }

                    Set<Integer> integers = island.get(left);

                    if (null == integers){
                        left--;
                        continue;
                    }
                    for (Integer leftj: integers){
                        int tmp = Math.abs(j-leftj)+Math.abs(left-i);
                        if (tmpMin==-1){
                            tmpMin=tmp;
                        } else {
                            tmpMin=Math.min(tmpMin,tmp);
                        }
                    }
                    left--;
                }

                int right = i+1;
                while (right<grid.length){
                    if (Math.abs(right-i)>=tmpMin && tmpMin!=-1){
                        break;
                    }

                    Set<Integer> integers = island.get(right);

                    if (null ==integers){
                        right++;
                        continue;
                    }
                    for (Integer rightj : integers){
                        int tmp = Math.abs(j-rightj)+Math.abs(right-i);
                        if (tmpMin==-1){
                            tmpMin=tmp;
                        } else {
                            tmpMin = Math.min(tmpMin,tmp);
                        }
                    }
                    right++;
                }

                max=Math.max(max,tmpMin);

            }

        }
        return max;
    }

    public String compressString(String S) {
        char[] chars = S.toCharArray();
        char last = ' ';
        int count =0;
        StringBuilder sb = new StringBuilder();
        for (char tmp :chars){
            if (last == ' '){
                last = tmp;
                continue;
            }
            if (tmp == last){
                count++;
            } else {
                sb.append(last).append(count+1);
                count=0;
                last=tmp;
            }
        }
        sb.append(last).append(count+1);
        String s = sb.toString();
        if (s.length()>=S.length()){
            return S;
        } else {
            return s;
        }
    }

    public int countCharacters(String[] words, String chars) {

        int size = 0;


        for (String word :words){
            char[] chars1 = chars.toCharArray();
            List<Character> characterSet = new ArrayList<>();
            for (char tmp :chars1){
                characterSet.add(tmp);
            }

            char[] chars2 = word.toCharArray();
            boolean not=false;
            for (char tmp : chars2){
                if (!characterSet.contains(tmp)){
                    not = true;
                }else {
                    characterSet.remove(Character.valueOf(tmp));
                }
            }
            if (!not){

                size = size+word.length();
            }
        }
        return size;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2]<=rec2[0]||rec1[0]>=rec2[2]||rec1[1]>=rec2[3]||rec1[3]<=rec2[1]);
    }

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char tmp : chars){
            Integer integer = map.get(tmp);
            if (integer == null){
                integer = 0;
            }
            integer++;
            map.put(tmp,integer);
        }
        int count =0;
        boolean hasj = false;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            if (value%2!=0){
                count=count+value-1;
                hasj=true;
            }else {
                count=count+value;
            }
        }
        if (hasj){
            return count+1;
        }
        return count;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int tmp : arr){
            set.add(tmp);
        }
        if (set.size()<k){
            k=set.size();
        }
        int size =0;
        int[] a = new int[k];
        int dd = 0;
        while (size<k){
            if (set.contains(dd)){
                a[size]=dd;
                size++;
            }
            dd++;
        }
        return a;
    }

    public int minIncrementForUnique(int[] A) {
        int min=Integer.MAX_VALUE;
        int max =0;


        LinkedList<Integer> chonfu = new LinkedList<>();
        Set<Integer> contain = new HashSet<>();
        for (int a : A){
            min=Math.min(a,min);
            max=Math.max(a,max);
            if (contain.contains(a)){
                chonfu.add(a);
            }else {
                contain.add(a);
            }
        }
        Collections.sort(chonfu);
        LinkedList<Integer> unContain = new LinkedList<>();
        for (int i =min;i<=max;i++){
            if (!contain.contains(i)){
                unContain.add(i);
            }
        }
        int size = 0;
        while (!chonfu.isEmpty()){
            Integer integer = chonfu.pollFirst();
            if (null !=integer){

                Integer integer1 = unContain.pollFirst();

                if (null == integer1){
                    integer1 = max+1;
                    max = integer1;
                } else {
                    while (integer>integer1){
                        integer1=unContain.pollFirst();
                        if (integer1==null){
                            integer1=max+1;
                            max=integer1;
                            break;
                        }
                    }
                }

                size = size+integer1-integer;

            }
        }
        return size;
    }

    public ListNode middleNode(ListNode head) {
        if (null == head){
            return null;
        }
        if (head.next==null){
            return head;
        }
        int size=1;
        ListNode tmp = head;
        while (tmp.next!=null){
            tmp=tmp.next;
            size++;
        }
        int index=size/2;
        ListNode result = head;
        for (int i=0;i<index;i++){
            result = result.next;
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        Q695 q695 = new Q695();
//        int[][] ce = new int[][]{{1,0,0},{0,0,0},{0,0,0}};
//        int i = q695.maxDistance(ce);
//        System.out.println(i);

        int[] de = new int[]{0,2,2};
        int i = q695.minIncrementForUnique(de);
        System.out.println(i);
        System.out.println(5/2);
    }


}
