package ec.edu.uce.dominio;

/**
 * La clase TicketCarga contiene información sobre tarifas especiales y tarifas por hora de carga.
 * Esta clase es usada para representar tickets de carga en el sistema de parqueo.
 */
public class TicketCarga {

    private double tarifaEspecial;
    private float tarifaHoraCarga;

    /**
     * Constructor vacío que inicializa la tarifa especial en 0 y la tarifa por hora de carga en 1.5.
     */
    public TicketCarga() {
        this.tarifaEspecial = 0;
        this.tarifaHoraCarga = 1.5f;  // Tarifa por hora de carga predeterminada
    }

    /**
     * Constructor con parámetros para inicializar las tarifas del ticket de carga.
     *
     * @param tarifaEspecial La tarifa especial a aplicar en el ticket de carga.
     * @param tarifaHoraCarga La tarifa por hora de carga a aplicar.
     */
    public TicketCarga(double tarifaEspecial, float tarifaHoraCarga) {
        this.tarifaEspecial = tarifaEspecial;
        this.tarifaHoraCarga = tarifaHoraCarga;
    }

    // Getters y Setters
    public double getTarifaEspecial() {
        return tarifaEspecial;
    }

    public float getTarifaHoraCarga() {
        return tarifaHoraCarga;
    }

    /**
     * Establece la tarifa especial aplicada al ticket de carga.
     * La tarifa especial no puede ser menor que la tarifa por hora de carga.
     *
     * @param tarifaEspecial La tarifa especial a aplicar.
     */
    public void setTarifaEspecial(double tarifaEspecial) {
        if (tarifaEspecial < tarifaHoraCarga) {
            System.out.println("Error: La tarifa especial no puede ser menor que la tarifa por hora.");
            return;
        }
        this.tarifaEspecial = tarifaEspecial;
    }

    /**
     * Establece la tarifa por hora de carga aplicada al ticket de carga.
     * La tarifa debe ser positiva.
     *
     * @param tarifaHoraCarga La tarifa por hora de carga a aplicar.
     */
    public void setTarifaHoraCarga(float tarifaHoraCarga) {
        if (tarifaHoraCarga > 0) {
            this.tarifaHoraCarga = tarifaHoraCarga;
        } else {
            System.out.println("Error: La tarifa por hora de carga debe ser mayor que 0.");
        }
    }

    /**
     */
    public void aplicarTarifaEspecial() {
        // Ejemplo: Si el vehículo es de carga pesada, aplicar un descuento especial
        if (this.tarifaEspecial > 0) {
            System.out.println("Aplicando tarifa especial: " + tarifaEspecial);
        } else {
            System.out.println("No se aplica tarifa especial.");
        }
    }

    /**
     * Genera un detalle completo del ticket de carga, incluyendo
     * la tarifa especial y la tarifa por hora de carga.
     *
     * @return Una cadena con los detalles del ticket de carga.
     */
    @Override
    public String toString() {
        return "Ticket Carga: \n" +
                "\n Tarifa especial: " + tarifaEspecial +
                "\n Tarifa por Hora Carga: " + tarifaHoraCarga;
    }

    // Métodos CRUD (Crear y Consultar)

    /**
     * Crea un nuevo ticket de carga en el sistema.
     * Este método ahora solo maneja la tarifa del ticket y la aplicación de tarifa especial, sin necesidad de asociar vehículo o espacio.
     */
    public void crearTicketCarga() {
        // Se asume que el ticket de carga se crea directamente con las tarifas proporcionadas
        System.out.println("Ticket de carga creado con tarifa por hora: " + tarifaHoraCarga);
        aplicarTarifaEspecial();  // Aplicar la tarifa especial si es necesario
    }

    /**
     * Consulta un ticket de carga en el sistema por su matrícula.
     * (Este método se podría modificar para consultas en el sistema si es necesario)
     *
     * @return El detalle del ticket de carga.
     */
    public String consultarTicketCarga() {
        return toString();  // Simplemente devuelve el detalle del ticket de carga.
    }
}