package castTypeTest;

public class Test {
    public static void test(FatherClass o) {
        System.out.println(((SonClass) o).name);
        System.out.println(o.name);
        System.out.println(((SonClass) o).getName());
        System.out.println(o.getName());
    }

    public static void main(String[] args) {
        Test.test(new SonClass());
    }
}
