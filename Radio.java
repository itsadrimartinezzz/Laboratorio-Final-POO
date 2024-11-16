import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que gestiona las funcionalidades generales del radio.
 */
public class Radio {
    private boolean isEncendido;
    private int volumen;
    private String modoActual;
    private String banda; // FM o AM.
    private double frecuenciaActual; // Frecuencia actual de la banda.
    private List<Double> emisorasFM; // Lista de emisoras guardadas en FM.
    private List<Double> emisorasAM; // Lista de emisoras guardadas en AM.

    public Radio() {
        this.isEncendido = false;
        this.volumen = 10;
        this.modoActual = "Radio";
        this.banda = "FM";
        this.frecuenciaActual = 1.0; // Frecuencia inicial para FM.
        this.emisorasFM = new ArrayList<>();
        this.emisorasAM = new ArrayList<>();
    }

    public void encender() {
        isEncendido = true;
    }

    public void apagar() {
        isEncendido = false;
    }

    public void cambiarVolumen(int cambio) {
        if (isEncendido) {
            volumen = Math.max(0, volumen + cambio);
        }
    }

    public void cambiarModo(String nuevoModo) {
        if (isEncendido) {
            this.modoActual = nuevoModo;
        }
    }

    public String cambiarBanda() {
        if ("Radio".equals(modoActual) && isEncendido) {
            if ("FM".equals(banda)) {
                banda = "AM";
                frecuenciaActual = 100.5; // Frecuencia inicial para AM.
            } else {
                banda = "FM";
                frecuenciaActual = 1.0; // Frecuencia inicial para FM.
            }
            return "Banda actual: " + banda;
        }
        return "El radio debe estar encendido y en modo Radio para cambiar de banda.";
    }

    public String cambiarEmisora(boolean siguiente) {
        if ("Radio".equals(modoActual) && isEncendido) {
            if ("FM".equals(banda)) {
                frecuenciaActual += (siguiente ? 0.5 : -0.5);
                if (frecuenciaActual > 100.0) {
                    frecuenciaActual = 100.0; // Límite superior para FM.
                } else if (frecuenciaActual < 1.0) {
                    frecuenciaActual = 1.0; // Límite inferior para FM.
                }
            } else if ("AM".equals(banda)) {
                frecuenciaActual += (siguiente ? 0.5 : -0.5);
                if (frecuenciaActual > 200.0) {
                    frecuenciaActual = 200.0; // Límite superior para AM.
                } else if (frecuenciaActual < 100.5) {
                    frecuenciaActual = 100.5; // Límite inferior para AM.
                }
            }
            return "Frecuencia actual: " + frecuenciaActual;
        }
        return "El radio debe estar encendido y en modo Radio para cambiar de emisora.";
    }

    public String guardarEmisora() {
        if ("Radio".equals(modoActual) && isEncendido) {
            if ("FM".equals(banda)) {
                if (!emisorasFM.contains(frecuenciaActual) && emisorasFM.size() < 50) {
                    emisorasFM.add(frecuenciaActual);
                    return "Emisora guardada en FM: " + frecuenciaActual;
                }
            } else if ("AM".equals(banda)) {
                if (!emisorasAM.contains(frecuenciaActual) && emisorasAM.size() < 50) {
                    emisorasAM.add(frecuenciaActual);
                    return "Emisora guardada en AM: " + frecuenciaActual;
                }
            }
            return "No se pueden guardar más emisoras o ya está guardada.";
        }
        return "El radio debe estar encendido y en modo Radio para guardar emisoras.";
    }

    public String cargarEmisoras() {
        if ("Radio".equals(modoActual) && isEncendido) {
            List<Double> emisoras = "FM".equals(banda) ? emisorasFM : emisorasAM;
            if (emisoras.isEmpty()) {
                return "No hay emisoras guardadas en " + banda + ".";
            }
            StringBuilder listado = new StringBuilder("Emisoras guardadas en " + banda + ":\n");
            for (int i = 0; i < emisoras.size(); i++) {
                listado.append(i + 1).append(". ").append(emisoras.get(i)).append("\n");
            }
            return listado.toString();
        }
        return "El radio debe estar encendido y en modo Radio para cargar emisoras.";
    }

    public String seleccionarEmisora(int indice) {
        if ("Radio".equals(modoActual) && isEncendido) {
            List<Double> emisoras = "FM".equals(banda) ? emisorasFM : emisorasAM;
            if (indice >= 1 && indice <= emisoras.size()) {
                frecuenciaActual = emisoras.get(indice - 1);
                return "Emisora seleccionada: " + frecuenciaActual;
            }
            return "Índice inválido.";
        }
        return "El radio debe estar encendido y en modo Radio para seleccionar una emisora.";
    }

    public String mostrarEstado() {
        if (!isEncendido) {
            return "El radio está apagado.";
        }
        String estado = "Estado del radio: Encendido, Volumen: " + volumen + ", Modo: " + modoActual;
        if ("Radio".equals(modoActual)) {
            estado += ", Banda: " + banda + ", Frecuencia: " + frecuenciaActual;
        }
        return estado;
    }
}
