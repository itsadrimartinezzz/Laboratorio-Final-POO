import java.util.ArrayList;
import java.util.List;


public class ModoRadio {
    private String banda; // Representa la banda actual de la radio (FM o AM).
    private double frecuenciaActual; // Frecuencia actualmente sintonizada.
    private List<Double> emisorasGuardadas; // Lista de frecuencias guardadas.

    // Constructor: Inicializa la radio en banda FM, frecuencia mínima 88.0 y sin emisoras guardadas.
    public ModoRadio() {
        this.banda = "FM";
        this.frecuenciaActual = 88.0;
        this.emisorasGuardadas = new ArrayList<>();
    }

    // Cambia la banda entre FM y AM, y devuelve la banda seleccionada.
    public String cambiarBanda() {
        banda = banda.equals("FM") ? "AM" : "FM";
        return banda;
    }

    // Cambia la frecuencia actual sumando o restando el valor especificado.
    public double cambiarEmisora(double cambio) {
        frecuenciaActual += cambio;
        return frecuenciaActual;
    }

    // Guarda la frecuencia actual en la lista si hay espacio (máximo 50 emisoras).
    // Devuelve un mensaje indicando si la emisora fue guardada o no.
    public String guardarEmisora() {
        if (emisorasGuardadas.size() < 50) {
            emisorasGuardadas.add(frecuenciaActual);
            return "Emisora guardada: " + frecuenciaActual;
        }
        return "No se pueden guardar más emisoras.";
    }

    // Carga una emisora guardada por su posición en la lista.
    // Devuelve la frecuencia guardada o -1 si la posición no es válida.
    public double cargarEmisora(int posicion) {
        if (posicion < emisorasGuardadas.size()) {
            return emisorasGuardadas.get(posicion);
        }
        return -1; // Indica posición no válida.
    }
}
