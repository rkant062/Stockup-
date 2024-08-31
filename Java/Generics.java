import java.util.Arrays;
import java.util.List;

class Box<T> {
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}

class NumberBox<T extends Number> { // T must be a subclass of Number
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }

    public double doubleValue() {
        return content.doubleValue();
    }
}

public class Generics {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element);
        }
    }

    public static void printList(List<?> list) {
    for (Object element : list) {
        System.out.print(element);
    }
}
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println(stringBox.get());

        Box<Integer> integerBox = new Box<>();
        integerBox.set(123);
        System.out.println(integerBox.get());

        Integer[] intArray = {1, 2, 3, 4};
        String[] stringArray = {"A", "B", "C"};

        Generics.printArray(intArray); // No need to specify <Integer>
        Generics.printArray(stringArray);

        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.set(123);
        System.out.println(intBox.doubleValue());

        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.set(45.67);
        System.out.println(doubleBox.doubleValue());

         List<String> stringList = Arrays.asList("A", "B", "C");
    List<Integer> intList = Arrays.asList(1, 2, 3);

    printList(stringList); // List<?> allows for any type of List
    printList(intList);
    }
}
