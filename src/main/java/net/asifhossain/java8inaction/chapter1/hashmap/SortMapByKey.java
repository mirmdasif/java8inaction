package net.asifhossain.java8inaction.chapter1.hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByKey {
    public static void main(String[] args) {
        Map<String, Integer> laptopPrice = new HashMap<>();
        laptopPrice.put("xps15", 1500);
        laptopPrice.put("xps13", 1300);
        laptopPrice.put("razor13", 1200);
        laptopPrice.put("razor14", 1700);
        laptopPrice.put("macbookpro", 2500);

        System.out.println(" Unsorted Map : " + laptopPrice.toString());

        // Sorted values
        laptopPrice.values().stream()
                .sorted()
                .forEach(System.out::println);

        // Sorted Entries by value
        laptopPrice.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .forEach(System.out::println);

        // Create a map from sorted stream : wrong way
        Map<String, Integer> sortedByPrice =
                laptopPrice.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Sorted by price (Wrong Because It's HashMap) : " + sortedByPrice);
        System.out.println("Returned Maps Type " + sortedByPrice.getClass());

        // Create a map from sorted stream : right way LinkedHashMap
        sortedByPrice =
                laptopPrice.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Sorted by price (Right Way Because It's LinkedHashMap) : " + sortedByPrice);
    }
}
