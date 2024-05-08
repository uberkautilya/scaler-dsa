package lld.oops1.main_package;

public class Client {
    public static void main(String[] args) {
        Student x = new Student();
        x.age = 45;
        System.out.println("x.age = " + x.age);

        Student y = x;
        y.age += 10;
        System.out.println("x.age = " + x.age);

        x.age = 90;
//        x.name = "Mithun"; // private fields can't be directly accessed
        x.setName("Mithun"); //The setter is not private - it's package-private: More control over setting
        x.batch = "Java";
        x.rollNo = 23;

        Student student = new Student("Mithun", "Batch", 32, 10);
        System.out.println("student = " + student);
    }
}
