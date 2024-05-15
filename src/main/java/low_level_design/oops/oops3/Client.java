package low_level_design.oops.oops3;

public class Client {
    public static void main(String[] args) {
        User u = new User();
        Student student = new Student();
        User stu = new Student();

        System.out.println("u.uId = " + u.uId);
        System.out.println("student.uId = " + student.uId);

        // stu hides the Student level static data members
        System.out.println("stu.uId = " + stu.uId);

        u.display101();
        student.display101();
        // stu hides the Student(object) level static methods
        stu.display101();


        System.out.println("-----------------------");
        User.display101();
        Student.display101();

        System.out.println("User.uId = " + User.uId);
        System.out.println("Student.uId = " + Student.uId);
    }
}
