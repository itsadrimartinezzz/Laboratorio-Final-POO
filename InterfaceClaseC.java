/**
 * Universidad del Valle de Guatemala - Segundo Semestre 2024
 * Programación Orientada a Objetos (POO)
 * Laboratorio Final
 * 
 * Interface InterfaceClaseC
 * 
 * La interface InterfaceClaseC extiende las funcionalidades básicas de la interfaz 
 * InterfaceRadio, añadiendo un método para cambiar el modo de operación del radio.
 * 
 * @author Adriana Martínez
 * Fecha de creación: 14/11/2024
 * Última modificación: 15/11/2024
 */

public interface InterfaceClaseC extends InterfaceRadio {
    /**
     * Cambia el modo actual del radio a uno nuevo.
     * 
     * @param nuevoModo El nuevo modo que se desea establecer (Radio, Reproducción, Teléfono, etc.).
     */
    void cambiarModo(String nuevoModo);
}
