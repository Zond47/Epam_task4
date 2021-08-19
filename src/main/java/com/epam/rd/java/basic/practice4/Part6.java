package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that prints Cyrillic or Latin content.
 */
public class Part6 {

    public static void main(String[] args) {
        print(Demo.getInput("part6.txt"));
    }

    public static void print(String input) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            String dataType = scanner.next();
            switch (dataType.toLowerCase()) {
                case "stop":
                    quit = true;
                    break;
                case "cyrl":
                    System.out.print(dataType + ": ");
                    printPattern(input, "([А-ЯЁЄІЇа-яёєії]+)");
                    break;
                case "latn":
                    System.out.print(dataType + ": ");
                    printPattern(input, "([a-zA-Z]+)");
                    break;
                default:
                    System.out.println(dataType + ": Incorrect input");
                    break;
            }
        }
    }

    private static void printPattern(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(input);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
    }
}
