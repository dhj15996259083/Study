public class RetryTest {
    public void div(int a, int b) {
        retry:

        while(true) {
            if(a/b == 2){
                a = a/b;
                System.out.println(a);
                continue retry;
            }
        }
    }
    public static void main(String[] args) {
        new RetryTest().div(4,2);
    }
}
