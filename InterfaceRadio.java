/** 
 * Universidad del Valle de Guatemala - Segundo Semestre 2024
 * Programación Orientada a Objetos (POO)
 * Laboratorio 4 
 * 
 * InterfaceRadio
 * 
 * Esta interfaz define las funcionalidades básicas que debe implementar cualquier radio,
 * incluyendo encendido, apagado, ajuste de volumen y visualización del estado.
 * 
 * @autor Marjori Flores
 * Fecha de creación: 15/11/2024 
 * Última modificación: 15/11/2024 
 */

/**
 * Interfaz general para definir funcionalidades básicas de cualquier radio.
 */
public interface InterfaceRadio {

    /**
     * Enciende la radio.
     */
    void encender();

    /**
     * Apaga la radio.
     */
    void apagar();

    /**
     * Cambia el volumen de la radio.
     * @param cambio Valor que representa el cambio en el volumen (positivo o negativo).
     */
    void cambiarVolumen(int cambio);

    /**
     * Muestra el estado actual de la radio (encendida, apagada, volumen, etc.).
     * @return Una cadena que describe el estado actual de la radio.
     */
    String mostrarEstado();
}
