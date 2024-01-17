public class Main {
    public static void main(String[] args) {
        int opcion = MainMenu.pideOpcionMenu();

        switch (opcion) {
            case 0 -> System.out.println("Saliendo del juego...");
            case 1 -> GameView.iniciaPartida();
        }
    }
}