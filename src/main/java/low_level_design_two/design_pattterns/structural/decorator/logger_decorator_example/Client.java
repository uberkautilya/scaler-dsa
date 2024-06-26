package low_level_design_two.design_pattterns.structural.decorator.logger_decorator_example;

public class Client {
    public static void main(String[] args) {
        Logger l = new BasicLogger();
        l = new TimestampLogger(l);
        l = new ErrorLogger(l);

        l.log("This is a message");
    }
}
