package low_level_design.advanced_concepts.streams_lambdas;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {


        List<Integer> intList = Arrays.asList(12, 92, 7, 32, 11);
        Stream<Integer> listStream = intList.stream();
        //Intermediate operations: Update the original stream
        listStream = listStream.limit(23);
        //Terminal Operations: There can be only one on a stream
        List<Integer> result = listStream.collect(Collectors.toList());
        System.out.println("result = " + result);

        long count = intList.stream().limit(2).count();
        System.out.println("count = " + count);

        long evenCount = intList.stream().filter(e -> e % 2 == 0).count();
        System.out.println("evenCount = " + evenCount);

        List<Integer> evenIntegers = intList.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println("evenIntegers = " + evenIntegers);

        List<Integer> sortedList = intList.stream().sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("sortedList = " + sortedList);

        List<Integer> squaredElements = intList.stream().map(e -> e * e).collect(Collectors.toList());
        System.out.println("squaredElements = " + squaredElements);

        Integer evenNumber = intList.stream().filter(e -> e % 2 == 0).findFirst().orElse(12);
        System.out.println("evenNumber = " + evenNumber);

        Map<Integer, List<Integer>> collect = intList.stream()
                .collect(Collectors.groupingBy(e -> e % 5));
        System.out.println("collect = " + collect);

        Integer demo = intList.stream()
                .filter(e -> {
                    System.out.println("Filter: " + e);
                    return e % 2 == 0;
                }).map(e -> {
                    System.out.println("Map: " + e);
                    return e * e;
                }).sorted().findFirst().orElse(-1);
        System.out.println("demo = " + demo);

        Integer sum1 = intList.stream().reduce((a, b) -> a + b).orElse(-1);
        System.out.println("sum1 = " + sum1);
        //Start value is given as 100 below
        Integer sum2 = intList.stream().reduce(100, (curr_sum, element) -> curr_sum + element);
        System.out.println("sum2 = " + sum2);

        Integer maxValue = intList.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("maxValue = " + maxValue);
    }

    private static void sortExample() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(12, 32, "Student 1", "Batch 1"));
        studentList.add(new Student(1, 23, "Student 1", "Batch 1"));
        studentList.add(new Student(8, 41, "Student 1", "Batch 1"));
        studentList.add(new Student(9, 16, "Student 1", "Batch 1"));
        studentList.sort((s1, s2) -> {
            int age1 = s1.age;
            int age2 = s2.age;

            if (age1 < age2) {
                return -1;
            } else if (age1 == age2) {
                return 0;
            } else {
                return 1;
            }
        });
        System.out.println("studentList = " + studentList);

        studentList.sort(Comparator.comparingInt(s -> s.rollNo));
        System.out.println("studentList = " + studentList);
    }
}
