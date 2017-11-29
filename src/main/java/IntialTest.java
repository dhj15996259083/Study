public class IntialTest {
    public static void main(String[] args) {
        new Son("dd", 22);
    }
}

class Parent {
    public Parent(String name, Integer age) {
        System.out.println(2);
    }

    public Parent(String name) {
        System.out.println(1);
    }

    public static void alert(String name){
        System.out.println(name);
    }
}

class Son extends Parent {
    public Son(String name, Integer age) {
        super(name);
    }
}
