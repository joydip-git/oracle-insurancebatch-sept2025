
import java.util.Comparator;

public class PersonComprator implements Comparator<Person> {

    private int sortChoice = 1;

    public PersonComprator() {
    }

    public PersonComprator(int sortChoice) {
        this.sortChoice = sortChoice;
    }

    public int compare(Person o1, Person o2) {
        // switch (sortChoice) {
        // case 1:
        // return o1.getId() - o2.getId();
        // case 2:
        // return o1.getName().compareTo(o2.getName());
        // default:
        // return 0;
        // }
        System.out.println("in compare method in PersonComparator");
        return switch (sortChoice) {
            case 1 -> o1.getId() - o2.getId();
            case 2 -> o1.getName().compareTo(o2.getName());
            default -> 0;
        };
    }
}
