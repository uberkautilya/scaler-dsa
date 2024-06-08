package low_level_design.oops.oops2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Name", 10);
        Student studentCopy = new Student(student);
        System.out.println("Example of deep copy");

        int sum = 10;
        int result = IntStream.rangeClosed(1, 10).reduce(sum, (a, b) -> a + b);
        System.out.println("result = " + result);
    }
}
