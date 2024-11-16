/**
 * Universidad del Valle de Guatemala - Segundo Semestre 2024
 * Programación Orientada a Objetos (POO)
 * Proyecto Final
 * 
 * Clase Radio
 * 
 * La clase Radio gestiona las funcionalidades generales de un radio,
 * incluyendo encendido/apagado, ajuste de volumen, cambio de modos 
 * (Radio, Reproducción, Teléfono), gestión de bandas (FM/AM),
 * manipulación de frecuencias y almacenamiento de emisoras.
 * 
 * @author Adriana Martínez
 * Fecha de creación: 14/11/2024
 * Última modificación: 15/11/2024
 */

import java.util.ArrayList;
import java.util.List;


public class Radio {
    private boolean isEncendido; // Indica si el radio está encendido o apagado.
    private int volumen; // Nivel actual de volumen.
    private String modoActual; // Modo actual del radio (Radio, Reproducción, Teléfono).
    private String banda; // Banda actual (FM o AM).
    private double frecuenciaActual; // Frecuencia actual de la banda seleccionada.
    private List<Double> emisorasFM; // Lista de emisoras guardadas en FM.
    private List<Double> emisorasAM; // Lista de emisoras guardadas en AM.

    /**
     * Constructor de la clase Radio.
     * Inicializa el estado apagado, volumen en 10, modo en "Radio", banda en "FM",
     * frecuencia inicial para FM y listas vacías para emisoras.
     */
    public Radio() {
        this.isEncendido = false;
        this.volumen = 10;
        this.modoActual = "Radio";
        this.banda = "FM";
        this.frecuenciaActual = 1.0;
        this.emisorasFM = new ArrayList<>();
        this.emisorasAM = new ArrayList<>();
    }

    /**
     * Enciende el radio.
     */
    public void encender() {
        isEncendido = true;
    }

    /**
     * Apaga el radio.
     */
    public void apagar() {
        isEncendido = false;
    }

    /**
     * Cambia el volumen del radio.
     * 
     * @param cambio Incremento o decremento en el volumen.
     */
    public void cambiarVolumen(int cambio) {
        if (isEncendido) {
            volumen = Math.max(0, volumen + cambio);
        }
    }

    /**
     * Cambia el modo actual del radio.
     * 
     * @param nuevoModo Nuevo modo a establecer.
     */
    public void cambiarModo(String nuevoModo) {
        if (isEncendido) {
            this.modoActual = nuevoModo;
        }
    }

    /**
     * Cambia la banda actual (FM/AM) si el modo es "Radio" y el radio está encendido.
     * 
     * @return Mensaje indicando la banda actual o una advertencia si no es posible.
     */
    public String cambiarBanda() {
        if ("Radio".equals(modoActual) && isEncendido) {
            if ("FM".equals(banda)) {
                banda = "AM";
                frecuenciaActual = 100.5;
            } else {
                banda = "FM";
                frecuenciaActual = 1.0;
            }
            return "Banda actual: " + banda;
        }
        return "El radio debe estar encendido y en modo Radio para cambiar de banda.";
    }

    /**
     * Cambia la frecuencia actual en función de la banda seleccionada.
     * 
     * @param siguiente Indica si se avanza o retrocede en la frecuencia.
     * @return Mensaje con la frecuencia actual o una advertencia si no es posible.
     */
    public String cambiarEmisora(boolean siguiente) {
        if ("Radio".equals(modoActual) && isEncendido) {
            if ("FM".equals(banda)) {
                frecuenciaActual += (siguiente ? 0.5 : -0.5);
                frecuenciaActual = Math.min(100.0, Math.max(1.0, frecuenciaActual));
            } else if ("AM".equals(banda)) {
                frecuenciaActual += (siguiente ? 0.5 : -0.5);
                frecuenciaActual = Math.min(200.0, Math.max(100.5, frecuenciaActual));
            }
            return "Frecuencia actual: " + frecuenciaActual;
        }
        return "El radio debe estar encendido y en modo Radio para cambiar de emisora.";
    }

    /**
     * Guarda la frecuencia actual en la lista correspondiente a la banda.
     * 
     * @return Mensaje indicando si la emisora fue guardada o no.
     */
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

    /**
     * Carga y lista las emisoras guardadas en la banda actual.
     * 
     * @return Listado de emisoras guardadas o un mensaje si no hay emisoras.
     */
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

    /**
     * Selecciona una emisora guardada en función de su índice.
     * 
     * @param indice Índice de la emisora en la lista.
     * @return Mensaje con la emisora seleccionada o una advertencia si no es válido.
     */
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

    /**
     * Muestra el estado actual del radio, incluyendo modo, banda, volumen y frecuencia.
     * 
     * @return Mensaje con el estado del radio.
     */
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
