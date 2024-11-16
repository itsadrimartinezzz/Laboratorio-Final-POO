/** 
 * Universidad del Valle de Guatemala - Segundo Semestre 2024
 * Programación Orientada a Objetos (POO)
 * Laboratorio 4 
 * 
 * ModoReproduccion
 * 
 * Esta clase simula un modo de reproducción de música, permitiendo gestionar 
 * listas de reproducción y cambiar canciones.
 * 
 * @autor Marjori Flores
 * Fecha de creación: 15/11/2024 
 * Última modificación: 15/11/2024 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un modo de Reproducción de música, con funcionalidades para 
 * seleccionar listas, cambiar canciones y reproducir la canción actual.
 */
public class ModoReproduccion {
    private List<String> listaReproduccion; // Almacena la lista de canciones
    private int cancionActual; // Índice de la canción que se está reproduciendo actualmente

    /**
     * Constructor que inicializa la lista de reproducción con canciones predeterminadas
     * y establece el índice de la canción actual en 0.
     */
    public ModoReproduccion() {
        this.listaReproduccion = new ArrayList<>();
        this.cancionActual = 0;
        listaReproduccion.add("Canción 1 - Autor 1 - 3:45 - Rock");
        listaReproduccion.add("Canción 2 - Autor 2 - 4:12 - Pop");
    }
     /**
     * Selecciona una lista de reproducción.
     * @param nombreLista Nombre de la lista a seleccionar.
     * @return Mensaje indicando la lista seleccionada.
     */
    public String seleccionarLista(String nombreLista) {
        return "Lista seleccionada: " + nombreLista;
    }

    /**
     * Cambia la canción actual. Avanza o retrocede según el parámetro recibido.
     * @param adelante Si es true, avanza a la siguiente canción; si es false, retrocede a la anterior.
     * @return La canción que está reproduciéndose después del cambio.
     */
    public String cambiarCancion(boolean adelante) {
        if (adelante) {
            cancionActual = (cancionActual + 1) % listaReproduccion.size(); // Avanza circularmente
        } else {
            cancionActual = (cancionActual - 1 + listaReproduccion.size()) % listaReproduccion.size(); // Retrocede circularmente
        }
        return listaReproduccion.get(cancionActual);
    }
    /**
     * Reproduce la canción actual de la lista de reproducción.
     * @return La canción actual que se está escuchando.
     */
    public String escucharCancion() {
        return listaReproduccion.get(cancionActual);
    }
}


