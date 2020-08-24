package medium;

/**
 * @Auther: johnson.zhu
 * @Date: 2020/8/20 20:01
 * @Description:
 */
public class Test {
    Test next;
    private int val;

    public Test(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        Test t1 = new Test(1);
        Test t2 = new Test(2);
        Test t3 = new Test(3);
        Test t4 = new Test(4);
        t1.next=t2;t2.next = t3;t3.next=t4;
        System.out.println(t1);
        t2=t3;
        System.out.println(t1);

    }
}
