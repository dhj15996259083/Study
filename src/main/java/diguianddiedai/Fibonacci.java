package diguianddiedai;

public class Fibonacci {
    public int fn(int n) {
        int a = 1, b = 1, num = a + b;
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return num;
        }
        while (n-- >= 4) {
            a = b;
            b = num;
            num = a + b;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fn(5));
    }
}
