package fundamentals.P19.ObjectsAndClasses.Exercise;

import java.util.*;

public class P06OrderByAge {
    public static class People {
        String name;
        String id;
        int age;

        public People(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<People> peopleList = new ArrayList<>();


        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String name = data[0];
            String id = data[1];
            int age = Integer.parseInt(data[2]);

            People people = new People(name, id, age);
            peopleList.add(people);

            input = scanner.nextLine();
        }

        peopleList.sort(Comparator.comparingInt(People::getAge));

        for (People people : peopleList) {
            System.out.printf("%s with ID: %s is %d years old.%n", people.getName(), people.getId(), people.getAge());
        }

    }
}
