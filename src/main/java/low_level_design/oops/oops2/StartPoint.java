package low_level_design.oops.oops2;

public class StartPoint {
    public static void main(String[] args) {
        Student s1 = new Student(12, "Mithun", 89);

        //Deep copy - A new Student object with primitives used
        Student s2 = new Student(s1.age, s1.name, s1.psp);

        //Also DEEP COPY
        Student s3 = new Student();
        s3.age = s1.age;
        s3.name = s1.name;
        s3.psp = s1.psp;

        //Also Deep Copy: A COPY CONSTRUCTOR
        Student s4 = new Student(s1);
    }
}
