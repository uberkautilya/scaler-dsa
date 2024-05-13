package lld.oops2.assignments;

public class Student {
    // write the code of student class here
    int age;
    String name;

    public Student(){
        this(0, null);
    }

    public Student(int age){
        this.age = age;
        this.name = null;
    }

    public Student(String name){
        this.name = name;
    }

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

}