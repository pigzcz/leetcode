public class Test {

    public Test left;
    public void test(Test test) {
        test = test.left;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Test test2= new Test();
        test.left = test2;
        test.test(test);
        System.out.println(test);
    }

}
