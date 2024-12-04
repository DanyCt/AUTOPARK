package ec.edu.uce.dominio;

/**
 * La clase representa un espacio de aparcamiento
 * Cada espacio tiene un número de identificación y un estado que indica si está ocupado o libre.
 */
public class EspacioAparcamiento {

    private String numeroEspacio;
    private Boolean estado;

    /**
     * Constructor vacío que inicializa el número de espacio como null y el estado como {@code false} (libre).
     */
    public EspacioAparcamiento() {
        this.numeroEspacio = null;
        this.estado = false;
    }

    /**
     * Constructor con parámetros para inicializar el número de espacio y el estado del mismo.
     *
     * @param numeroEspacio El número de espacio a asignar.
     * @param estado El estado del espacio, donde {@code true} es ocupado y {@code false} es libre.
     */
    public EspacioAparcamiento(String numeroEspacio, Boolean estado) {
        this.numeroEspacio = numeroEspacio;
        this.estado = estado;
    }

    /**
     * Obtiene el número de espacio de aparcamiento.
     *
     * @return El número de espacio de aparcamiento.
     */
    public String getNumeroEspacio() {
        return numeroEspacio;
    }

    /**
     * Establece el número de espacio de aparcamiento. Si el número es nulo o vacío, se imprime un mensaje de error.
     *
     * @param numeroEspacio El número de espacio a asignar.
     */
    public void setNumeroEspacio(String numeroEspacio) {
        if (numeroEspacio == null || numeroEspacio.isEmpty()) {
            System.out.println("Error: El espacio de aparcamiento no puede estar vacío.");
            return;
        }
        this.numeroEspacio = numeroEspacio;
    }

    /**
     * Obtiene el estado del espacio de aparcamiento.
     *
     * @return true si el espacio está ocupado, false si está libre.
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado del espacio. El estado solo puede ser true (ocupado) o false (libre).
     *
     * @param estado El estado a establecer (true o false).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene una cadena que contiene los detalles del espacio de aparcamiento, incluyendo
     * el número de espacio y su estado (ocupado o libre).
     *
     * @return Una cadena con el detalle del espacio de aparcamiento.
     */
    public String getDetalle() {
        return "Espacio de Aparcamiento: \n" +
                "\n El Número de Espacio asignado: " + numeroEspacio +
                "\n Estado del Espacio: " + (estado ? "Ocupado" : "Libre");
    }

    /**
     * Representación en cadena de la clase EspacioAparcamiento.
     *
     * @return Cadena con el número de espacio y su estado.
     */
    @Override
    public String toString() {
        return "EspacioAparcamiento {" +
                "numeroEspacio='" + numeroEspacio + '\'' +
                ", estado=" + (estado ? "Ocupado" : "Libre") +
                '}';
    }

    /**
     * Copia un arreglo de Espacios de Aparcamiento a otro usando System.arraycopy.
     *
     * @param origen  El arreglo original de Espacios de Aparcamiento.
     * @param destino El arreglo destino donde se copiarán los espacios.
     * @param cantidad La cantidad de elementos a copiar.
     */
    public static void copiarEspacios(EspacioAparcamiento[] origen, EspacioAparcamiento[] destino, int cantidad) {
        if (origen == null || destino == null || cantidad > origen.length || cantidad > destino.length) {
            System.out.println("Error: Los parámetros de copia no son válidos.");
            return;
        }
        System.arraycopy(origen, 0, destino, 0, cantidad);
        System.out.println("Se copiaron " + cantidad + " espacios de aparcamiento exitosamente.");
    }


}
