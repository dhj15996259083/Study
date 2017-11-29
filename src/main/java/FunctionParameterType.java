public class FunctionParameterType {
    public void test(Object o) {
        System.out.println("I am Object");
    }

    public void test(String s) {
        System.out.println("I am String");
    }

    public static void main(String[] args) {
        Object o = 1;
        new FunctionParameterType().test(o);
    }
}
