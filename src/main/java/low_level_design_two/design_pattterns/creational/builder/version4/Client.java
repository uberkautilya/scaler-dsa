package low_level_design_two.design_pattterns.creational.builder.version4;

public class Client {
    public static void main(String[] args) {
        //Now we know the Builder and Student class are related
        Student student = Student.getBuilder()
                .setAge(101)
                .setName("Student101")
                .setBatch("Batch101")
                .setGradYear(101)
                //build() method is available in the Builder, which will return new Student(this);
                .build();

        System.out.println("student = " + student);
    }
}
