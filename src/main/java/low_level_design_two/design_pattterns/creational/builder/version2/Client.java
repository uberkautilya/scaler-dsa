package low_level_design_two.design_pattterns.creational.builder.version2;

public class Client {
    public static void main(String[] args) {
        //Now we know the Builder and Student class are related
        Builder b = Student.getBuilder();
        b.setAge(101);
        b.setName("Student101");
        b.setBatch("Batch101");
        b.gradYear = 101;

        Student s = new Student(b);
        System.out.println("s = " + s);
    }
}
