package ec.edu.uce.dominio;

import java.util.Date;

/**
 * Representa un ticket de aparcamiento con la información relacionada al vehículo estacionado,
 * incluyendo su matrícula, el espacio asignado, la fecha de ingreso y salida, y el monto total a pagar.
 */
public class Ticket {
    private int idTicket;
    private Date fechaIngreso;
    private float montoTotal;
    private float tarifaHora;
    private Date fechaSalida;
    private String numeroMatricula;
    private String espacioAparcamiento;

    /**
     * Constructor sin parámetros, establece valores predeterminados para el ticket.
     */
    public Ticket() {
        this.idTicket = 0;
        this.fechaIngreso = new Date(); // Fecha automática (actual)
        this.montoTotal = 0.0f;
        this.tarifaHora = 0.0f;
        this.fechaSalida = new Date(this.fechaIngreso.getTime() + 3600000); // 1 hora después de la fecha de ingreso
        this.numeroMatricula = null;
        this.espacioAparcamiento = null;
    }

    /**
     * Constructor con parámetros para crear un ticket con valores específicos.
     *
     * @param idTicket ID único del ticket.
     * @param fechaIngreso Fecha de ingreso al aparcamiento.
     * @param montoTotal Monto total calculado del ticket.
     * @param tarifaHora Tarifa por hora del aparcamiento.
     * @param fechaSalida Fecha de salida del vehículo.
     * @param numeroMatricula Número de matrícula del vehículo.
     * @param espacioAparcamiento Espacio asignado para el vehículo en el aparcamiento.
     */
    public Ticket(int idTicket, Date fechaIngreso, float montoTotal, float tarifaHora, Date fechaSalida, String numeroMatricula, String espacioAparcamiento) {
        this.idTicket = idTicket;
        this.fechaIngreso = fechaIngreso;
        this.montoTotal = montoTotal;
        this.tarifaHora = tarifaHora;
        this.fechaSalida = fechaSalida;
        this.numeroMatricula = numeroMatricula;
        this.espacioAparcamiento = espacioAparcamiento;
    }

    /**
     * Obtiene el ID del ticket.
     *
     * @return El ID del ticket.
     */
    public int getIdTicket() {
        return idTicket;
    }

    /**
     * Establece el ID del ticket.
     *
     * @param idTicket El ID del ticket.
     */
    public void setIdTicket(int idTicket) {
        if (idTicket <= 0) {
            System.out.println("Error: El ID del ticket debe ser mayor a cero.");
            return;
        }
        this.idTicket = idTicket;
    }

    /**
     * Obtiene la fecha de ingreso del vehículo al aparcamiento.
     *
     * @return La fecha de ingreso.
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del vehículo al aparcamiento.
     *
     * @param fechaIngreso La fecha de ingreso.
     */
    public void setFechaIngreso(Date fechaIngreso) {
        if (fechaIngreso == null) {
            System.out.println("Error: La fecha de ingreso no puede ser nula.");
            return;
        }
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Obtiene el monto total a pagar por el aparcamiento.
     *
     * @return El monto total.
     */
    public float getMontoTotal() {
        return montoTotal;
    }

    /**
     * Establece el monto total a pagar por el aparcamiento.
     *
     * @param montoTotal El monto total.
     */
    public void setMontoTotal(float montoTotal) {
        if (montoTotal < 0) {
            System.out.println("Error: El monto total no puede ser negativo.");
            return;
        }
        this.montoTotal = montoTotal;
    }

    /**
     * Obtiene la tarifa por hora del aparcamiento.
     *
     * @return La tarifa por hora.
     */
    public float getTarifaHora() {
        return tarifaHora;
    }

    /**
     * Establece la tarifa por hora del aparcamiento.
     *
     * @param tarifaHora La tarifa por hora.
     */
    public void setTarifaHora(float tarifaHora) {
        if (tarifaHora <= 0) {
            System.out.println("Error: La tarifa por hora debe ser mayor a cero.");
            return;
        }
        this.tarifaHora = tarifaHora;
    }

    /**
     * Obtiene la fecha de salida del vehículo del aparcamiento.
     *
     * @return La fecha de salida.
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida del vehículo del aparcamiento.
     *
     * @param fechaSalida La fecha de salida.
     */

    public void setFechaSalida(Date fechaSalida) {
        if (fechaSalida == null) {
            System.out.println("Error: La fecha de salida no puede ser nula.");
            return;
        }
        if (fechaSalida.before(this.fechaIngreso)) {
            System.out.println("Error: La fecha de salida no puede ser anterior a la fecha de ingreso.");
            return;
        }
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el número de matrícula del vehículo.
     *
     * @return El número de matrícula.
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    /**
     * Establece el número de matrícula del vehículo.
     *
     * @param numeroMatricula El número de matrícula.
     */
    public void setNumeroMatricula(String numeroMatricula) {
        if (numeroMatricula == null || numeroMatricula.isEmpty()) {
            System.out.println("Error: El número de matrícula no puede estar vacío.");
            return;
        }
        this.numeroMatricula = numeroMatricula;
    }

    /**
     * Obtiene el espacio asignado en el aparcamiento para el vehículo.
     *
     * @return El espacio de aparcamiento.
     */
    public String getEspacioAparcamiento() {
        return espacioAparcamiento;
    }

    /**
     * Establece el espacio de aparcamiento para el vehículo.
     *
     * @param espacioAparcamiento El espacio de aparcamiento.
     */
    public void setEspacioAparcamiento(String espacioAparcamiento) {
        if (espacioAparcamiento == null || espacioAparcamiento.isEmpty()) {
            System.out.println("Error: El espacio de aparcamiento no puede estar vacío.");
            return;
        }
        this.espacioAparcamiento = espacioAparcamiento;
    }

    /**
     * Calcula el monto total a pagar por el aparcamiento basándose en la diferencia
     * de horas entre la fecha de ingreso y la fecha de salida.
     */
    public void calcularMontoTotal() {
        if (fechaIngreso == null || fechaSalida == null) {
            System.out.println("Error: Fecha de ingreso o salida no definidas. No se puede calcular el monto total.");
            montoTotal = 0; // Retornar 0 como valor por defecto
            return;
        }

        if (fechaSalida.before(fechaIngreso)) {
            System.out.println("Error: La fecha de salida no puede ser anterior a la fecha de ingreso.");
            montoTotal = 0; // Validar que la salida no sea anterior a la entrada
            return;
        }

        // Obtener las horas y minutos de las fechas de ingreso y salida
        int horasIngreso = fechaIngreso.getHours();
        int minutosIngreso = fechaIngreso.getMinutes();
        int horasSalida = fechaSalida.getHours();
        int minutosSalida = fechaSalida.getMinutes();

        // Calcular la diferencia en minutos entre la fecha de ingreso y salida
        int minutosTotales = (horasSalida * 60 + minutosSalida) - (horasIngreso * 60 + minutosIngreso);

        // Si la diferencia es negativa (cuando los minutos de salida son menores que los de ingreso), corregirla
        if (minutosTotales < 0) {
            // Ajustar por el cambio de día
            minutosTotales += 24 * 60;
        }

        // Convertir minutos a horas
        float horasTotales = minutosTotales / 60.0f;

        // Calcular el monto total
        montoTotal = horasTotales * tarifaHora;
    }

    /**
     * Genera un detalle completo del ticket, incluyendo toda la información relevante.
     *
     * @return Un string con el detalle completo del ticket.
     */
    public String toString() {
        return "Ticket : \n" +
                "\n IdTicket: " + idTicket +
                "\n Fecha de Ingreso: " + fechaIngreso +
                "\n Numero de Matricula: " + numeroMatricula +
                "\n Espacio de Aparcamiento: " + espacioAparcamiento +
                "\n Tarifa por hora: " + tarifaHora +
                "\n Fecha de salida: " + fechaSalida +
                "\n Monto Total: " + montoTotal;
    }

    public void crearTicket(AutoPark autoPark, int idTicket, Date fechaIngreso, String numeroMatricula, String espacioAparcamiento) {
        this.idTicket = idTicket;
        this.fechaIngreso = fechaIngreso;
        this.numeroMatricula = numeroMatricula;
        this.espacioAparcamiento = espacioAparcamiento;

        // Buscar la tarifa por hora en el sistema
        // Suponiendo que hay una tarifa predeterminada en AutoPark, puede ser definida aquí
        this.tarifaHora = 5.0f; // Por ejemplo, 5 unidades monetarias por hora

        // Calcular monto total
        this.calcularMontoTotal();

        // Asignar el ticket al espacio de aparcamiento
        // Actualizar el espacio a ocupado en AutoPark
        for (EspacioAparcamiento espacio : autoPark.espacioAparcamientos) {
            if (espacio.getNumeroEspacio().equals(espacioAparcamiento)) {
                espacio.setEstado(true);
                break;
            }
        }

        // Agregar el ticket al sistema de tickets
        for (int i = 0; i < autoPark.tickets.length; i++) {
            if (autoPark.tickets[i] == null) {
                autoPark.tickets[i] = this;
                break;
            }
        }
    }

    /**
     * Consultar un ticket específico en el sistema. por el id
     */
    public String consultarTicket(AutoPark autoPark, int idTicket) {
        for (Ticket ticket : autoPark.tickets) {
            if (ticket != null && ticket.getIdTicket() == idTicket) {
                return ticket.toString();
            }
        }
        return "Ticket no encontrado.";
    }
}
