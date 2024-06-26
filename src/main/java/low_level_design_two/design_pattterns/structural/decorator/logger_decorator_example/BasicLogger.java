package low_level_design_two.design_pattterns.structural.decorator.logger_decorator_example;

public class BasicLogger implements Logger{

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
