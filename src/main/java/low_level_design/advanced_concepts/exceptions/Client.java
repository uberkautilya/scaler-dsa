package low_level_design.advanced_concepts.exceptions;

import low_level_design.advanced_concepts.exceptions.custom.A;
import low_level_design.advanced_concepts.exceptions.custom.B;
import low_level_design.advanced_concepts.exceptions.custom.C;
import low_level_design.advanced_concepts.exceptions.custom.StudentNotFoundException;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Client {
    public static void main(String[] args) {
        try {
            int divide = Student.divide();
            System.out.println("divide = " + divide);
        } catch (ClassNotFoundException | FileNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            Student.throwCustomCheckedException();
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            throw new C("Instance of C");
        } catch (A e) {
            //Parent Exception catch block can handle all subtypes
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            throw new C("Exception C creation");
        } catch (C c) {
            //Order should be child to be parent
            System.out.println("C is caught");
        } catch (B b) {
            System.out.println("B is caught");
        } catch (A a) {
            System.out.println("A is caught");
        } finally {
            System.out.println("Finally block executed");
        }

        //ERRORS
        stackOverflowCreator();
    }

    /**
     * Creates a StackOverflowError
     */
    public static void stackOverflowCreator() {
        stackOverflowCreator();
    }
}
