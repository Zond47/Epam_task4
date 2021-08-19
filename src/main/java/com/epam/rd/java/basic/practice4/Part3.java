package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that prints required data type: char, int, double, String.
 */
public class Part3 {

    public static void main(String[] args) {
        print(Demo.getInput("part3.txt"));
    }

    public static void print(String input) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            String dataType = scanner.next();
            switch (dataType) {
                case "stop":
                    quit = true;
                    break;
                case "char":
                    printRequiredData(input, "(\\b([a-zA-Z-а-яА-Я]{1})\\b)");
                    break;
                case "int":
                    printRequiredData(input, "(?<=\\s|^)\\d+(?=\\s|$)");
                    break;
                case "double":
                    printRequiredData(input, "(\\d*\\.)\\d+");
                    break;
                case "String":
                    printRequiredData(input, "(?<word>[a-zA-Z-а-яА-Я]{2,})");
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    private static void printRequiredData(String input, String s) {
        Pattern p = Pattern.compile(s);
        Matcher matcher = p.matcher(input);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
    }
}
