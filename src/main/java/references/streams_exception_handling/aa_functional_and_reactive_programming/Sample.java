package references.streams_exception_handling.aa_functional_and_reactive_programming;

import io.reactivex.rxjava3.core.Flowable;

import java.util.List;

public class Sample {
    public static boolean isEven(int number) {
        System.out.println("isEven called for " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt called for " + number);
        return number * 2;
    }

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6);

        numbers.stream()
                .filter(Sample::isEven)
                .map(Sample::doubleIt)
                .limit(1)
                .forEach(System.out::println);

        System.out.println("--------");
        Flowable.fromIterable(numbers)
                .filter(Sample::isEven)
                .map(Sample::doubleIt)
                .take(1)
                .subscribe(System.out::println);
    }
}

//Functional style == declarative + higher order functions

//Functional programming == functional composition + lazy evaluation

//Reactive programming == Functional programming++

