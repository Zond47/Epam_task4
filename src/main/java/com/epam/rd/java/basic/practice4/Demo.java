package com.epam.rd.java.basic.practice4;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Demo demonstrates the actions of all the functionality.
 */
public class Demo {

    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) {
        System.out.println("=========================== PART1");
        Part1.main(args);

        System.out.println("=========================== PART2");
        Part2.main(args);

        System.out.println("=========================== PART3");
        // set the mock input
        System.setIn(new ByteArrayInputStream(
                "char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part3.main(args);
        // restore the standard input
        System.setIn(STD_IN);

        System.out.println("=========================== PART4");
        Part4.main(args);

        System.out.println("=========================== PART5");
        // set the mock input
        System.setIn(new ByteArrayInputStream(
                "table ru^table en^apple ru^stop".replace("^",
                        System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part5.main(args);
        // restore the standard input
        System.setIn(STD_IN);

        System.out.println("=========================== PART6");
        // set the mock input
        System.setIn(new ByteArrayInputStream(
                "Latn^Cyrl^asdf^latn^cyrl^stop".replace("^",
                        System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        Part6.main(args);
        // restore the standard input
        System.setIn(STD_IN);
    }

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
        return sb.toString();
    }
}
