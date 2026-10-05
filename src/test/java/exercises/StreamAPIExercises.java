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

    static class Employee {
        private String name;
        private int age;
        private double salary;
        private String department;

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }

    }

    static List<Employee> employees = Arrays.asList(
            new Employee("John", 28, 45000, "Sales"),
            new Employee("Alex", 32, 65000, "IT"),
            new Employee("Robert", 35, 85000, "Finance"),
            new Employee("Emily", 26, 55000, "Sales"),
            new Employee("David", 30, 40000, "IT"),
            new Employee("Sophia", 29, 75000, "Finance"),
            new Employee("Michael", 40, 50000, "Sales"),
            new Employee("Emma", 31, 95000, "IT")
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

    }

    static void exercise40() {

    }

    static void exercise41() {

    }

    static void exercise42() {

    }

    static void exercise43() {

    }

    static void exercise44() {

    }

    static void exercise45() {

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
        exercise38();
    }

}
