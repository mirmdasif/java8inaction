package net.asifhossain.java8inaction.chapter3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author asif.hossain
 * @since 10/17/17.
 */
public class ExecutionAroundPattern {

    public static void main(String[] args) throws IOException {
        System.out.println("Limited Process File Function Can Read only One Line " + processFile());

        String firstLine = processFile(br -> br.readLine());
        System.out.println(firstLine);
        String first2Line = processFile(br -> br.readLine() + br.readLine());
        System.out.println(first2Line);
    }

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
            return processor.process(br);
        }
    }



    @FunctionalInterface
    interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }
}
