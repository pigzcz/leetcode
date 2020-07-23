import java.util.LinkedList;

public class Q1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int length = nums.length;
        int start =0;
        int end=0;
        int last =-1;
        int next=0;
        int count =0;
        int jicount =0;
        int alljicount =0;
        boolean flag=true;
        boolean startMove=true;
        boolean endMove=true;
        boolean nextMove=true;
        LinkedList<Integer> j = new LinkedList<>();
        while (flag){
            if (startMove){
                if (isJi(nums[start])){
                    startMove=false;
                    nextMove=true;
                }else {
                    start++;
                }
            }
            if (endMove){
                if (isJi(nums[end])){
                    alljicount++;
                    if (alljicount!=1){
                        j.add(next);
                    }
                    jicount=jicount+1;
                    if (jicount==k){
                        endMove=false;
                    } else {
                        end++;
                    }
                }else {
                    end++;
                }


            }
            if (nextMove){
                next++;
                if (next<length){



                        if (isJi(nums[next])&&!startMove&&!endMove){
                            count=count+(next-end)*(start-last);
                            end=next;
                            last = start;
                            Integer integer = j.pollFirst();
                            if (integer==null){
                                start++;
                            } else {
                                start=integer;
                            }

                            startMove=true;
                            nextMove=false;
                        }



                } else {
                    if (!startMove&&!endMove){
                        count=count+(next-end)*(start-last);

                    }
                    break;
                }



            }

        }



        return count;
    }

    private boolean isJi(int val){
        return (val&1)==1;
    }

    public static void main(String[] args) {
        Q1248 q1248= new Q1248();
        int[] x= new int[]{1,1,1,1,1};
        int i = q1248.numberOfSubarrays(x, 1);
        System.out.println(i);
    }
}
