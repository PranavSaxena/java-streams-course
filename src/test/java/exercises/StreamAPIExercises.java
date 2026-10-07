package exercises;

import java.util.*;
import java.util.function.Function;
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


    static void exercise10(){
//        Count Names Starting With "A"
//        Expected : 3
        List<String> names = Arrays.asList(
                "Alex", "Bob", "Andrew", "David", "Alice", "John"
        );

        long result = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println(result);
    }

    static void exercise11(){
        // Convert List to Comma-Separated String
        // Expected : John, Alex, Bob, David

        List<String> names = Arrays.asList(
                "John", "Alex", "Bob", "David"
        );

        String result = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    static void exercise12(){
        // find duplicates in List.of(1, 2, 3, 2, 3, 4, 5)

        List<Integer> list = List.of(1, 2, 3, 2, 3, 4, 5);

        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = list.stream()
                                        .filter(value->!seen.add(value))
                                        .collect(Collectors.toList());
        System.out.println(duplicates);
    }

    static void exercise13(){
        List<Integer> filterEvenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filterEvenNumbers.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> filterGreaterThan10 = Arrays.asList(5, 12, 8, 20, 15, 3);
        List<Integer> greaterThan10 = filterGreaterThan10.stream().filter(n->n>10).collect(Collectors.toList());
        System.out.println(greaterThan10);

        List<String> makeUpperCaseNames = Arrays.asList("john", "alex", "bob");
        List<String> upperCaseNames = makeUpperCaseNames.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        List<Integer> findMax = Arrays.asList(10, 25, 5, 40, 15);
        Integer max = findMax.stream().max(Integer::compareTo).orElse(null);
        System.out.println(max);

        List<Integer> findMin = Arrays.asList(10, 25, 5, 40, 15);
        Integer min = findMin.stream().min(Integer::compareTo).orElse(null);
        System.out.println(min);

        List<String> countElements = Arrays.asList("John", "Alex", "Bob", "David");
        Long numberOrElements = countElements.stream().count();
        System.out.println(numberOrElements);

        List<String> countNameFrequency = Arrays.asList("John", "Alex", "Bob", "David");
        Map<String, Long> nameCountMap = countNameFrequency.stream()
                                                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(nameCountMap);

        List<Integer> removeDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> removedDups = removeDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(removedDups);

        List<Integer> sortNumbers = Arrays.asList(5, 2, 8, 1, 3);
        List<Integer> sortedNumers = sortNumbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumers);

        List<String> findFirstElement = Arrays.asList("John", "Alex", "Bob");
        String firstElement = findFirstElement.stream().findFirst().orElse(null);
        System.out.println(firstElement);

        List<Integer> checkAnyGreaterThan50 = Arrays.asList(10, 20, 30, 60, 40);
        Boolean anyNumberGreaterThan50 = checkAnyGreaterThan50.stream().anyMatch(n->n>50);
        System.out.println(anyNumberGreaterThan50);
    }

    static void exercise14(){
        List<String> names = Arrays.asList(
                "John", "Alex", "John", "Bob", "Alex", "David"
        );

//        Remove duplicates
//        Sort alphabetically
//        Convert to uppercase
//        Collect the result into a List

        List<String> result = names.stream().distinct().sorted().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result);

    }
    static void exercise15(){
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 5, 30, 10);

//        Remove duplicates
//        Keep only numbers greater than 10
//        Sort in ascending order

        List<Integer> result = numbers.stream()
                                    .distinct()
                                    .filter(n->n>10)
                                    .sorted()
                                    .collect(Collectors.toList());
        System.out.println(result);
    }
    static void exercise16(){
        List<String> names = Arrays.asList(
                "John", "Alexander", "Bob", "David", "Amy", "Christopher"
        );

//        Keep names whose length is greater than 4
//        Convert them to uppercase
//        Sort alphabetically

        List<String> result = names.stream()
                                .filter(str->str.length()>4)
                                .map(String::toUpperCase)
                                .sorted()
                                .collect(Collectors.toList());
        System.out.println(result);
    }
    static void exercise17(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
//        Keep only even numbers
//        Square them
        List<Integer> result = numbers.stream()
                                    .filter(n->n%2==0)
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println(result);
    }
    static void exercise18(){
        List<String> names = Arrays.asList(
                "Alex", "Bob", "Andrew", "David", "Alice", "John"
        );

//      Find all names starting with "A", convert them to uppercase, and sort them.

        List<String> result = names.stream()
                .filter(str->str.startsWith("A"))
                .map(String::toUpperCase).sorted()
                .collect(Collectors.toList());
        System.out.println(result);

    }
    static void exercise19(){
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
//        Calculate the average
//        Find numbers greater than the average
        List<Integer> result = numbers.stream()
                .filter(n->n>numbers.stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0))
                .collect(Collectors.toList());
        System.out.println(result);
    }
    static void exercise20(){
        List<Integer> numbers = Arrays.asList(11, 24, 35, 42, 18, 51);
//      Find the Maximum Even Number
        Integer result = numbers.stream()
                .filter(n->n%2==0)
                .max(Integer::compareTo).orElse(0);
        System.out.println(result);

    }
    static void exercise21(){
        List<Integer> numbers = Arrays.asList(10, 25, 30, 25, 40, 50, 40);
//      Find the second highest unique number.
        Integer result = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(0);
        System.out.println(result);
    }

    static void exercise22() {
        List<String> names = Arrays.asList(
                "Alex", "Bob", "Andrew", "David", "Alice", "John"
        );
//        Count Names Starting With "A"
        Long result = names.stream()
                .filter(str -> str.startsWith("A"))
                .count();
        System.out.println(result);
    }

    static void exercise23() {
        List<String> names = Arrays.asList(
                "John", "Alexander", "Bob", "Christopher", "David"
        );
//        Find the Longest Name
        String result = names.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println(result);
    }

    static void exercise24() {
        List<String> names = Arrays.asList(
                "John", "Alex", "Bob", "David"
        );
//      Convert List to Comma-Separated String
        String result = names.stream()
                .collect(Collectors.joining(","));
        System.out.println(result);
    }

    static void exercise25() {
        List<String> names = Arrays.asList(
                "John", null, "Alex", null, "Bob"
        );
//      Remove Null Values
        List<String> result = names.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise26() {
        List<Integer> numbers = Arrays.asList(
                1, 2, 3, 2, 4, 5, 3, 6, 4
        );
//        Find Duplicate Elements
        Set<Integer> dup = new HashSet<>();
        List<Integer> result = numbers.stream()
                .filter(n-> !dup.add(n))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise27() {
        List<Integer> numbers = Arrays.asList(
                1, 2, 3, 2, 4, 5, 3, 6, 4
        );
//      Find Unique Elements
        List<Integer> result = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise28() {
        List<String> names = Arrays.asList(
                "John", "Alex", "Christopher"
        );
//        Convert Strings to Their Lengths
        List<Integer> result = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise29() {
        List<String> names = Arrays.asList(
                "john", "alex", "JOHN", "bob", "Alex", "david"
        );
//        Convert all names to lowercase, remove duplicates, sort them
        List<String> result = names.stream()
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise30() {
        List<Integer> numbers = Arrays.asList(
                10, 15, 20, 25, 30
        );
//        Sum of Even Numbers
        Integer result = numbers.stream()
                .filter(n->n%2==0)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }

    static void exercise31() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        Product of Numbers
        int result = numbers.stream()
                .reduce(1, (a,b) -> a*b);
        System.out.println(result);
    }


    static List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "IT", 60000, 28),
            new Employee(2, "Alex", "HR", 45000, 32),
            new Employee(3, "David", "IT", 80000, 35),
            new Employee(4, "Sarah", "Finance", 70000, 29),
            new Employee(5, "Mike", "IT", 55000, 26),
            new Employee(6, "Emma", "HR", 65000, 30),
            new Employee(7, "Robert", "Finance", 50000, 40),
            new Employee(8, "Sophia", "IT", 90000, 32),
            new Employee(9, "Daniel", "Finance", 75000, 31),
            new Employee(10, "Olivia", "HR", 48000, 27)
    );

    static void exercise33() {
        // Find employees whose salary > 50000
        // Sort by salary in ascending order

        List<Employee> result = employees.stream()
                .filter(n ->  n.getSalary() > 50000)
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise34() {
//        find the employee having the highest salary
        Employee result = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(result);
    }

    static void exercise35() {
//        find the names of employees whose salary is greater than 50000.
//        Convert the names to uppercase and sort them alphabetically.
        List<String> result = employees.stream()
                .filter(n -> n.getSalary() > 50000)
                .map(Employee::getName)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise36() {
//        Group Employees by Age
        Map<Integer, List<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(result);
    }

    static void exercise37() {
//        find the number of employees in each department
        Map<String, Long> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
        System.out.println(result);
    }

    static void exercise38() {
//        Highest Salary in Each Department
        Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));
        System.out.println(result);
    }

    static void exercise39() {
//        divide them into two groups: Salary >= 50000 & Salary < 50000
        Map<Boolean, List<Employee>> result = employees.stream()
                .collect(Collectors.partitioningBy(n-> n.getSalary()>50000));
        System.out.println(result);
    }

    static void exercise40() {
        List<Integer> numbers = Arrays.asList(
                10, 15, 20, 10, 25, 30, 15, 40, 50, 20
        );
        System.out.println(numbers);

//      Unique numbers
        List<Integer> result = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique numbers: " + result);

//      Even numbers
        result = numbers.stream()
                .filter(n -> n%2==0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + result);

//      Numbers greater than 20
        result = numbers.stream()
                .filter(n->n>20)
                .collect(Collectors.toList());
        System.out.println("Numbers > 20: " + result);

//      Second highest number
        int secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .max(Integer::compareTo).orElse(0);
        System.out.println("secondHighest: "  + secondHighest);

//      Sum of all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("sum: " + sum);

//      Average of all numbers
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
        System.out.println("average: " + average);

//      Maximum number
        int max = numbers.stream()
                .max(Integer::compareTo).orElse(0);
        System.out.println("max: " + max);

//      Minimum number
        int min = numbers.stream()
                .sorted()
                .findFirst().orElse(0);
        System.out.println("min: " + min);
    }

    static void exercise41() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);
//      Square the Numbers
        List<Integer> result = numbers.stream()
                .map(n-> n*n)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    static void exercise42() {
        List<Integer> numbers = Arrays.asList(15, 8, 23, -4, 11, 30, 7, 30);
        System.out.println(numbers);

//      Find Odd Numbers in Descending Order
        List<Integer> result = numbers.stream()
                .filter(n -> n%2!=0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result);

//        Find the Largest Number
        int largest = numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
        System.out.println("largest: " + largest);

        int smallest = numbers.stream()
                .sorted()
                .findFirst().get();
        System.out.println("smallest: " + smallest);

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);
        System.out.println("average: " + average);

        long greaterThan10 = numbers.stream()
                .filter(n -> n > 10)
                .count();
        System.out.println("greaterThan10: " + greaterThan10);

        boolean checkGreaterThan10 = numbers.stream()
                .anyMatch(n->n>10);
        System.out.println("checkGreaterThan10: " + checkGreaterThan10);

        boolean checkAllPositive = numbers.stream()
                .anyMatch(n-> n<0);
        System.out.println(checkAllPositive);

        List<Integer> removeDuplicate = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(removeDuplicate);

        int secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(secondHighest);

        int secondLowest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst().get();
        System.out.println(secondLowest);
    }

    static void exercise43() {
        List<String> names = Arrays.asList(
                "John", "Alexander", "Bob", "Christopher", "David", "Sam", "David"
        );
        System.out.println(names);

//        all names whose length is greater than 5
        List<String> namesGreaterThan5 = names.stream()
                .filter(n -> n.length() > 5)
                .collect(Collectors.toList());
        System.out.println(namesGreaterThan5);

        // convert all to uppercase
        List<String> allUppercase = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(allUppercase);

//        names in descending alphabetical order.
        List<String> namesDescending = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(namesDescending);

        // first long name (10)
        String firstLongName = names.stream()
                .filter(n -> n.length() > 10)
                .findFirst().get();
        System.out.println(firstLongName);

        // check if Christopher is present
        boolean checkName = names.stream()
                .anyMatch(n -> n.equals("Christopher"));
        System.out.println(checkName);

        // check empty string
        boolean checkEmpty = names.stream()
                .anyMatch(String::isEmpty);
        System.out.println(checkEmpty);

        // find string lengths
        List<Integer> stringLength = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(stringLength);

        // total characters
        long totalCharacters = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(totalCharacters);

        // 3 longest names
        List<String> longest3Names = names.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(longest3Names);

        // repeated names
        Set<String> dup = new HashSet<>();
        List<String> repeatedNames = names.stream()
                .filter(name-> !dup.add(name))
                .collect(Collectors.toList());
        System.out.println(repeatedNames);

        // most frequently occurring name
        String mostFrequentName = names.stream()
                .collect(Collectors.groupingBy(name-> name, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(mostFrequentName);

    }

    static void exercise44() {
        List<Integer> numbers = Arrays.asList(
                15, 42, 27, 60, 33, 18, 55, 27, 33, 60
        );
        System.out.println(numbers);

        //largest even number
        int largestEven = numbers.stream()
                .filter(n->n%2==0)
                .max(Comparator.comparing(Integer::intValue)).orElse(0);
        System.out.println(largestEven);

        int smallestOdd = numbers.stream()
                .filter(n->n%2!=0)
                .min(Comparator.comparing(Integer::intValue)).orElse(0);
        System.out.println(smallestOdd);

        // uniques in descending order
        List<Integer> uniqueDescending = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(uniqueDescending);

        // greater than average
        List<Integer> greaterThanAverage = numbers.stream()
                .filter(n-> n > numbers.stream().collect(Collectors.averagingInt(Integer::intValue)))
                .collect(Collectors.toList());
        System.out.println(greaterThanAverage);

        // top 3 unique
        List<Integer> top3Unique = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(top3Unique);

        // numbers occurring exactly once
        List<Integer> exactlyOnce = numbers.stream()
                .collect(Collectors.groupingBy(n-> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n->n.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(exactlyOnce);

        // separate odd and even
        Map<Boolean, List<Integer>> separateOddEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Odd :" + separateOddEven.get(true));
        System.out.println("Even :" + separateOddEven.get(false));
    }

    static void exercise45() {
        System.out.println(employees);

//      Employees With Salary Above 60,000
        List<String> salaryAbove60k = employees.stream()
                .filter(n->n.getSalary() > 60000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(salaryAbove60k);

        // employee names
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeeNames);

        // IT employees
        List<String> allITEmployees = employees.stream()
                .filter(n->n.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(allITEmployees);

        // sorted by salary
        List<String> sortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(sortedBySalary);

        // highest paid employee
        String highestPaidEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName).orElse(null);
        System.out.println(highestPaidEmployee);

        // lowest paid employee
        String lowestPaidEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .orElse(null);
        System.out.println(lowestPaidEmployee);

        // count IT employees
        long totalITEmployees = employees.stream()
                .filter(n -> n.getDepartment().equals("IT"))
                .count();
        System.out.println(totalITEmployees);

        // count employees with salary above 60k
        long employeeSalaryMoreThan60k = employees.stream()
                .filter(n-> n.getSalary() > 60000)
                .count();
        System.out.println(employeeSalaryMoreThan60k);

        // average IT salary
        double averageSalary = employees.stream()
                .filter(n-> n.getDepartment().equals("IT"))
                .mapToDouble(Employee::getSalary)
                .average().orElse(0);
        System.out.println(averageSalary);

        // total salary
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum).get();
        System.out.println(totalSalary);

        // oldest employee
        String oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .map(Employee::getName)
                .orElse(null);
        System.out.println(oldestEmployee);

        // older than 30
        List<String> employeesOlderThan30 = employees.stream()
                .filter(n-> n.getAge() > 30)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeesOlderThan30);

        // employees between 50k and 70k
        List<String> employeesBetween50kAnd70K = employees.stream()
                .filter(n-> n.getSalary() >= 50000 && n.getSalary() <= 70000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(employeesBetween50kAnd70K);

        // starting with S
        List<String> startingWithS = employees.stream()
                .map(Employee::getName)
                .filter(name-> name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(startingWithS);
    }

    static void exercise46() {

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
//        exercise9();
//        exercise10();
//        exercise11();
//        exercise12();
//        exercise13();
//        exercise14();
//        exercise15();
//        exercise16();
//        exercise17();
//        exercise18();
//        exercise19();
//        exercise20();
//        exercise21();
//        exercise22();
//        exercise23();
//        exercise24();
//        exercise25();
//        exercise26();
//        exercise27();
//        exercise28();
//        exercise29();
//        exercise30();
//        exercise31();
//        exercise33();
//        exercise34();
//        exercise35();
//        exercise36();
//        exercise37();
//        exercise38();
//        exercise39();
//        exercise40();
//        exercise41();
//        exercise42();
//        exercise43();
//        exercise44();
        exercise45();
    }

}
