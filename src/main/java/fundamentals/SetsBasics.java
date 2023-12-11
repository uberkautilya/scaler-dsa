package fundamentals;

import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class SetsBasics {
    public static void main(String[] args) {
        HashSet<Book> bookSet = new HashSet<>();
        Book book1 = new Book("Java Basics");
        bookSet.add(book1);
        //Returns true
        System.out.println(bookSet.contains(book1));

        //The new hashCode calculated to fetch the object from the set cannot give back the original object
        book1.title = "A new title";
        //Returns false: To eliminate this scenario, avoid mutable fields in hashCode and equals methods
        //Alternatively, remove the object, modify it and put this back
        System.out.println(bookSet.contains(book1));

        new HashSet<Integer>(initialCapacity(10_000, 0.75f), 0.75f);

        TreeSet<Book> bookTreeSet = new TreeSet<>();
        //Cannot add as Comparable not implemented in Book class
        bookTreeSet.add(book1);
        //The other alternative is to pass a comparator in the constructor of the TreeSet.
    }


    static int initialCapacity(int expectedCount, float loadFactor) {
        int capacity = (int) (expectedCount / loadFactor) + 1;
        //HashSet will reallocate with rehashing when loadFactor of allocated memory is reached.
        System.out.println(capacity);
        return capacity;
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
