package low_level_design_two.design_pattterns.creational.builder.version1;

public class Client {
    public static void main(String[] args) {
        //Create a builder object first: Can be improved - maintainability
        Builder b = new Builder();
        b.setAge(101);
        b.setName("Student101");
        b.setBatch("Batch101");
        b.gradYear = 101;

        //Here sense of belonging isn't present
        Student s = new Student(b);
        System.out.println("s = " + s);
    }
}
