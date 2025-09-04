//import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        // key:value

        // Map<Integer, String> map = new HashMap<>();
        class IntegerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }
        Map<Integer, String> map = new TreeMap<>(new IntegerComparator());
        map.put(4, "vinod");
        map.put(1, "joydip");
        map.put(3, "anil");
        map.put(2, "sunil");

        // update value linked with a key
        // map.put(2, "ram");

        String value = map.get(3);
        System.out.println(value);

        System.out.println(map.containsKey(5) ? "yes" : "no");
        System.out.println(map.containsValue("joydip") ? "yes" : "no");

        map.putIfAbsent(2, "banu");

        String removedValue = map.remove(3);
        System.out.println(removedValue);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
