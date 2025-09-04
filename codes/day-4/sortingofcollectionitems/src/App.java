import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
    static void primitiveSorting() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(1);
        numbers.add(13);

        // for (int i = 0; i < numbers.size(); i++) {
        // for (int j = i + 1; j < numbers.size(); j++) {
        // if (numbers.get(i) > numbers.get(j)) {
        // int temp = numbers.get(i);
        // numbers.set(i, numbers.get(j));
        // numbers.set(j, temp);
        // }
        // }
        // }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).compareTo(
                        numbers.get(j)) > 0) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }

        for (int item : numbers) {
            System.out.println(item);
        }
    }

    static void peopleManualSorting() {
        List<Person> people = new ArrayList<>();
        Person sunilPerson = new Person(2, "sunil");
        Person joydipPerson = new Person(1, "joydip");
        Person anilPerson = new Person(3, "anil");
        people.add(sunilPerson);
        people.add(joydipPerson);
        people.add(anilPerson);

        for (int i = 0; i < people.size(); i++) {
            for (int j = i + 1; j < people.size(); j++) {
                if (people.get(i).compareTo(people.get(j)) > 0) {
                    Person temp = people.get(i);
                    people.set(i, people.get(j));
                    people.set(j, temp);
                }
            }
        }

    }

    static void comparableAndComparator() {
        Integer a = 10;
        Integer b = 20;
        // Comparabale<T>
        System.out.println(a.compareTo(b) > 0 ? "a is greater" : "b is greater");

        int x = 0;
        int y = 20;
        // Comparator<T>
        System.out.println(Integer.compare(x, y) > 0 ? "x is greater" : "y is greater");

    }

    static void peopleSorting() {
        List<Person> people = new ArrayList<>();
        Person sunilPerson = new Person(2, "sunil");
        Person joydipPerson = new Person(1, "joydip");
        Person anilPerson = new Person(3, "anil");
        people.add(sunilPerson);
        people.add(joydipPerson);
        people.add(anilPerson);

        // Collections.sort(people);

        System.out.println("1. sort by id\n2. sort by name");
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter choice[1/2]: ");
        int choice = scanner.nextInt();

        PersonComprator comprator = new PersonComprator(choice);

        // in this overloaded version of the sort method, you should pass the List<T>
        // instance along with an instance of class which implements Comparator<T>
        // interface and its method "int compare(T o1, T o2)".
        // In this case if the T from List<T> has already implemented Comparable<T> and
        // its method "int compareTo(T o)", the sort() method will ignore the "in
        // compareTo(T o)" method present in T, and will use "int compare(T o1, T o2)"
        // from comparator instance
        Collections.sort(people, comprator);

        for (Person p : people) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) throws Exception {
        // primitiveSorting();
        // comparableAndComparator();
        // peopleManualSorting();
        // peopleSorting();
        sortStringsBasedOnLength();
    }

    static void sortStringsBasedOnLength() {
        // local inner class (written and scoped only inside the declaring method)
        // class StringComparator implements Comparator<String> {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o1.length() - o2.length();
        //     }
        // }

        List<String> sentences = new ArrayList<>();
        sentences.add("Ny name is joydip");
        sentences.add("I teach Java");
        sentences.add("I live in Bangalore");

        StringComparator comp = new StringComparator();
        sentences.sort(comp);
        for (String sentence : sentences) {
            System.out.println(sentence + ":" + sentence.length());
        }
    }
}
