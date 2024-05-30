package low_level_design.advanced_concepts.exceptions;

import low_level_design.advanced_concepts.exceptions.custom.StudentNotFoundException;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Student {
    public static int divide() throws ClassNotFoundException, SQLException, FileNotFoundException {
        //ArithmeticException
        int i = 0;
        if (i == 0) {
            throw new ClassNotFoundException();
        } else if (i == 1) {
            //No need to declare with throws declaration. Unchecked Exceptions are expected to be handled by the developer
            throw new ArithmeticException();
        } else if (i == 2) {
            throw new SQLException();
        } else if (i == 3) {
            throw new FileNotFoundException();
        }
        return 100/0;
    }

    public static String throwCustomCheckedException() throws StudentNotFoundException {
        throw new StudentNotFoundException("Some Text");
    }
}
