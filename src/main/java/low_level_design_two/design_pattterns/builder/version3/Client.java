package low_level_design_two.design_pattterns.builder.version3;

public class Client {
    public static void main(String[] args) {
        //Now we know the Builder and Student class are related
        Builder b = Student.getBuilder()
                .setAge(101)
                .setName("Student101")
                .setBatch("Batch101")
                .setGradYear(101);

        Student s = new Student(b);
        System.out.println("s = " + s);
    }
}
