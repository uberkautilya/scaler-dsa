package homeworks_experiments;

public class RomanNumerals {
    public static void main(String[] args) {

        intToRoman(9);

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
                "M_1000s: %d" +
                "\nD_500s: %d" +
                "\nC_100s: %d" +
                "\nL_50s: %d" +
                "\nX_10s: %d" +
                "\nV_5s: %d" +
                "\nI_1s: %d", M_1000s, D_500s, C_100s, L_50s, X_10s, V_5s, I_1s);

        StringBuilder sb = new StringBuilder();
        while (M_1000s > 0) {
            sb.append("M");
            M_1000s--;
        }
        if (D_500s > 0 && C_100s == 4) {
            sb.append("CM");
        } else {
            if (D_500s > 0) {
                sb.append("D");
            }
            if (C_100s == 4) {
                sb.append("CD");
            } else {
                while (C_100s > 0) {
                    sb.append("C");
                    C_100s--;
                }
            }
        }
        if (L_50s > 0 && X_10s == 4) {
            sb.append("XC");
        } else {
            if (L_50s > 0) {
                sb.append("L");
            }
            if (X_10s == 4) {
                sb.append("XL");
            } else {
                while (X_10s > 0) {
                    sb.append("X");
                    X_10s--;
                }
            }
        }
        if (V_5s > 0 && I_1s == 4) {
            sb.append("IX");
        } else {
            if (V_5s > 0) {
                sb.append("V");
            }
            if (I_1s == 4) {
                sb.append("IV");
            } else {
                while (I_1s > 0) {
                    sb.append("I");
                    I_1s--;
                }
            }
        }
        System.out.printf("\nRoman Numeral for %d: %s", A, sb.toString());
    }
}
