package castTypeTest;

public class FatherClass {
    protected String name = "father";
    public void test() {
        System.out.println("I am " + getName());
    }
public void get(String o){
    System.out.println("dd");
}
public void get(Object o) {
    System.out.println(1);
}
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        FatherClass fatherClass =  new SonClass();
        fatherClass.test();
        Object o  = "";
        fatherClass.get(o);
        System.out.println(fatherClass.name);
        System.out.println(((SonClass)fatherClass).name);
    }
}
class SonClass extends FatherClass{
    protected String name = "son";
    @Override
    public void test() {
        super.test();
//        System.out.println("I am " + name);
    }

    public String getName() {
        return name;
    }
}
