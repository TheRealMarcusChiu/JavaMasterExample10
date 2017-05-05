package native_java.java_8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Stream {

    @Test
    public void testForeach() {
        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);
    }

    @Test
    public void testMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map(i -> i*i).collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    @Test
    public void testFilter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count: " + count);
    }

    @Test
    public void testLimit() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> limit = strings.stream().limit(3).collect(Collectors.toList());
        limit.forEach(System.out::println);
    }

    @Test
    public void testSort() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> sorted = strings.stream().sorted().collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void testParallelStream() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.parallelStream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    @Test
    public void testCollectors() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }

    @Test
    public void testStatistics() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.parallelStream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

    @Test
    public void test() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("First List");
        strings.forEach(string -> System.out.println(string));

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("\nSecond List");
        filtered.forEach(System.out::println);
    }
}

