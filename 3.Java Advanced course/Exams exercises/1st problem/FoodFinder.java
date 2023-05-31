package Exams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();

        for (String s : firstArr) {

            vowels.offer(s);
        }
        for (String s : secondArr) {

            consonants.push(s);
        }
        StringBuilder pear = new StringBuilder("pear");
        StringBuilder flour = new StringBuilder("flour");
        StringBuilder pork = new StringBuilder("pork");
        StringBuilder olive = new StringBuilder("olive");
        List<String> products = new ArrayList<>();

        while (consonants.size() > 0) {
            String vowel = vowels.poll();
            String consonant = consonants.pop();

            if (pear.toString().contains(vowel)) {
                pear = new StringBuilder(pear.toString().replaceAll(vowel, ""));
            }
            if (pear.toString().contains(consonant)) {

                pear = new StringBuilder(pear.toString().replaceAll(consonant, ""));
            }
            if (flour.toString().contains(vowel)) {
                flour = new StringBuilder(flour.toString().replaceAll(vowel, ""));
            }
            if (flour.toString().contains(consonant)) {
                flour = new StringBuilder(flour.toString().replaceAll(consonant, ""));
            }
            if (pork.toString().contains(vowel)) {
                pork = new StringBuilder(pork.toString().replaceAll(vowel, ""));
            }
            if (pork.toString().contains(consonant)) {
                pork = new StringBuilder(pork.toString().replaceAll(consonant, ""));
            }
            if (olive.toString().contains(vowel)) {
                olive = new StringBuilder(olive.toString().replaceAll(vowel, ""));
            }
            if (olive.toString().contains(consonant)) {
                olive = new StringBuilder(olive.toString().replaceAll(consonant, ""));
            }


            vowels.addLast(vowel);

        }
        if (pear.length() <= 0) {
            products.add("pear");
        }
        if (flour.length() <= 0) {
            products.add("flour");
        }
        if (pork.length() <= 0) {
            products.add("pork");
        }
        if (olive.length() <= 0) {
            products.add("olive");
        }


        System.out.printf("Words found: %d%n", products.size());

        for (String s : products) {
            System.out.println(s);
        }


    }
}
