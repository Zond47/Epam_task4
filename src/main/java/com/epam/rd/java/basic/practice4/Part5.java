package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class that works with resources.properties content.
 */
public class Part5 {

    public static void main(String[] args) {
        print();
    }

    public static void print() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String key = scanner.next();
            if (key.equals("stop")) {
                break;
            }
            String locale = scanner.next();
            Locale current = new Locale(locale);
            ResourceBundle rb = ResourceBundle.getBundle("resources", current);
            String keyWord = rb.getString(key);
            System.out.println(keyWord);
        }
    }
}
