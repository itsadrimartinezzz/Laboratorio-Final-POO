/*=================================================
Programación Orientada a Objetos
Adriana Martínez Fuentes // Marjori Flores
Carnet: 24086 // 24754
=================================================*/

import java.util.Scanner;

public class Main {
    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Radio radio = new Radio();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println(CYAN + "==================== RADIO PANEL ====================" + RESET);
            System.out.println(YELLOW + radio.mostrarEstado() + RESET);
            System.out.println(CYAN + """
                -------------------------------------------------
                Opciones:
                1. Encender
                2. Apagar
                3. Cambiar volumen (+1 / -1)
                4. Cambiar modo (Radio, Reproducción, Teléfono)
                5. Cambiar banda (FM/AM)
                6. Cambiar emisora (Siguiente / Anterior)
                7. Guardar emisora
                8. Ver emisoras guardadas
                9. Seleccionar emisora
                10. Salir
                -------------------------------------------------
            """ + RESET);
            System.out.print(BLUE + "Seleccione una opción: " + RESET);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    radio.encender();
                    System.out.println(GREEN + "El radio está encendido." + RESET);
                }
                case 2 -> {
                    radio.apagar();
                    System.out.println(RED + "El radio está apagado." + RESET);
                }
                case 3 -> {
                    System.out.print(PURPLE + "Ingrese cambio de volumen (+1 / -1): " + RESET);
                    int cambio = scanner.nextInt();
                    radio.cambiarVolumen(cambio);
                    System.out.println(GREEN + "Volumen ajustado." + RESET);
                }
                case 4 -> {
                    System.out.print(PURPLE + "Ingrese el modo (Radio, Reproducción, Teléfono): " + RESET);
                    String nuevoModo = scanner.next();
                    radio.cambiarModo(nuevoModo);
                    System.out.println(GREEN + "Modo cambiado a " + nuevoModo + "." + RESET);
                }
                case 5 -> System.out.println(YELLOW + radio.cambiarBanda() + RESET);
                case 6 -> {
                    System.out.print(PURPLE + "¿Siguiente (1) o Anterior (0)?: " + RESET);
                    boolean siguiente = scanner.nextInt() == 1;
                    System.out.println(YELLOW + radio.cambiarEmisora(siguiente) + RESET);
                }
                case 7 -> System.out.println(GREEN + radio.guardarEmisora() + RESET);
                case 8 -> System.out.println(CYAN + radio.cargarEmisoras() + RESET);
                case 9 -> {
                    System.out.print(PURPLE + "Seleccione el índice de la emisora: " + RESET);
                    int indice = scanner.nextInt();
                    System.out.println(GREEN + radio.seleccionarEmisora(indice) + RESET);
                }
                case 10 -> {
                    continuar = false;
                    System.out.println(RED + "Adiós." + RESET);
                }
                default -> System.out.println(RED + "Opción no válida." + RESET);
            }
        }
        scanner.close();
    }
}
