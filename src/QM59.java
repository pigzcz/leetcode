import java.util.LinkedList;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-03-27 17:45
 * @Description:
 */
public class QM59 {

    int max = -1;
    LinkedList<Integer> linkedList = new LinkedList();

    public int max_value() {
        return max;
    }

    public void push_back(int value) {
        if (value>max){
            max=value;
        }
        linkedList.addLast(value);
    }

    public int pop_front() {
        Integer integer = linkedList.pollFirst();
        if (null !=integer){
            if (integer==max){
                if (linkedList.size()==0){
                    max=-1;
                } else {
                    int tmpmax =-1;
                    for (Integer i : linkedList){
                        if (i>tmpmax){
                            tmpmax=i;
                        }
                    }
                    max = tmpmax;
                }
            }
            return integer;
        } else {
            return -1;
        }
    }
}
