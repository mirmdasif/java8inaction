package net.asifhossain.java8inaction.domain;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    public static List<Apple> getApples() {
        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple("green", 100));
        apples.add(new Apple("green", 50));
        apples.add(new Apple("green", 150));

        apples.add(new Apple("red", 100));
        apples.add(new Apple("red", 50));
        apples.add(new Apple("red", 150));

        return apples;
    }
}