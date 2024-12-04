package ec.edu.uce.dominio;

/**
 * La clase
 * Contiene información sobre la matrícula del vehículo y su tipo.
 */
public class Vehiculo {


    private String numeroMatricula;
    private String tipoVehiculo;

    /**
     * Constructor vacío que inicializa el número de matrícula con "ABC123"
     * y el tipo de vehículo con "sin".
     */
    public Vehiculo() {
        this.numeroMatricula = null;
        this.tipoVehiculo = null;
    }

    /**
     * Constructor con parámetros para inicializar el vehículo con la matrícula
     * y el tipo de vehículo especificados.
     *
     * @param numeroMatricula El número de matrícula del vehículo.
     * @param tipoVehiculo El tipo de vehículo.
     */
    public Vehiculo(String numeroMatricula, String tipoVehiculo) {
        this.numeroMatricula = numeroMatricula;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Obtiene el número de matrícula del vehículo.
     *
     * @return El número de matrícula del vehículo.
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    /**
     * Establece el número de matrícula del vehículo. Si la matrícula está vacía
     * o es nula, se imprime un mensaje de error.
     *
     * @param numeroMatricula El número de matrícula a establecer.
     */
    public void setNumeroMatricula(String numeroMatricula) {
        if (numeroMatricula == null || numeroMatricula.trim().isEmpty()) {
            System.out.println("Error: La matrícula no puede estar vacía.");
        } else {
            this.numeroMatricula = numeroMatricula;
        }
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return El tipo de vehículo.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Establece el tipo de vehículo. Si el tipo está vacío o es nulo,
     * se imprime un mensaje de error.
     *
     * @param tipoVehiculo El tipo de vehículo a establecer.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        if (tipoVehiculo == null || tipoVehiculo.trim().isEmpty()) {
            System.out.println("Error: El tipo de vehículo no puede estar vacío.");
        } else {
            this.tipoVehiculo = tipoVehiculo;
        }
    }

    /**
     *Crud
     */
    public void estacionar() {

    }

    /**
     * Obtiene una cadena con los detalles del vehículo, incluyendo su número
     * de matrícula y tipo de vehículo.
     *
     * @return Una cadena con los detalles del vehículo.
     */
    public String toString() {
        return "Clase Vehiculo: " +
                "\n Numero de matricula: " + numeroMatricula +
                "\n Tipo Vehiculo: " + tipoVehiculo;
    }
}