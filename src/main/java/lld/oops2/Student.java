package lld.oops2;

public class Student {
    int age;
    String name;
    int psp;
    Exam exam;

    public Student() {
    }

    public Student(int age, String name, int psp) {
        this.age = age;
        this.name = name;
        this.psp = psp;
        this.exam = new Exam(1, 0);
    }

    /**
     * A COPY Constructor: Parameter data type is same as the current class
     * @param source the object from which to be copied
     */
    public Student(Student source) {
        this.age = source.age;
        this.name = source.name;
        this.psp = source.psp;
        //This is shallow copy - copies exam object's reference
        this.exam = source.exam;
        //This is deep copy: To the level of the primitive data types
        this.exam = new Exam(source.exam.examId, source.exam.score);
    }
}
