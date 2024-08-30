import java.util.Comparator;
import java.util.TreeSet;

class TreeSetWithComparatorExample {
    public static void main(String[] args) {

         Comparator<Person> ageComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.age, p2.age);
            }
        };
        // Creating a TreeSet with a custom comparator
        TreeSet<Person> personSet = new TreeSet<>(ageComparator);

        // Adding elements to the TreeSet
        personSet.add(new Person("Alice", 30));
        personSet.add(new Person("Bob", 25));
        personSet.add(new Person("Charlie", 35));
        personSet.add(new Person("David", 20));

        // Displaying the TreeSet (sorted by age)
        for (Person person : personSet) {
            System.out.println(person);
        }
    }



}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
        public String toString() {
            return name + " (" + age + ")";
        }
}