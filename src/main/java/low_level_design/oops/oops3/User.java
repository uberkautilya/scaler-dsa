package low_level_design.oops.oops3;

public class User {
    int id;
    String name;
    //This cannot be accessed from child class - not inherited as per Java doc(even though they are part of children)
    private int rollNo;

    void login(){
        System.out.println("User has logged in");
    }

    static String uId = "uID";
    static void display101() {
        System.out.println("User");
    }
}
