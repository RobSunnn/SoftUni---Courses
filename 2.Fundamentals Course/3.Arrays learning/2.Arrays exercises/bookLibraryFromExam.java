package fundamentals.P08.Arrays.exercise;

import java.util.Scanner;

public class bookLibraryFromExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] booksOnShelf = scanner.nextLine().split("&");
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] command = input.split(" \\| ");


            switch (command[0]) {
                case "Add Book":
                    String bookToAdd = command[1];
                    for (int i = 0; i < command.length - 1; i++) {
                        boolean isNotThere = false;
                        for (int j = 0; j < booksOnShelf.length; j++) {
                            if (!bookToAdd.equals(booksOnShelf[j])) {
                                isNotThere = true;
                            } else {
                                isNotThere = false;
                            }
                        }
                        if (!isNotThere) {
                            String newBooks = bookToAdd + "&" + String.join("&", booksOnShelf);
                            booksOnShelf = newBooks.split("&");
                        }
                    }
                    break;
                case "Take Book":
                    String bookToTake = command[1];
                    for (int i = 0; i < booksOnShelf.length; i++) {

                        if (bookToTake.equals(booksOnShelf[i])) {

                            for (int j = i; j < booksOnShelf.length; j++) {
                                booksOnShelf[j] = booksOnShelf[j + 1];
                                if (booksOnShelf[j].equals(booksOnShelf[booksOnShelf.length - 1])) {
                                    break;
                                }
                            }
                            String[] newBooks = new String[booksOnShelf.length - 1];
                            for (int j = 0; j < newBooks.length; j++) {
                                newBooks[j] = booksOnShelf[j];
                            }
                            booksOnShelf = newBooks;
                            break;
                        }

                    }

                    break;
                case "Swap Books":
                    String firstBookToSwap = command[1];
                    String secondBookToSwap = command[2];
                    int firstIndex = 0;
                    int secondIndex = 0;
                    boolean bothEqual = false;
                    for (int i = 1; i <= 1; i++) {

                        for (int j = 0; j < booksOnShelf.length; j++) {
                            if (firstBookToSwap.equals(booksOnShelf[j])) {
                                firstIndex = j;
                            }
                            for (int k = 0; k < booksOnShelf.length; k++) {
                                if (secondBookToSwap.equals(booksOnShelf[k])) {
                                    secondIndex = k;
                                }
                                if (firstBookToSwap.equals(booksOnShelf[j]) && secondBookToSwap.equals(booksOnShelf[k])) {
                                    bothEqual = true;
                                }

                            }


                        }
                        if (bothEqual) {
                            String oldElement = booksOnShelf[firstIndex];
                            booksOnShelf[firstIndex] = booksOnShelf[secondIndex];
                            booksOnShelf[secondIndex] = oldElement;
                        }
                    }
                    break;
                case "Insert Book":
                    String givenBook = command[1];

                    for (int i = 0; i < booksOnShelf.length; i++) {

                        if (givenBook.equals(booksOnShelf[i])) {

                            break;
                        } else {
                            String tempBooks = givenBook + "&" + String.join("&", booksOnShelf);
                            booksOnShelf = tempBooks.split("&");
                            for (int j = 0; j < booksOnShelf.length; j++) {
                                booksOnShelf[j] = booksOnShelf[j + 1];
                                if (booksOnShelf[j].equals(booksOnShelf[booksOnShelf.length - 1])) {
                                    break;
                                }
                            }
                            booksOnShelf[booksOnShelf.length - 1] = givenBook;
                            break;
                        }
                    }
                    break;
                case "Check Book":
                    int bookToCheck = Integer.parseInt(command[1]);

                    if (bookToCheck >= 0 && bookToCheck < booksOnShelf.length - 1) {
                        System.out.println(booksOnShelf[bookToCheck]);
                    }

                    break;

            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < booksOnShelf.length - 1; i++) {
            System.out.print(booksOnShelf[i] + ", ");
        }
        System.out.print(booksOnShelf[booksOnShelf.length - 1]);
    }
}
