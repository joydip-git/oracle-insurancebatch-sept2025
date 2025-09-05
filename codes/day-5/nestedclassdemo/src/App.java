
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        Outer outer = new Outer();
        Outer.Nested nested = outer.new Nested();
        // nested.print();

        Outer.StaticInner inner = new Outer.StaticInner();
        // inner.show();

        // local inner class
        class MainInner {
            public void printData() {
                inner.show();
                nested.print();
            }
        }

        MainInner mainInner = new MainInner();
        mainInner.printData();

        // local variable or inner class can't be declared with static keyword
        // static class MainnStaticInner {

        // }

        // KeyValueCollection<Integer, Integer> collection = new KeyValueCollection<>();

        // collection.addItem(1, 10);
        // collection.addItem(0, 5);
        // collection.addItem(2, 20);

        // Set<KeyValueCollection<Integer, Integer>.KeyValuePair> items =
        // collection.getItems();
        // for (KeyValueCollection<Integer, Integer>.KeyValuePair item : items) {
        // System.out.println(item.getKey() + ":" + item.getValue());
        // }

        // Invoker invoker = new Invoker.Implementation();

        // anonymous type (the type or a class in the example, without a name)
        Invoker invoker = new Invoker() {
            @Override
            public String invoke(String value) {
                return "Value: " + value;
            }
        };

        // NameInvoker nameInvoker = new NameInvoker();
        // Invoker invoker = nameInvoker.printName;
        String value = invoker.invoke("joydip");
        System.out.println(value);

        ValueComparator<Integer> comparator = new ValueComparator.Comparer<>();
        System.out.println(comparator.compareValue(112, 13));

        // anonymous type
        ValueComparator<Integer> numComparator = new ValueComparator<>() {
            @Override
            public boolean compareValue(Integer o1, Integer o2) {
                return o1 - o2 > 0;
            }
        };

        System.out.println(numComparator.compareValue(12, 13));

        // class App$1 implements ValueComparator<Integer>{
        // @Override
        // public boolean compareValue(Integer o1, Integer o2) {
        // return o1 - o2 > 0;
        // }
        // }
        // ValueComparator<Integer> numComparator = new App$1();

        //local inner class
        // class App$1 implements Comparator<Integer> {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o1 - o2;
        //     }
        // }

        //  Map<Integer, String> map = new TreeMap<>(new App$1())
        
        //anonymous type
        Comparator<Integer> intComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Map<Integer, String> map = new TreeMap<>(intComparator);
        map.put(4, "vinod");
        map.put(1, "joydip");
        map.put(3, "anil");
        map.put(2, "sunil");
    }
}
