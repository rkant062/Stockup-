import java.util.HashSet;
import java.util.TreeSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

class SetAndHashtableExample {

    public static void main(String[] args) {

        // 1. HashSet Example
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // Duplicate element, won't be added

        System.out.println("HashSet contents:");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }

        // 2. TreeSet Example
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Lion");
        treeSet.add("Tiger");
        treeSet.add("Elephant");
        treeSet.add("Lion"); // Duplicate element, won't be added

        System.out.println("\nTreeSet contents (sorted order):");
        for (String animal : treeSet) {
            System.out.println(animal);
        }

        // 3. Hashtable Example
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("USA", 331);
        hashtable.put("India", 1391);
        hashtable.put("China", 1444);
        hashtable.put("Brazil", 213);

        System.out.println("\nHashtable contents:");
        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " million");
        }

        // Check for the presence of a key in Hashtable
        String country = "India";
        if (hashtable.containsKey(country)) {
            System.out.println("\n" + country + " is present in the hashtable with population: " + hashtable.get(country) + " million");
        }
    }
}
