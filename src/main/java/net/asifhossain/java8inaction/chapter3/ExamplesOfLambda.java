package net.asifhossain.java8inaction.chapter3;

import net.asifhossain.java8inaction.domain.Apple;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

@SuppressWarnings("all")
public class ExamplesOfLambda {

    public static void main(String[] args) {

        Comparator<Apple> appleWeightComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple apple1, Apple apple2) {
                return apple1.getWeight() - apple2.getWeight();
            }
        };

        Comparator<Apple> appleWeightComparatorLambda = (Apple ap1, Apple ap2) -> ap1.getWeight() - ap2.getWeight();

        Formatter<String, Integer> formatter = s -> s.length();

        Predicate<Apple> heavyApplePredicate = (Apple apple) -> apple.getWeight() > 100;

        BiConsumer<Integer, Integer> sum = (x, y) -> {
            System.out.print("Result : ");
            System.out.println(x + y);
        };

        sum.accept(1, 2);

        Supplier supplier = () -> 42;

        System.out.println(supplier.get());

        Predicate<List<String>> listPredicate = strings -> strings.isEmpty();

        Supplier<Apple> heavyRedAppleSuplier = () -> new Apple("red", 150);

        //Extract from object
        Function<Apple, String> appleColorExtractor = (Apple apple) -> apple.getColor();

        System.out.println(appleColorExtractor.apply(heavyRedAppleSuplier.get()));

        // Combine two value
        BiFunction<Integer, Integer, Integer> multiplier = (a, b) -> a * b;

        System.out.println("Multiply using lambda : " + multiplier.apply(10, 20));

        // Compare 2 values.
        Comparator<Apple> appleColorComparator = (Apple a, Apple b) -> a.getColor().compareTo(b.getColor());
    }

    interface Formatter<I, T> {
        T formatInt(I s);
    }
}
