/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author adinashby
 */
public class Stream1 {

    public static void main(String[] args) throws IOException {
        // List of 10 names
        // filter -> start with "a"
        // 4/10 meet the criteria above
        // sort 4 names
        // Map -> "Hello " + name + "!"

        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(x -> System.out.println(x));
        System.out.println();

        // 2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum()
        );
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names) // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        // 8. Stream rows from text file, sort, filter, and print
        Stream<String> bands = Files.lines(Paths.get("/Users/adinashby/Desktop/bands.txt"));
        bands
                .filter(x -> x.length() > 13)
                .sorted()
                .forEach(System.out::println);

        bands.close();

        // 9. Stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("/Users/adinashby/Desktop/bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));

        // 10. Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("/Users/adinashby/Desktop/data.txt"));

        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();

        // 11. Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("/Users/adinashby/Desktop/data.txt"));

        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));

        rows2.close();

        // 12. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        // 13. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);

        Integer[] integers = {1, 2, 3, 4, 99};
        final Integer sum = Arrays.stream(integers).reduce(0, Integer::sum);
        System.out.println(sum);
        
//        Integer
//        .mapToInt(i -> i);
//        
//        .getAsDouble();
        
        Collectors.joining(",");
        
        //george james maria
        
        //georgejamesmaria
        
        //george,james,maria
                
                

    }

}
