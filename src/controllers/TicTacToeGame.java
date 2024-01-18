package controllers;

import services.Input;
import views.MainMenuView;

public class TicTacToeGame {
    public static void main(String[] args) {
        MainMenuView.gestionaOpcionMenu();
        Input.cerrarScanner();
    }
}