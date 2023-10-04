package fundamentals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReferencesExample {

    public static void main(String[] args) {
        Set<Integer> markSet = new HashSet<>(Arrays.asList(12, 43, 89));
        ReferencesExample refExample = new ReferencesExample();
        Student student = refExample.new Student(markSet);
        System.out.println("student = " + student);
        Set<Integer> marks = student.getMarks();
        marks.remove(43);
        System.out.println("student = " + student);
        student.setMarks(marks);
        System.out.println("markSet = " + markSet);
    }



    private class Student{
        Set<Integer> marks;

        public Student(Set<Integer> marks) {
            this.marks = marks;
        }

        public Set<Integer> getMarks() {
            return marks;
        }

        public void setMarks(Set<Integer> marks) {
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "marks=" + marks +
                    '}';
        }
    }
}
