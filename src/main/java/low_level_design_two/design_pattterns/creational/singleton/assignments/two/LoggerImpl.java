package low_level_design_two.design_pattterns.creational.singleton.assignments.two;

import org.springframework.boot.logging.LogLevel;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.PrintWriter;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;


public class LoggerImpl implements Logger {

    private static Logger logger;
    private static final Lock lock = new ReentrantLock();
    String filePath = null;
    PrintWriter printWriter = null;


    private LoggerImpl() {}

    public static Logger getInstance() {

        if(logger == null){

            lock.lock();
            if(logger == null){
                logger = new LoggerImpl();
            }
            lock.unlock();
        }
        return logger;
    }

    public static void resetInstance() {
        logger = null;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(printWriter == null) throw new IllegalStateException();
        printWriter.format("%s %s %s", new Date(), level.toString(), message);
    }

    @Override
    public void setLogFile(String filePath) {
        this.filePath = filePath;
        try{
            printWriter = new PrintWriter(new File(this.filePath));
        } catch(FileNotFoundException ex){
            //ignored
        }
    }

    @Override
    public String getLogFile() {
        return filePath;
    }

    @Override
    public void flush() {
        printWriter.flush();
    }

    @Override
    public void close() {
        printWriter.close();
        printWriter = null;
    }
}