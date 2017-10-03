package net.asifhossain.java8inaction.chapter1.hashmap;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentHashSetFromHashMap {

    public static void main(String[] args) {
        Map<String, Integer> laptopPrice = new ConcurrentHashMap<>();
        laptopPrice.put("xps15", 1500);
        laptopPrice.put("xps13", 1300);
        laptopPrice.put("razor13", 1200);
        laptopPrice.put("razor14", 1700);
        laptopPrice.put("macbookpro", 2500);

        Set<Integer> concurrentHashSet = ConcurrentHashMap.newKeySet();

        System.out.println(concurrentHashSet);
    }
}
