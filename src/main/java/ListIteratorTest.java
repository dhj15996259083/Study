import java.util.*;

public class ListIteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("daihuijun", "fanxinyu", "zhaochen", "liwenlan"));
        ListIterator<String> listIterator = list.listIterator(0);

        while (listIterator.hasNext()) {
            String s = listIterator.next();
            if ("zhaochen".equals(s)) {
                listIterator.set("love " + s);
            }
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
