import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        useArrayList();
    }

    static void useArrayList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(1);
        numbers.add(13);
        numbers.add(12);
        // index <= current size
        numbers.add(0, 14);

        Collections.sort(numbers);

        System.out.println("\nusing for loop\n");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        numbers.remove(1);
        System.out.println("\nusing foreach loop\n");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        System.out.println("\nusing iterator\n");
        // Returns an iterator over the elements in this list in proper sequence.
        Iterator<Integer> cursor = numbers.iterator();
        while (cursor.hasNext()) {
            int value = cursor.next();
            System.out.println(value);
        }

        List<Person> people = new ArrayList<>();
        people.add(new Person(2, "sunil"));
        people.add(new Person(1, "joydip"));
        people.add(new Person(3, "anil"));

        for (Person person : people) {
            // System.out.println(person.getId() + ", " + person.getName());
            // System.out.println(person.toString());
            // toString() method is called when you try print the reference variable
            System.out.println(person);
        }

        // Collections.sort(people);
    }
}
