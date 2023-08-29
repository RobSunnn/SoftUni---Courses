package fundamentals.P14.AssociativeArrays.exercise;


import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!command.equals("End")) {

            String companyName = command.split(" -> ")[0];
            String employee = command.split(" -> ")[1];

            if (!map.containsKey(companyName)) {
                map.put(companyName, new ArrayList<>());

            } else {

                if (map.get(companyName).contains(employee)) {
                    command = scanner.nextLine();
                    continue;
                }

            }
            map.get(companyName).add(employee);


            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (String element : entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }

    }
}
