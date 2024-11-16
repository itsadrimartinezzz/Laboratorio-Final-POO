/** 
 * Universidad del Valle de Guatemala - Segundo Semestre 2024
 * Programación Orientada a Objetos (POO)
 * Laboratorio 4 
 * 
 * ModoTelefono
 * 
 * Esta clase simula las funcionalidades básicas de un modo teléfono, incluyendo la gestión de contactos 
 * y llamadas.
 * 
 * @author Marjori Flores
 * Fecha de creación: 15/11/2024 
 * Última modificación: 15/11/2024 
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un modo Teléfono con funcionalidades básicas de conexión, 
 * gestión de contactos y llamadas.
 */
public class ModoTelefono {
    private List<String> contactos;
    private boolean llamadaEnCurso;

    /**
     * Constructor que inicializa la lista de contactos y establece que no hay 
     * llamada en curso.
     */
    public ModoTelefono() {
        this.contactos = new ArrayList<>();
        contactos.add("Juan Perez");
        contactos.add("Maria Lopez");
        this.llamadaEnCurso = false;
    }
     /**
     * Conecta el teléfono.
     * @return Mensaje indicando que el teléfono está conectado.
     */
    public String conectarTelefono() {
        return "Teléfono conectado.";
    }

    /**
     * Desconecta el teléfono.
     * @return Mensaje indicando que el teléfono está desconectado.
     */
    public String desconectarTelefono() {
        return "Teléfono desconectado.";
    }

    /**
     * Muestra la lista de contactos disponibles.
     * @return Cadena con los contactos almacenados.
     */
    public String mostrarContactos() {
        return "Contactos: " + contactos;
    }

     /**
     * Realiza una llamada a un contacto si está en la lista.
     * @param nombre Nombre del contacto al que se quiere llamar.
     * @return Mensaje indicando si la llamada se realizó o si no se encontró el contacto.
     */
    public String llamarContacto(String nombre) {
        if (contactos.contains(nombre)) {
            llamadaEnCurso = true; // Inicia la llamada
            return "Llamando a: " + nombre;
        }
        return "Contacto no encontrado.";
    }

    /**
     * Finaliza la llamada en curso.
     * @return Mensaje indicando que la llamada ha terminado.
     */
    public String finalizarLlamada() {
        llamadaEnCurso = false; // Termina la llamada
        return "Llamada finalizada.";
    }
}
