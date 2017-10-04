package net.asifhossain.java8inaction.chapter2;

import net.asifhossain.java8inaction.domain.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class FilterAppleByStrategy {

    public static void main(String[] args) {

        List<Apple> apples = Bucket.getApples();

        System.out.println(filter(Bucket.getApples(), new GreenColorApplePredicate()));
        System.out.println(filter(Bucket.getApples(), new AppleHeavyWeightPredicate()));

        prettyPrintApple(Bucket.getApples(), new SimpleAppleFormatter());
        prettyPrintApple(Bucket.getApples(), new PrettyAppleFormatter());

        // Green apples
        System.out.println(filter(Bucket.getApples(), apple -> "green".equals(apple.getColor())));

        // Heavy weight apples
        System.out.println(filter(Bucket.getApples(), apple -> apple.getWeight() > 100));


        // Sort by weight
        apples.sort(compareInt(Apple::getWeight));
        System.out.println(apples);

        // Sort by color
        apples.sort(compareString(Apple::getColor));
        System.out.println(apples);
    }

    interface Predicate<T> {
        boolean test(T obj);
    }

    static class GreenColorApplePredicate implements Predicate<Apple> {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class AppleHeavyWeightPredicate implements Predicate<Apple> {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 100;
        }
    }

    static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
        List<T> matchedApples = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                matchedApples.add(element);
            }
        }

        return matchedApples;
    }

    interface Formatter<T> {
        String format(T target);
    }

    static class SimpleAppleFormatter implements Formatter<Apple> {
        @Override
        public String format(Apple target) {
            return target.toString();
        }
    }

    static class PrettyAppleFormatter implements Formatter<Apple> {
        @Override
        public String format(Apple target) {
            return "A" + (target.getWeight() > 100 ? " heavy" : " light") + " " + target.getColor() + " apple.";

        }
    }

    static void prettyPrintApple(List<Apple> apples, Formatter formatter) {
        for (Apple apple : apples) {
            System.out.println(formatter.format(apple));
        }
    }

    static <T> Comparator<T> compareInt(IntExtractor<T> extractor) {
        return (o1, o2) -> extractor.extractInt(o1) - extractor.extractInt(o2);
    }

    static <T> Comparator<T> compareString(Formatter<T> formatter) {
        return (o1, o2) -> formatter.format(o1).compareTo(formatter.format(o2));
    }

    interface IntExtractor<T> {
        int extractInt(T ob);
    }
}
