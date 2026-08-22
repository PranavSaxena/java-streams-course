package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExercises {

    static void filterEvenNumbers(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }

    static void greaterThanN(int n){
        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 15, 3);

        List<Integer> greater = numbers.stream()
                .filter(a -> a > n)
                .collect(Collectors.toList());

        System.out.println(greater);
    }

    static void convertToUpperCase(){
        List<String> names = Arrays.asList("john", "alex", "bob");

        List<String> upperCaseList = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseList);
    }

    static void findMax(){
        List<Integer> numbers = Arrays.asList(10, 25, 5, 40, 15);

        Integer max = numbers.stream()
                        .mapToInt(Integer::intValue)
                                .max().getAsInt();

        System.out.println(max);
    }

    static void findMin(){
        List<Integer> numbers = Arrays.asList(10, 25, 5, 40, 15);

        Integer max = numbers.stream()
                .mapToInt(Integer::intValue)
                .min().getAsInt();

        System.out.println(max);
    }

    static void countElements(){
        List<String> names = Arrays.asList("John", "Alex", "Bob", "David");

        long count = names.stream().count();
        System.out.println(count);
    }

    static void removeDuplicate(){
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> unique = numbers.stream()
                .distinct().collect(Collectors.toList());

        System.out.println(unique);
    }

    static void sort(){
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);

        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());

        System.out.println(sorted);
    }

    static void findFirst(){
        List<String> names = Arrays.asList("John", "Alex", "Bob");

        String first = names.stream().findFirst().get();

        System.out.println(first);
    }

    static void checkGreaterThanN(int n){
        List<Integer> numbers = Arrays.asList(10, 20, 30, 60, 40);

        boolean b = numbers.stream().anyMatch(a -> a > n);

        System.out.println(b);
    }

    static void exercise1(){
        //Remove duplicates
        //Sort alphabetically
        //Convert to uppercase
        //Collect the result into a List
        //Expected Output: [ALEX, BOB, DAVID, JOHN]
        List<String> names = Arrays.asList(
                "John", "Alex", "John", "Bob", "Alex", "David"
        );

        List<String> result = names.stream()
                .distinct()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);

    }

    static void exercise2(){
//        Remove duplicates
//        Keep only numbers greater than 10
//        Sort in ascending order
//        Collect into a List
//        Expected Output: [15, 20, 30]
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 5, 30, 10);

        List<Integer> result = numbers.stream()
                .distinct()
                .filter(n -> n > 10)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    static void exercise3(){
//        Keep names whose length is greater than 4
//        Convert them to uppercase
//        Sort alphabetically
//        Collect into a List
//        Expected Output: [ALEXANDER, CHRISTOPHER, DAVID]
        List<String> names = Arrays.asList(
                "John", "Alexander", "Bob", "David", "Amy", "Christopher"
        );

        List<String> result = names.stream()
                .filter(s -> s.length() > 4)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    static void exercise4(){
//        Keep only even numbers
//        Square them
//        Collect into a List
//        Expected Output: [4, 16, 36, 64]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(number-> number*number)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    static void exercise5(){
//        Find all names starting with "A", convert them to uppercase, and sort them.
//        Expected: [ALEX, ALICE, ANDREW]

        List<String> names = Arrays.asList(
                "Alex", "Bob", "Andrew", "David", "Alice", "John"
        );

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }

    static void exercise6(){
//        Calculate the average
//        Find numbers greater than the average
//        Collect them into a List
//        Expected : [40, 50]

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> result = numbers.stream()
                .filter(number -> number > numbers.stream()
                                                .mapToInt(Integer::intValue)
                                                .average().getAsDouble()
                )
                .collect(Collectors.toList());

        System.out.println(result);
    }

    static void exercise7(){
        // find max even number
        // Expected : 42
        List<Integer> numbers = Arrays.asList(11, 24, 35, 42, 18, 51);

        int result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        System.out.println(result);

    }

    static void exercise8(){
        // Find the second-highest number
        // Expected : 40
        List<Integer> numbers = Arrays.asList(10, 25, 30, 25, 40, 50, 40);

        Integer i = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

        System.out.println(i);
    }

    static void exercise9(){
        // Find the Longest Name
        // Expected : Christopher
        List<String> names = Arrays.asList(
                "John", "Alexander", "Bob", "Christopher", "David"
        );

        String result = names.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst().get();

//        names.stream().distinct().max(Comparator.comparing(String::length)).get();        // alternate approach

        System.out.println(result);
    }

    public static void main(String[] args) {
//        filterEvenNumbers();
//        greaterThanN(10);
//        convertToUpperCase();
//        findMax();
//        findMin();
//        countElements();
//        removeDuplicate();
//        sort();
//        findFirst();
//        checkGreaterThanN(50);
//        exercise1();
//        exercise2();
//        exercise3();
//        exercise4();
//        exercise5();
//        exercise6();
//        exercise7();
//        exercise8();
        exercise9();
    }

}
