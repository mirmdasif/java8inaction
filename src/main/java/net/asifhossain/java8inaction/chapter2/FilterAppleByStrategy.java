package net.asifhossain.java8inaction.chapter2;

import net.asifhossain.java8inaction.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class FilterAppleByStrategy {

    public static void main(String[] args) {

        System.out.println(filterApple(Bucket.getApples(), new GreenColorApplePredicate()));
        System.out.println(filterApple(Bucket.getApples(), new AppleHeavyWeightPredicate()));

        prettyPrintApple(Bucket.getApples(), new SimpleAppleFormatter());
        prettyPrintApple(Bucket.getApples(), new PrettyAppleFormatter());

    }

    interface ApplePredicate {
        boolean test(Apple apple);
    }

    static class GreenColorApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 100;
        }
    }

    static List<Apple> filterApple(List<Apple> apples, ApplePredicate ap) {
        List<Apple> matchedApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (ap.test(apple)) {
                matchedApples.add(apple);
            }
        }

        return matchedApples;
    }

    interface AppleFormatter {
        String format(Apple apple);
    }

    static class SimpleAppleFormatter implements AppleFormatter {
        @Override
        public String format(Apple apple) {
            return apple.toString();
        }
    }

    static class PrettyAppleFormatter implements AppleFormatter {
        @Override
        public String format(Apple apple) {
            return "A" + (apple.getWeight() > 100 ? " heavy" : " light") + " " + apple.getColor() + " apple.";

        }
    }

    static void  prettyPrintApple(List<Apple> apples, AppleFormatter formatter) {
        for (Apple apple : apples) {
            System.out.println(formatter.format(apple));
        }
    }
}
