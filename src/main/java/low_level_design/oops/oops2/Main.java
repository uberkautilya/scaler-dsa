package low_level_design.oops.oops2;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Name", 10);
        Student studentCopy = new Student(student);
        System.out.println("Example of deep copy");
    }
}
