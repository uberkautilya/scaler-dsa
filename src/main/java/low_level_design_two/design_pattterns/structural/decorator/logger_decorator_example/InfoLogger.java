package low_level_design_two.design_pattterns.structural.decorator.logger_decorator_example;

public class InfoLogger implements LoggerDecorator {
    Logger logger;

    public InfoLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        System.out.print("[INFO]");
        logger.log(message);
    }
}
