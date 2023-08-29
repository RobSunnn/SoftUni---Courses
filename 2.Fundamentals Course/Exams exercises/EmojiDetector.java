package fundamentals.exams;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regexForEmoji = "(?<sep>::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1";
        String regexNumbs = "[0-9]";
        long coolThreshold = 1L;
        Pattern patternEmoji = Pattern.compile(regexForEmoji);
        Pattern patternNumbs = Pattern.compile(regexNumbs);
        Matcher matcherEmoji = patternEmoji.matcher(text);
        Matcher matcherNumbs = patternNumbs.matcher(text);
        List<String> emojiList = new ArrayList<>();
        long countEmojis = 0L;

        while (matcherNumbs.find()) {
            int num = Integer.parseInt(matcherNumbs.group());
            coolThreshold *= num;
        }

        while (matcherEmoji.find()) {
            countEmojis++;
            String sep = matcherEmoji.group("sep");
            String emoji = matcherEmoji.group("emoji");
            long emojiCoolness = 0L;
            for (int i = 0; i < emoji.length(); i++) {
                emojiCoolness += emoji.charAt(i);
            }

            if (emojiCoolness > coolThreshold) {
                emojiList.add(String.format("%s%s%s", sep, emoji, sep));
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println(countEmojis + " emojis found in the text. The cool ones are:");
        for (String emoji : emojiList) {
            System.out.println(emoji);
        }

    }
}
