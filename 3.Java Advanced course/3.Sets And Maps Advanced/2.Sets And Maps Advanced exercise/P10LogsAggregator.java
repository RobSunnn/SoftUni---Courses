import java.util.*;


public class P10LogsAggregator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countLines = Integer.parseInt(scanner.nextLine());

        Map<String, LogInfo> userLogs = new TreeMap<>();

        for (int i = 0; i < countLines; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String ipAddress = inputLine[0];
            String username = inputLine[1];
            int duration = Integer.parseInt(inputLine[2]);

            userLogs.putIfAbsent(username, new LogInfo());
            userLogs.get(username).ipAddresses.add(ipAddress);
            userLogs.get(username).duration += duration;

        }

        for (Map.Entry<String, LogInfo> e : userLogs.entrySet()) {
            System.out.printf("%s: %d %s%n", e.getKey(), e.getValue().duration,
                    e.getValue().ipAddresses);
        }


    }


}

class LogInfo {
    Set<String> ipAddresses = new TreeSet<>();
    int duration;

    public LogInfo() {
        this.duration = 0;
    }
}

