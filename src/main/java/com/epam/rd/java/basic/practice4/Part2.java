package com.epam.rd.java.basic.practice4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Class that creates and fills a file with random numbers, sorts them and writes result to other file.
 */

public class Part2 {

    public static void main(String[] args) {
        String fileNameGenerated = "part2.txt";
        String fileNameSorted = "part2_sorted.txt";
        createAndFill(fileNameGenerated);
        sortAndWrite(fileNameGenerated, fileNameSorted);

        System.out.print("input ==> ");
        printToConcole(fileNameGenerated);
        System.out.print("output ==> ");
        printToConcole(fileNameSorted);
    }

    private static void createAndFill(String fileNameGenerated) {
        try (FileWriter writer = new FileWriter(fileNameGenerated)) {
            SecureRandom random = new SecureRandom();
            for (int i = 0; i < 10; i++) {
                writer.write(random.nextInt(50) + " ");
            }
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }

    private static void sortAndWrite(String fileName, String fileNameSorted) {
        try (Scanner scanner = new Scanner(new FileReader(fileName));
             FileWriter writer = new FileWriter(fileNameSorted)) {
            int[] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = scanner.nextInt();
            }

            int temp;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 1; j < (numbers.length - i); j++) {
                    if (numbers[j - 1] > numbers[j]) {
                        temp = numbers[j - 1];
                        numbers[j - 1] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                writer.write(numbers[i] + " ");
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void printToConcole(String fileName) {
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.print(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        }
        System.out.println();
    }
}
