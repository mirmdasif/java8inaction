package net.asifhossain.java8inaction.chapter2;

import net.asifhossain.java8inaction.domain.Apple;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class FilteringApple {

    public static void main(String[] args) {
        System.out.println(filterGreenApples(Bucket.getApples()));
        System.out.println(filterApplesByColor(Bucket.getApples(), "red"));
        System.out.println(filterApplesByWeight(Bucket.getApples(), 50));
    }

    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple>  greenApples = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                greenApples.add(apple);
            }
        }

        return greenApples;
    }

    public static List<Apple> filterApplesByColor(List<Apple> apples, String color) {
        List<Apple>  matchedApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                matchedApples.add(apple);
            }
        }

        return matchedApples;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
        List<Apple>  matchedApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > weight) {
                matchedApples.add(apple);
            }
        }

        return matchedApples;
    }
}
