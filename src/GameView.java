import services.Input;

import java.util.Arrays;

public class GameView {
    private static String[][] tablero;
    private static int jugador = 1;
    public static void iniciaPartida() {
        System.out.println("\nIniciando partida...");
        creaTablero();
        siguePartida();
    }

    private static void siguePartida() {
        do {
            muestraTablero();
            editaTablero(jugador);

            if (jugador == 1) jugador = 2;
            else if (jugador == 2) jugador = 1;
        } while (true);

    }

    public static void muestraTablero() {
        System.out.println(" -------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | ");
                System.out.print(tablero[i][j]);
            }
            System.out.println(" |");
            System.out.println(" -------------");
        }
    }

    private static void creaTablero() {
        tablero = new String[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(tablero[i], " ");
        }
    }

    private static void editaTablero(int jugador) {
        String tachado = null;
        int i = 0, j = 0;
        switch (jugador) {
            case 1 -> tachado = "O";
            case 2 -> tachado = "X";
        }

        boolean casillaLibre;
        int casilla;
        do {
            casilla = Input.pideInt("Seleccione una casilla del tablero: ");
            switch (casilla) {
                case 1 -> {
                    i = 2;
                    j = 0;
                }
                case 2 -> {
                    i = 2;
                    j = 1;
                }
                case 3 -> {
                    i = 2;
                    j = 2;
                }
                case 4 -> {
                    i = 1;
                    j = 0;
                }
                case 5 -> {
                    i = 1;
                    j = 1;
                }
                case 6 -> {
                    i = 1;
                    j = 2;
                }
                case 7 -> {
                    i = 0;
                    j = 0;
                }
                case 8 -> {
                    i = 0;
                    j = 1;
                }
                case 9 -> {
                    i = 0;
                    j = 2;
                }
            }
            casillaLibre = tablero[i][j].equals(" ");
            if (!casillaLibre) {
                System.out.println("La casilla seleccionada está ocupada!!! Selecciona otra casilla.");
            }
        } while (!casillaLibre);

        tablero[i][j] = tachado;
    }
}
