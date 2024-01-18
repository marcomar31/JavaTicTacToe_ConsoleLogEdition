package views;

import services.Input;

public class MainMenuView {
    public static boolean partidaJugada = false;
    public static int pideOpcionMenu() {
        int opcion;
        do {
            System.out.println("\n---- MENÚ PRINCIPAL ---");
            if (!partidaJugada) {
                System.out.println("1. Jugar una partida");
            } else {
                System.out.println("1. Jugar otra partida");
            }
            System.out.println("2. Ver instrucciones");
            System.out.println("0. Salir del juego");

            opcion = Input.pideInt("Seleccione una opción: ");
            if (!opcionValida(opcion)) {
                System.out.println("Por favor, seleccione una opción válida (0 - 1)");
            }
        } while (!opcionValida(opcion));

        return opcion;
    }

    private static boolean opcionValida(int opcion) {
        return (opcion >= 0 && opcion <= 2);
    }
}
