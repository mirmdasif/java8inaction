package net.asifhossain.java8inaction.chapter1.file;

import java.io.File;
import java.util.Arrays;


public class HiddenFilesLister {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new File(".").listFiles(File::isHidden)));
    }
}
