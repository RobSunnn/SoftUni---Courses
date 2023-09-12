package Inheritance.lab._04_StackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings sos = new StackOfStrings();
        sos.push("Robi");
        sos.push("Spasov");
        sos.push("32");
        System.out.println(!sos.isEmpty());
        System.out.println(sos.peek());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
