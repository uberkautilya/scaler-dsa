package low_level_design.oops.oops3;

public class Student extends User{
    private String course;
    String batch;
    int age;
    int rollNo;
    void attendClass(){
        System.out.println("Attend class");
    }

    static String uId = "sID";
    static void display101() {
        System.out.println("Student class");
    }
}
