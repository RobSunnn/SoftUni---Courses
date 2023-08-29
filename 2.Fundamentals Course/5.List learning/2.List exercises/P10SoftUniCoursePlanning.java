package fundamentals.P12.Lists.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coursesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("course start")) {
            String command = inputLine.split(":")[0];

            switch (command) {
                case "Add":
                    String lessonTitleToAdd = inputLine.split(":")[1];
                    if (!coursesList.contains(lessonTitleToAdd)) {
                        coursesList.add(lessonTitleToAdd);
                    }
                    break;
                case "Insert":
                    String lessonTitleToInsert = inputLine.split(":")[1];
                    int indexToInsert = Integer.parseInt(inputLine.split(":")[2]);
                    if (!coursesList.contains(lessonTitleToInsert)) {
                        if (indexToInsert >= 0 && indexToInsert <= coursesList.size() - 1) {
                            coursesList.add(indexToInsert, lessonTitleToInsert);
                        }
                    }
                    break;
                case "Remove":
                    String lessonTitleToRemove = inputLine.split(":")[1];
                    coursesList.remove(lessonTitleToRemove);
                    coursesList.remove(lessonTitleToRemove + "-Exercise");
                    break;
                case "Swap":

                    String firstLessonTitleToSwap = inputLine.split(":")[1];
                    String secondLessonTitleToSwap = inputLine.split(":")[2];


                    if (coursesList.contains(firstLessonTitleToSwap) && coursesList.contains(secondLessonTitleToSwap)) {
                        int indexOfFirstLesson = coursesList.indexOf(firstLessonTitleToSwap);
                        int indexOfSecondLesson = coursesList.indexOf(secondLessonTitleToSwap);

                        coursesList.set(indexOfFirstLesson, secondLessonTitleToSwap);
                        coursesList.set(indexOfSecondLesson, firstLessonTitleToSwap);


                        if (coursesList.contains(firstLessonTitleToSwap + "-Exercise")) {

                            coursesList.add(indexOfSecondLesson + 1, firstLessonTitleToSwap + "-Exercise");
                            coursesList.remove(indexOfFirstLesson + 2);

                        }
                        if (coursesList.contains(secondLessonTitleToSwap + "-Exercise")) {
                            coursesList.add(indexOfFirstLesson + 1, secondLessonTitleToSwap + "-Exercise");
                            coursesList.remove(indexOfSecondLesson + 2);
                        }
                    }
                    break;
                case "Exercise":
                    String lessonTitle = inputLine.split(":")[1];
                    String exercise = lessonTitle + "-Exercise";
                    if (!coursesList.contains(exercise)) {
                        if (coursesList.contains(lessonTitle)) {
                            int index = coursesList.indexOf(lessonTitle);
                            coursesList.add(index + 1, exercise);
                        } else {
                            coursesList.add(lessonTitle);
                            coursesList.add(lessonTitle + "-Exercise");
                        }
                    }
                    break;

            }

            inputLine = scanner.nextLine();
        }

        for (int i = 0; i < coursesList.size(); i++) {
            System.out.println(i + 1 + "." + coursesList.get(i));
        }
    }
}
