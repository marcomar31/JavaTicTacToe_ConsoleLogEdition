package services;

public class Validator {
    public static boolean esInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException ex) {
            System.out.println("ERROR!!! El string no es un int");
            return false;
        }
        return true;
    }
}
