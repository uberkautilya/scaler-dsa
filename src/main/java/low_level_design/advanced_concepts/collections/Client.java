package low_level_design.advanced_concepts.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student(1, 21, "Student 1", "September 2023");
        Student s2 = new Student(2, 31, "Student 2", "December 2023");
        Student s3 = new Student(3, 11, "Student 3", "September 2023");
        Student s4 = new Student(4, 19, "Student 4", "July 2023");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s4);
        studentList.add(s1);
        studentList.add(s3);
        studentList.add(s2);

        //Uses Natural Order defined in the class, as implemented in the Student class
        Collections.sort(studentList);
        System.out.println("studentList = " + studentList);

        //Order provided by a Comparator
        studentList.sort(new StudentAgeComparator());
        System.out.println("studentList = " + studentList);
    }
}
