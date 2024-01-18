package views;

import services.Input;

import java.util.Arrays;
import java.util.Scanner;

public class GameView {
    private String[][] tablero;
    private int jugador = 0;
    public void iniciaPartida() {
        System.out.println("\nIniciando partida...");
        creaTablero();
        siguePartida();
    }

    private void siguePartida() {
        boolean hayGanador;
        boolean tableroLleno;

        do {
            muestraTablero();
            editaTablero(jugador);

            hayGanador = verificaGanador();
            tableroLleno = tableroLleno();

            if (!hayGanador && !tableroLleno) {
                cambiaTurno();
            }

        } while (!hayGanador && !tableroLleno);

        muestraTablero();
        terminaPartida();
    }

    public void muestraTablero() {
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

    private void creaTablero() {
        tablero = new String[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(tablero[i], " ");
        }
    }

    private void editaTablero(int jugador) {
        String[] simbolos = {"O", "X"};
        String tachado = simbolos[jugador];

        int i = 0, j = 0;

        boolean casillaLibre;
        int casilla;
        do {
            System.out.println("Turno de Jugador " + (jugador+1));
            casilla = Input.pideInt("Seleccione una casilla del tablero: ");
            switch (casilla) {
                case 1, 2, 3 -> i = 2;
                case 4, 5, 6 -> i = 1;
                case 7, 8, 9 -> i = 0;
            }

            switch (casilla) {
                case 1, 4, 7 -> j = 0;
                case 2, 5, 8 -> j = 1;
                case 3, 6, 9 -> j = 2;
            }

            casillaLibre = tablero[i][j].equals(" ");
            if (!casillaLibre) {
                System.out.println("La casilla seleccionada está ocupada!!! Selecciona otra casilla.");
            }
        } while (!casillaLibre);

        tablero[i][j] = tachado;
    }

    private void cambiaTurno() {
        if (jugador == 0) {
            jugador = 1;
        } else {
            jugador = 0;
        }
    }

    private boolean verificaGanador() {
        // Verify rows and columns
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]) && !tablero[i][0].equals(" ") ||
                    tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i]) && !tablero[0][i].equals(" ")) {
                System.out.println("\n¡Jugador " + (jugador+1) + " ha ganado!");
                return true;
            }
        }

        // Verify diagonals
        if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]) && !tablero[0][0].equals(" ") ||
                tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]) && !tablero[0][2].equals(" ")) {
            System.out.println("\n¡Jugador " + (jugador+1) + " ha ganado!");
            return true;
        }

        return false;
    }

    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        System.out.println("\n¡La partida ha terminado en empate!");
        return true;
    }

    private void terminaPartida() {
        MainMenuView.partidaJugada = true;
        System.out.println("\nLa partida ha finalizado! Pulsa cualquier tecla para volver al menú.");

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

}
