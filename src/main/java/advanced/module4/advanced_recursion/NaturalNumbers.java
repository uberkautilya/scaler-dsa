package advanced.module4.advanced_recursion;

public class NaturalNumbers {
    public static void main(String[] args) {
        NaturalNumbers nn = new NaturalNumbers();
        int sum = nn.sum(3);
        System.out.println("sum = " + sum);
    }

    private int sum(int num) {
        if (num == 1) {
            //If there is no base condition, we get stack overflow - MLE: Memory Limit Exceeded
            //TLE is thrown first as it is an infinite loop
            return 1;
        }
        return num + sum(num - 1);
    }
}
