public class RightMoveTest {
    public static void main(String[] args) {
        int a = 0x80000001;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a>>3));
        System.out.println(Integer.toBinaryString(a>>>3));
    }
}
