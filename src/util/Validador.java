package util;

public class Validador {

    public static boolean validarCorreo(String correo) {
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean validarTelefono(String telefono) {

        for (int i = 0; i < telefono.length(); i++) {

            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean validarTexto(String texto) {
        return !texto.trim().isEmpty();
    }

    public static boolean validarEdad(int edad) {
        return edad > 0 && edad < 150;
    }
}