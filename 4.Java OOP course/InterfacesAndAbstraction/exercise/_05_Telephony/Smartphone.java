package InterfacesAndAbstraction.exercise._05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            boolean isDifferentFromDigit = false;
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isDifferentFromDigit = true;
                    break;
                }
            }
            if (!isDifferentFromDigit) {
                sb.append(String.format("Calling... %s%n", number));
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {
            boolean isDigitIn = false;
            for (int j = 0; j < url.length(); j++) {
                if (Character.isDigit(url.charAt(j))) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isDigitIn = true;
                    break;
                }
            }
            if (!isDigitIn) {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }
}
