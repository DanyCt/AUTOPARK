import ec.edu.uce.dominio.TicketCarga;

public class TestTicketCarga {
    public static void main(String[] args) {

        // Instancia utilizando el método constructor por defecto (get)
        TicketCarga ticketCarga = new TicketCarga();
        System.out.println("\n===== Probando getters con constructor por defecto: =====");
        System.out.println("Tarifa Especial: " + ticketCarga.getTarifaEspecial());
        System.out.println("Tarifa por Hora: " + ticketCarga.getTarifaHoraCarga());

        // Probar el método toString para obtener el detalle completo
        System.out.println("\n------ Test Constructor por Defecto con el método Detalle: -------");
        System.out.println(ticketCarga.toString());

        // Instancia utilizando el método constructor por parámetros
        TicketCarga ticketCarga1 = new TicketCarga(12.0, 10.0f);

        // Probando los métodos getters después de la creación con parámetros
        System.out.println("\n===== Probando getters con constructor por parámetros: =====");
        System.out.println("Tarifa Especial: " + ticketCarga1.getTarifaEspecial());
        System.out.println("Tarifa por Hora: " + ticketCarga1.getTarifaHoraCarga());

        // Probar el método toString después de instanciar con parámetros
        System.out.println("\n------ Test Constructor por Parámetros con el método Detalle: -------");
        System.out.println(ticketCarga1.toString());

        // Probando el método set para modificar las tarifas
        System.out.println("\n===== Probando métodos setters: =====");
        ticketCarga1.setTarifaEspecial(15.0);  // Tarifa especial mayor que la tarifa por hora
        ticketCarga1.setTarifaHoraCarga(2.0f); // Establecer una nueva tarifa por hora
        System.out.println(ticketCarga1.toString());

        // Intentando aplicar una tarifa especial inválida (menor que la tarifa por hora)
        System.out.println("\n===== Probando validación en el setter de tarifa especial: =====");
        ticketCarga1.setTarifaEspecial(1.0);  // Tarifa especial menor que la tarifa por hora
        System.out.println(ticketCarga1.toString());  // Ver cómo se maneja la validación

        // Crear el ticket de carga y aplicar tarifa especial
        System.out.println("\n===== Probando el método crearTicketCarga y aplicarTarifaEspecial: =====");
        ticketCarga1.crearTicketCarga();  // Esto debería aplicar la tarifa especial si es válida

        // Ver el ticket después de la creación
        System.out.println("\n----- Detalle del Ticket después de crearlo: -----");
        System.out.println(ticketCarga1.toString());
    }
}