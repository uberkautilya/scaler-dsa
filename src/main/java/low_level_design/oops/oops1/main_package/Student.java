package low_level_design.oops.oops1.main_package;

public class Student {
    private String name;
    String batch; //default - package-private access modifier applied implicitly
    protected int age;
    public int rollNo;

    public Student() { //default constructors are of the access modifier public like the custom constructor here
        this.name = "new_student";
        this.batch = "java";
        this.age = 31;
        this.rollNo = 1;
    }

    Student(String name, String batch, int age, int rollNo) {
        this.name = name;
        this.batch = batch;
        this.age = age;
        this.rollNo = rollNo;
    }

    public void print() {
        System.out.println("Name: " + name);
    }

    void attendClasses() {
        System.out.println("Attending classes");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (age < 20) {
            //This kind of control is made possible as the field is private and the getter is the method that provides controlled access
            return null;
        }
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", age=" + age +
                ", rollNo=" + rollNo +
                '}';
    }
}
