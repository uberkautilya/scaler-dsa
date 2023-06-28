package experiments;

public class RomanNumerals {
    public static void main(String[] args) {

        intToRoman(4678);

    }

    public static void intToRoman(int A) {
        int M_1000s = A / 1000;
        int D_500s = (A % 1000) / 500;
        int C_100s = (A % 500) / 100;
        int L_50s = (A % 100) / 50;
        int X_10s = (A % 50) / 10;
        int V_5s = (A % 10) / 5;
        int I_1s = (A % 5);

        System.out.printf("\nSecond Alternative\n" +
                "Ms: %d" +
                "\nDs: %d" +
                "\nCs: %d" +
                "\nLs: %d" +
                "\nXs: %d" +
                "\nVs: %d" +
                "\nIs: %d", M_1000s, D_500s, C_100s, L_50s, X_10s, V_5s, I_1s);
    }
}
