package controllers;

import services.Input;
import views.GameView;
import views.MainMenuView;

public class TicTacToeGame {
    private static final GameView gameView = new GameView();
    public static void main(String[] args) {
        int opcion;

        do {
            opcion = MainMenuView.pideOpcionMenu();

            switch (opcion) {
                case 1 -> gameView.iniciaPartida();
                case 0 -> System.out.println("Saliendo del juego...");
            }
        } while (opcion != 0);
        Input.cerrarScanner();
    }
}