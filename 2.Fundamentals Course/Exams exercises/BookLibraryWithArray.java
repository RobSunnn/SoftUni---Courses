package fundamentals.exams;

import java.util.Scanner;

public class BookLibraryWithArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] booksOnShelf = scanner.nextLine().split("&");

        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] action = command.split("\\| ");


            switch (action[0]) {
                case "Add Book ":
                    String bookName = action[1];
                    for (int i = 0; i < booksOnShelf.length; i++) {
                        boolean isThere = true;

                        //Adding the book
                        if (!bookName.equals(booksOnShelf[i])) {
                            String newBooksOnShelf = bookName + "&" + String.join("&", booksOnShelf);
                            booksOnShelf = newBooksOnShelf.split("&");
                            break;
                        } else {
                            break;
                        }

                    }
                    break;
                case "Take Book ":
                    String bookNameToTake = action[1];

                    for (int i = 0; i < booksOnShelf.length - 1; i++) {
                        boolean isDiff = true;
                        if (bookNameToTake.equals(booksOnShelf[i])) {
                            for (int j = i; j <= booksOnShelf.length - 1; j++) {
                                booksOnShelf[j] = booksOnShelf[j + 1];
                                if (booksOnShelf[j].equals(booksOnShelf[booksOnShelf.length - 1])) {
                                    break;
                                }
                            }


                            String[] removeBooks = new String[booksOnShelf.length - 1];
                            for (int j = 0; j < removeBooks.length; j++) {
                                removeBooks[j] = booksOnShelf[j];
                            }
                            booksOnShelf = removeBooks;
                            break;
                        }
                        if (!isDiff) {
                            break;
                        }
                    }
                    break;
                case "Swap Books":
                    String firstBookToSwap = action[1];
                    String secondBookToSwap = action[2];
                    int firstIndex = 0;
                    int secondIndex = 0;
                    for (int i = 1; i <= 1; i++) {
                        boolean isEqual = false;
                        for (int j = 0; j < booksOnShelf.length; j++) {
                            if (firstBookToSwap.equals(booksOnShelf[j])) {
                                firstIndex = j;

                            }
                            if (secondBookToSwap.equals(booksOnShelf[j])) {
                                secondIndex = j;
                                isEqual = true;
                            }
                            if (isEqual) {
                                String oldElement = booksOnShelf[firstIndex];
                                booksOnShelf[firstIndex] = booksOnShelf[secondIndex];
                                booksOnShelf[secondIndex] = oldElement;
                                break;
                            }
                        }
                        if (isEqual) {
                            break;
                        }
                    }

                    break;
                case "Insert Book ":
                    String givenBook = action[1];
                    for (int i = 0; i < booksOnShelf.length; i++) {
                        boolean isThere = false;
                        if (givenBook.equals(booksOnShelf[i])) {
                            isThere = true;
                            break;
                        }
                        if (!isThere) {
                            String tempBooks = givenBook + "&" + String.join(" &", booksOnShelf);
                            booksOnShelf = tempBooks.split("&");

                            for (int j = 0; j < booksOnShelf.length - 1; j++) {
                                booksOnShelf[j] = booksOnShelf[j + 1];
                            }
                            booksOnShelf[booksOnShelf.length - 1] = givenBook;
                            break;
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < booksOnShelf.length - 1; i++) {
            System.out.print(booksOnShelf[i] + ", ");
        }
        System.out.print(booksOnShelf[booksOnShelf.length - 1]);

    }

}


