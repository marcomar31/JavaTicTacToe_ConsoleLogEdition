package services;

import java.util.Scanner;

import static services.Validator.esInt;

public class Input {
    private static final Scanner sc = new Scanner(System.in);
    public static int pideInt(String pregunta) {
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

    public static void cerrarScanner() {
        sc.close();
    }
}
