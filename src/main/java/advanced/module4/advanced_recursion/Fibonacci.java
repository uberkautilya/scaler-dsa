package advanced.module4.advanced_recursion;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        int fibonacci = obj.fibonacci(5);
        System.out.println("fibonacci = " + fibonacci);
    }

    private int fibonacci(int num) {
        if (num <= 1) {
            //Fibonacci Series: 0 1 1 2 3 5
            //fib(2) = fib(1) + fib(0) is the base condition
            return num;
        }
        int n1 = fibonacci(num - 1);
        int n2 = fibonacci(num - 2);
        return n1 + n2;
    }
}
