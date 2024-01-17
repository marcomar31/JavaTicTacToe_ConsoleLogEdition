package services;

import java.util.Scanner;

import static services.Validator.esInt;

public class Input {
    private static Scanner sc;
    public static int pideInt(String pregunta) {
        sc = new Scanner(System.in);
        String input;

        do {
            System.out.print(pregunta);
            input = sc.next();
            if (!esInt(input)) {
                System.out.println("Por favor, introduzca un número entero.");
            }
        } while (!esInt(input));

        return Integer.parseInt(input);
    }
}
