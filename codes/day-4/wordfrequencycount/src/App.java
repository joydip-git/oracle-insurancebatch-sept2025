import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {

        Map<String, Integer> result = findWordsAndFrquency(
                "I teach Java. I am working on Java for last 20 years, since 2005.");
        if (result != null && result.isEmpty()) {
            Set<Map.Entry<String, Integer>> entries = result.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else
            System.out.println("sorry...");
    }

    static Map<String, Integer> findWordsAndFrquency(String sentence) {
        if (!sentence.isBlank() || !sentence.isEmpty()) {
            String[] words = sentence.split("\\s+");
            Map<String, Integer> output = new TreeMap<>();

            for (String word : words) {
                if (output.containsKey(word.toLowerCase())) {
                    output.put(word.toLowerCase(), output.get(word.toLowerCase()) + 1);
                } else {
                    output.put(word.toLowerCase(), 1);
                }
            }
            return output;
        } else
            return null;
    }
}
