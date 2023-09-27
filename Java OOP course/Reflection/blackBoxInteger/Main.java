package Reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] inputData = input.split("_");
            String command = inputData[0];
            int argument = Integer.parseInt(inputData[1]);

            for (Method method : declaredMethods) {
                if (method.getName().equals(command)) {
                    method.setAccessible(true);
                    method.invoke(blackBoxInt, argument);
                    System.out.println(field.getInt(blackBoxInt));
                    break;
                }
            }

            input = scanner.nextLine();
        }

    }
}
