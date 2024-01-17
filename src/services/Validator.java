package services;

public class Validator {
    public static boolean esInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
