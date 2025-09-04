import java.util.Set;
import java.util.TreeSet;
//import java.util.HashSet;
import java.util.Iterator;

public class App {
    static void useSetOfPrimitiveTypes() {
        // Set<Integer> numbers = new HashSet<>();
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(12);// 12.hashCode() => 1234
        numbers.add(12);// 12.hashCode() => 1234
                        // 12.equals(12) => true
        numbers.add(1); // 1. hashCode() => 123
        numbers.add(100);
        numbers.add(20);

        System.out.println("\nusing foreach loop\n");
        for (int num : numbers) {
            System.out.println(num);
        }

        // removing a value
        numbers.remove(1);

        System.out.println("\nusing iterator\n");
        Iterator<Integer> cursor = numbers.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    static void useSetOfReferenceTypes() {
        // Set<Person> people = new HashSet<>();

        //This TreeSet<> instance will sort the Person items, but to that it will expect thet Person class has implemented "int compareTo(T o)" method from Comaparable<T> interface
        //Set<Person> people = new TreeSet<>();

        //or
        // This TreeSet<> instance will sort the Person items, but to do that it will now use the "int compare(T o1, T o2)" method from Comparator<T>
        // interface, which is implemented in "PersonComparator" class 
        Person.PersonComprator pc = new Person.PersonComprator(2);
        Set<Person> people = new TreeSet<>(pc);
        Person sunilPerson = new Person(2, "sunil");
        Person joydipPerson = new Person(1, "joydip");
        Person anilPerson = new Person(3, "anil");
        Person duplicateOfJoydip = new Person(1, "joydip");

        // hash code will be calculated for every instance of Person, but based on the
        // address/reference of that instance in case you have not overriden the Object
        // class's "hashCode"
        // but hash code for Person will be calculated based on your logic in hashCode
        // method that you have overriden in the Person class
        // if now, the has code value of two Person type instance are same, then
        // "equals" method will be used to find out whether two Person instances are
        // same or not
        people.add(sunilPerson);
        people.add(joydipPerson);
        people.add(anilPerson);
        people.add(duplicateOfJoydip);

        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) throws Exception {
        //useSetOfPrimitiveTypes();
        useSetOfReferenceTypes();
    }
}
