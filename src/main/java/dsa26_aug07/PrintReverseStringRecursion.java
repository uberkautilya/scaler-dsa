package dsa26_aug07;

import java.util.Objects;
import java.util.Scanner;

public class PrintReverseStringRecursion {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        reversePrint(scanner.nextLine());
    }

    public static void reversePrint(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return;
        }
        System.out.print(str.substring(str.length() - 1));
        reversePrint(str.substring(0, str.length() - 1));
    }
}

/*
2, 10 -> 4, 5 -> 4* (16, 2) -> 4* 256,1 -> 4* 256,0
 */