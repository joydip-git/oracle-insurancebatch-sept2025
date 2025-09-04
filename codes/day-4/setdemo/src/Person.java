import java.util.Comparator;

public class Person implements Comparable<Person> {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = Integer.hashCode(this.id) * prime;
        hash = name.hashCode() * hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj instanceof Person other) {
            if (this.id != other.id)
                return false;

            if (!this.name.equals(other.name))
                return false;

            return true;
        } else
            return false;
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }

    // public int hashCode(){ return this.hashCode();}
    // public boolean equals(Object obj){ return this == obj;}

    public static class PersonComprator implements Comparator<Person> {

        private int sortChoice = 1;

        public PersonComprator() {
        }

        public PersonComprator(int sortChoice) {
            this.sortChoice = sortChoice;
        }

        public int compare(Person o1, Person o2) {            
            System.out.println("in compare method in PersonComparator");
            return switch (sortChoice) {
                // case 1 -> o1.getId() - o2.getId();
                case 1 -> Integer.compare(o1.getId(), o2.getId());
                case 2 -> o1.getName().compareTo(o2.getName());
                default -> 0;
            };
        }
    }
}
