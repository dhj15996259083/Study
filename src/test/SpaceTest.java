package test;

public class SpaceTest {
    public static void main(String[] args) {
        String a = "半角空格. ";
        String b = "全角空格.　";
        System.out.println(a.trim()+"长度："+a.trim().length());
        System.out.println(b.trim()+"长度："+b.trim().length());
    }
}
