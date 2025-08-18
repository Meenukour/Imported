package org.java8.features;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamEvaluation - Comprehensive examples of Java 8+ Stream API usage
 * 
 * This class demonstrates various stream operations including:
 * - Character counting and frequency analysis
 * - String manipulation and transformation
 * - Collection processing and filtering
 * - Age calculation using LocalDate
 * - Advanced stream operations like grouping and partitioning
 * 
 * Run this class to see practical examples of stream processing.
 */
public class StreamEvaluation {

    /**
     * Main method demonstrating various Stream API operations
     * Each section shows a different aspect of stream processing
     */
    public static void main(String[] args) {
        
        // Example 1: Character frequency counting
        // Input: "string data to count each character"
        // Output: Character frequency map {s=1, t=5, r=3, i=1, n=2, g=1, etc.}
        String s = "string data to count each character";

//        s.chars().mapToObj(string -> (char) string).
//                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().forEach(System.out::println);


        // Example 2: String word reversal using streams
        // Input: "Java Concept Of The Day"
        // Output: "avaJ tpecnoC fO ehT yaD"
        // Demonstrates: split, map with StringBuffer.reverse(), and joining


        String input = "Java Concept Of The Day";
        Arrays.stream(input.split(" ")).map(word->new StringBuffer(word).reverse()).collect(Collectors.joining(" "));



        // Example 3: Age calculation using LocalDate and Period
        // Demonstrates: Date manipulation with Java 8 time API

        LocalDate birthDate = LocalDate.of(1992,04,11);
        LocalDate now = LocalDate.now();
        System.out.println("Age is"+ Period.between(now,birthDate).getYears());

        // Example 4: Finding duplicates in a collection
        // Input: ["Java", "Spring", "JPA", "Java", "Cloud", "JPA"]
        // Output: Duplicate elements (Java, JPA)
        // Demonstrates: groupingBy, filtering, and collecting

        List<String> strList = List.of("Java", "Spring", "JPA", "Java", "Cloud", "JPA");

        strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).forEach(System.out::println);

        Predicate<List> listPredicate = List::isEmpty;
        listPredicate.test(strList);





    }


        Supplier<String> supplier = ()-> {
            return "This is a supplier" ;};

    Consumer consumer =(a)->{
        System.out.println("hello");
    };

    Function function = ( x)->
    {
        return x;
    };



}
