package low_level_design.advanced_concepts.streams_lambdas;

public class Student implements Comparable<Student> {
    private String batch;
    int rollNo;
    int age;
    String name;

    public Student(int rollNo, int age, String name, String batch) {
        this.rollNo = rollNo;
        this.age = age;
        this.name = name;
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "batch='" + batch + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        //Define natural order for Student class
        return this.rollNo - student.rollNo;
    }
}
