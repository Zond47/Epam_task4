package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that parses the text file and returns sentences.
 */
public class Part4 implements Iterable<String> {
    private StringBuilder text;

    public Part4(String text) {
        this.text = new StringBuilder(text);
    }

    public static void main(String[] args) {
        String input = Demo.getInput("part4.txt");
        Part4 part4 = new Part4(input);

        for (String item : part4) {
            System.out.println(item);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<String> {
        Pattern p = Pattern.compile("(.*?)[^.]*?[.?!]");
        Matcher matcher = p.matcher(text);
        int lastIndex = 0;

        @Override
        public boolean hasNext() {
            return lastIndex != text.length();
        }

        @Override
        public String next() {
            if (matcher.find()) {
                lastIndex = matcher.end();
                return matcher.group().replaceAll(System.lineSeparator(), " ").trim();
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
