package low_level_design_two.design_pattterns.structural.decorator.logger_decorator_example;

public class TimestampLogger implements LoggerDecorator {
    Logger logger;

    public TimestampLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        System.out.print("[Timestamp]");
        logger.log(message);
    }
}
