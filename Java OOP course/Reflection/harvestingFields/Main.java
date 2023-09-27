package Reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Class<RichSoilLand> richSoilLand = RichSoilLand.class;
        Field[] declaredFields = richSoilLand.getDeclaredFields();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("HARVEST")) {

            switch (command) {

                case "private":
                    for (Field field : declaredFields) {
                        int modifiers = field.getModifiers();
                        String sub = field.toString().substring(0, field.toString().indexOf(" "));
                        if (Modifier.isPrivate(modifiers)) {
                            System.out.printf("%s %s %s%n", sub,
                                    field.getType().getSimpleName(), field.getName());
                        }
                    }

                    break;
                case "protected":
                    for (Field field : declaredFields) {
                        int modifiers = field.getModifiers();
                        String sub = field.toString().substring(0, field.toString().indexOf(" "));
                        if (Modifier.isProtected(modifiers)) {
                            System.out.printf("%s %s %s%n", sub,
                                    field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "public":
                    for (Field field : declaredFields) {
                        int modifiers = field.getModifiers();
                        String sub = field.toString().substring(0, field.toString().indexOf(" "));
                        if (Modifier.isPublic(modifiers)) {
                            System.out.printf("%s %s %s%n", sub,
                                    field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "all":
                    for (Field field : declaredFields) {
                        String sub = field.toString().substring(0, field.toString().indexOf(" "));
                        System.out.printf("%s %s %s%n", sub,
                                field.getType().getSimpleName(), field.getName());

                    }
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
