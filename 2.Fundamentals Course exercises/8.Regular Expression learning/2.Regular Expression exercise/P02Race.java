package fundamentals.P17.RegularExpression.Exercise;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String regexForName = "[A-Za-z]+";
        Pattern patternForName = Pattern.compile(regexForName);
        String regexForDistance = "[0-9]";
        Pattern patternForDistance = Pattern.compile(regexForDistance);
        Map<String, Integer> mapRacers = new LinkedHashMap<>();
        names.forEach(element -> mapRacers.put(element, 0));
        int totalDistance = 0;
        StringBuilder name = new StringBuilder();

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            Matcher matcherForName = patternForName.matcher(input);
            while (matcherForName.find()) {
                name.append(matcherForName.group());
            }
            Matcher matcherForDistance = patternForDistance.matcher(input);
            while (matcherForDistance.find()) {
                int distance = Integer.parseInt(matcherForDistance.group());
                totalDistance += distance;
            }
            String racer = name.toString();
            if (mapRacers.containsKey(racer)) {
                int currentValue = mapRacers.get(racer);
                mapRacers.put(racer, currentValue + totalDistance);
            }
            name.delete(0, name.length());
            totalDistance = 0;
            input = scanner.nextLine();
        }
        List<String> list = mapRacers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("1st place: " + list.get(0));
        System.out.println("2nd place: " + list.get(1));
        System.out.println("3rd place: " + list.get(2));


    }
}
