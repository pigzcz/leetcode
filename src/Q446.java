public class Q446 {



    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        boolean can = can(s1,s2);
        if (!can){
            StringBuilder sb = new StringBuilder(s1);
            for (int i=2;i<=s2.length();i++){
                sb.append(sb);
                String s = sb.toString();
                if (can(s,s2)){
                    return n1/i/n2;
                }
            }

        } else {
            StringBuilder sb = new StringBuilder(s2+s2);
            int n = 2;
            while (can(s1,sb.toString())){
                sb=sb.append(s2);
                n++;
            }
            return n1*(n-1)/n2;
        }
        return 0;
    }

    public boolean can(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();


        int i2=0;
        int i1=0;
            int start=i1;
            int index=0;
            while ((index=find(chars1,chars2[i2],start))!=-1){
                start = index+1;
                if (i2==chars2.length-1){
                    return true;
                }
                i2=i2+1;

            }


        return false;


    }
    public int find(char[] chars,char x,int index){
        for (int i=index;i<chars.length;i++){
            if (chars[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Q446 q446 = new Q446();


        int maxRepetitions = q446.getMaxRepetitions("acb", 4, "ab", 2);
        System.out.println(maxRepetitions);
    }
}
