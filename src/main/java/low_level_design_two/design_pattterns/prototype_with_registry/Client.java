package low_level_design_two.design_pattterns.prototype_with_registry;

public class Client {
    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        Student sst = registry.getStudentPrototype("SST");
        System.out.println("sst = " + sst);
    }
}
