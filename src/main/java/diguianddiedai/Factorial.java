package diguianddiedai;

public class Factorial {
    // 普通递归
    public static long calculate1(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * calculate1(n - 1);
        }
    }

    // 迭代法
    public static long calculate2(long n) {
        long result = 1L;
        while (n > 1) {
            result = n * result;
            n--;
        }
        return result;
    }

    // 尾递归
    public static long calculate3(long n, long result) {
        if(n == 1) {
            return result;
        }else {
            return calculate3(n - 1, n * result);
        }
    }


    public static void main(String[] args) {
        System.out.println(Factorial.calculate1(25L));
        System.out.println(Factorial.calculate2(25L));
        System.out.println(Factorial.calculate3(25L, 1));

    }
}
