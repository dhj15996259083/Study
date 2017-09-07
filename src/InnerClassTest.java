public class InnerClassTest {
    Integer i = 10;
    InnerClass innerClass = new InnerClass(){
        @Override
        public Integer print() {
            return i;
        }
    };
    class InnerClass{
        public Integer print() {
            return i;
        }
    }
}
