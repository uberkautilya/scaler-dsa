package advanced.dsa37_sep11.advanced_recursion;

public class Factorial {

    public static void main(String[] args) {
        Factorial obj = new Factorial();
        int factorial = obj.factorial(23);
        System.out.println("factorial = " + factorial);
    }

    private int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
