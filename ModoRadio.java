import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el modo Radio.
 */
public class ModoRadio {
    private String banda;
    private double frecuenciaActual;
    private List<Double> emisorasGuardadas;

    public ModoRadio() {
        this.banda = "FM";
        this.frecuenciaActual = 88.0;
        this.emisorasGuardadas = new ArrayList<>();
    }

    public String cambiarBanda() {
        banda = banda.equals("FM") ? "AM" : "FM";
        return banda;
    }

    public double cambiarEmisora(double cambio) {
        frecuenciaActual += cambio;
        return frecuenciaActual;
    }

    public String guardarEmisora() {
        if (emisorasGuardadas.size() < 50) {
            emisorasGuardadas.add(frecuenciaActual);
            return "Emisora guardada: " + frecuenciaActual;
        }
        return "No se pueden guardar más emisoras.";
    }

    public double cargarEmisora(int posicion) {
        if (posicion < emisorasGuardadas.size()) {
            return emisorasGuardadas.get(posicion);
        }
        return -1; // Indica posición no válida.
    }
}
