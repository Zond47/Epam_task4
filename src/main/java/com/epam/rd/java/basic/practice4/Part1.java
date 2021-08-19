package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that displays the content of the text file to console, deleting the first two
 * characters of each word with the length of 4 and more characters.
 */
public class Part1 {

    public static void main(String[] args) {
        System.out.println(convert(Demo.getInput("part1.txt")));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("(?<word>[a-zA-Z-а-яА-Я]{4,})");
        Matcher matcher = p.matcher(input);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, matcher.group().substring(2));
        }
        return buffer.toString();
    }
}
