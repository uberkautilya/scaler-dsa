package low_level_design_two.design_pattterns.structural.decorator.logger_decorator_example;

public class ErrorLogger implements LoggerDecorator {
    Logger logger;

    public ErrorLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        System.out.print("[ERROR]");
        logger.log(message);
    }
}
