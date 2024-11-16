/*=================================================
Programación Orientada a Objetos
Adriana Martínez Fuentes
Carnet: 24086
=================================================*/

import java.util.Scanner;


public class Main {
    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m"; // Restablece el color al predeterminado.
    public static final String BLACK = "\u001B[30m"; // Color negro.
    public static final String RED = "\u001B[31m"; // Color rojo.
    public static final String GREEN = "\u001B[32m"; // Color verde.
    public static final String YELLOW = "\u001B[33m"; // Color amarillo.
    public static final String BLUE = "\u001B[34m"; // Color azul.
    public static final String PURPLE = "\u001B[35m"; // Color morado.
    public static final String CYAN = "\u001B[36m"; // Color cian.
    public static final String WHITE = "\u001B[37m"; // Color blanco.

    public static void main(String[] args) {
        Radio radio = new Radio(); // Instancia del objeto Radio.
        Scanner scanner = new Scanner(System.in); // Objeto para capturar entradas del usuario.
        boolean continuar = true; // Controla el ciclo del programa.

        // Ciclo principal para el menú interactivo.
        while (continuar) {
            // Imprime el encabezado del menú.
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

            // Solicita una opción del usuario.
            System.out.print(BLUE + "Seleccione una opción: " + RESET);
            int opcion = scanner.nextInt();

            // Ejecuta la acción correspondiente a la opción seleccionada.
            switch (opcion) {
                case 1 -> {
                    radio.encender(); // Llama al método para encender el radio.
                    System.out.println(GREEN + "El radio está encendido." + RESET);
                }
                case 2 -> {
                    radio.apagar(); // Llama al método para apagar el radio.
                    System.out.println(RED + "El radio está apagado." + RESET);
                }
                case 3 -> {
                    // Solicita el ajuste de volumen (+1 o -1).
                    System.out.print(PURPLE + "Ingrese cambio de volumen (+1 / -1): " + RESET);
                    int cambio = scanner.nextInt();
                    radio.cambiarVolumen(cambio); // Ajusta el volumen.
                    System.out.println(GREEN + "Volumen ajustado." + RESET);
                }
                case 4 -> {
                    // Solicita el nuevo modo del radio.
                    System.out.print(PURPLE + "Ingrese el modo (Radio, Reproducción, Teléfono): " + RESET);
                    String nuevoModo = scanner.next();
                    radio.cambiarModo(nuevoModo); // Cambia el modo del radio.
                    System.out.println(GREEN + "Modo cambiado a " + nuevoModo + "." + RESET);
                }
                case 5 -> System.out.println(YELLOW + radio.cambiarBanda() + RESET); // Cambia la banda (FM/AM).
                case 6 -> {
                    // Solicita si el usuario quiere la siguiente o la anterior emisora.
                    System.out.print(PURPLE + "¿Siguiente (1) o Anterior (0)?: " + RESET);
                    boolean siguiente = scanner.nextInt() == 1;
                    System.out.println(YELLOW + radio.cambiarEmisora(siguiente) + RESET);
                }
                case 7 -> System.out.println(GREEN + radio.guardarEmisora() + RESET); // Guarda la emisora actual.
                case 8 -> System.out.println(CYAN + radio.cargarEmisoras() + RESET); // Muestra las emisoras guardadas.
                case 9 -> {
                    // Solicita el índice de la emisora a cargar.
                    System.out.print(PURPLE + "Seleccione el índice de la emisora: " + RESET);
                    int indice = scanner.nextInt();
                    System.out.println(GREEN + radio.seleccionarEmisora(indice) + RESET); // Carga la emisora.
                }
                case 10 -> {
                    continuar = false; // Sale del programa.
                    System.out.println(RED + "Adiós." + RESET);
                }
                default -> System.out.println(RED + "Opción no válida." + RESET); // Manejo de entrada inválida.
            }
        }
        scanner.close(); // Cierra el objeto Scanner al finalizar.
    }
}
