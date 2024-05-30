package low_level_design.advanced_concepts.exceptions.custom;

public class A extends StudentNotFoundException{
    public A(String message) {
        super(message);
    }
}
