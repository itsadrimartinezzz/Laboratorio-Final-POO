import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el modo Reproducción.
 */
public class ModoReproduccion {
    private List<String> listaReproduccion;
    private int cancionActual;

    public ModoReproduccion() {
        this.listaReproduccion = new ArrayList<>();
        this.cancionActual = 0;
        listaReproduccion.add("Canción 1 - Autor 1 - 3:45 - Rock");
        listaReproduccion.add("Canción 2 - Autor 2 - 4:12 - Pop");
    }

    public String seleccionarLista(String nombreLista) {
        return "Lista seleccionada: " + nombreLista;
    }

    public String cambiarCancion(boolean adelante) {
        if (adelante) {
            cancionActual = (cancionActual + 1) % listaReproduccion.size();
        } else {
            cancionActual = (cancionActual - 1 + listaReproduccion.size()) % listaReproduccion.size();
        }
        return listaReproduccion.get(cancionActual);
    }

    public String escucharCancion() {
        return listaReproduccion.get(cancionActual);
    }
}
