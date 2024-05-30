package low_level_design.advanced_concepts.exceptions.custom;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
