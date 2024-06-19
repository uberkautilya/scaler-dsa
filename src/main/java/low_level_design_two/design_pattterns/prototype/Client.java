package low_level_design_two.design_pattterns.prototype;

public class Client {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = st1.copy();
    }
}
