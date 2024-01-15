
import java.util.*;


public class Exercise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        while (!input.equals("end")) {
            String ipAddress = input.split(" ")[0].split("=")[1];
            String username = input.split(" ")[2].split("=")[1];

            if (!logs.containsKey(username)) {
                logs.put(username, new LinkedHashMap<>());
            }

            if (!logs.get(username).containsKey(ipAddress)) {
                logs.get(username).put(ipAddress, 0);
            }
            logs.get(username).put(ipAddress, logs.get(username).get(ipAddress) + 1);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> ent : logs.entrySet()) {

            System.out.println(ent.getKey() + ": ");
            int size = ent.getValue().size();

            for (Map.Entry<String, Integer> entry : ent.getValue().entrySet()) {

                System.out.printf("%s => %d", entry.getKey(), entry.getValue());

                if (size > 1) {
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }

                size -= 1;

            }


        }


    }
}
