package lld.oops1.main_package.sub_package;

import lld.oops1.main_package.Student;

public class Client {
    public static void main(String[] args) {
        Student s = new Student();
//        s.name = "Mithun"; //private members can't be accessed outside the class
//        s.batch = "Java"; //package-private can't be accessed outside the package
//        s.age = 31; //protected members can't be accessed outside the package - even sub packages, unless it is inside a child class
        s.rollNo = 23; //public members can be accessed anywhere
    }
}
