package net.asifhossain.java8inaction.chapter3;

import net.asifhossain.java8inaction.domain.Apple;
import net.asifhossain.java8inaction.domain.Bucket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import static net.asifhossain.java8inaction.chapter2.FilterAppleByStrategy.filter;

/**
 * @author asif.hossain
 * @since 10/10/17.
 */
@SuppressWarnings("all")
public class FunctionalInterfaces {

    public static void main(String[] args) {
        List<Apple> greenApple = filter(Bucket.getApples(), (Apple a) -> "green".equals(a.getColor()));

        System.out.println(greenApple);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 1");
            }
        };

        Runnable r2 = () -> System.out.println("Hello World 2");

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3"));
        process(() -> {
        });

        // Functional Descriptors

        // T -> Boolean
        Predicate<Apple> appleWeightPredicate = a -> a.getWeight() > 100;

        // T -> Void
        Consumer<String> stringConsumer = s -> {
            System.out.println(s);
        };

        stringConsumer.accept("Black Whole");

        // T -> R
        Function<Integer, Double> intToDouble = a -> (double) a;

        // () -> T
        Supplier<Apple> heavyGreenApple = () -> new Apple("green", 150);
        System.out.println(heavyGreenApple.get());

        // T -> T
        UnaryOperator<Integer> sqare = x -> x * x;
        System.out.println("Sqare of 3 is : " + sqare.apply(3));


        // (T, T) -> T
        BinaryOperator<Integer> multiplier = (x, y) -> x * y;
        System.out.println("3 multiply with 5 is : " + multiplier.apply(3, 5));

        // (L, R) -> boolean
        BiPredicate<Integer, Double> biPredicate = (x, y) -> x > 0 && y < 10;
        System.out.println("Test 3 is greater than 0 and 3/3 < 10 : " + biPredicate.test(3, 3.0 / 3.2));

        // (U, V) -> void
        BiConsumer<Integer, Double> printer = (x, y) -> System.out.println("X : " + x + " Y : " + y);
        printer.accept(1, 2.0);

        BiFunction<Integer, String, Apple> appleCreator = (x, y) -> new Apple(y, x);

        System.out.println("Apple created by function : " + appleCreator.apply(100, "red"));
    }

    public static void process(Runnable r) {
        r.run();
    }

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T target);
    }

    @FunctionalInterface
    interface Adder {
        int add(int a, int b);
    }

    // Not a functional interface
    public interface SmartAdder extends Adder {
        long add(long a, long b);
    }

    // Not a functional interface
    public class Nothing {

    }
}
