package homeworks_experiments;

public class ArrayArgumentReference {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        //Changes made in the function will reflect in the original array
        fun(arr);
        System.out.println(arr[3]);
    }

    static void fun(int[] arr) {
        arr[3] = 98;
        return;
    }
}
