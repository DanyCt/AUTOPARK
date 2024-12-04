
import ec.edu.uce.dominio.Ticket;
import ec.edu.uce.dominio.AutoPark;
import java.util.Date;

public class TestTicket {
    public static void main(String[] args) {

        // Crear un objeto AutoPark para pruebas
        AutoPark autoPark = new AutoPark();
        autoPark.inicializarEspacios();  // Inicializamos los espacios de aparcamiento
        autoPark.inicializarTickets();   // Inicializamos los tickets en el sistema

        // Instanciar objeto utilizando el constructor por defecto
        Ticket ticket = new Ticket();

        // Probar métodos getter con el constructor por defecto
        System.out.println("\n===== Probando getters con constructor por defecto: =====");
        System.out.println("IdTicket: " + ticket.getIdTicket());
        System.out.println("Fecha de Ingreso: " + ticket.getFechaIngreso());
        System.out.println("Número de matrícula: " + ticket.getNumeroMatricula());
        System.out.println("Espacio de aparcamiento: " + ticket.getEspacioAparcamiento());
        System.out.println("Tarifa por hora: " + ticket.getTarifaHora());
        System.out.println("Fecha de Salida: " + ticket.getFechaSalida());
        System.out.println("Monto Total: " + ticket.getMontoTotal());

        // Verificación
        System.out.println("\n------ Test Constructor por Defecto con el método Detalle: -------");
        System.out.println(ticket.toString());

        // Instanciar objeto utilizando un constructor con parámetros
        Date fechaIngreso = new Date(); // Fecha de ingreso actual
        Date fechaSalida = new Date(fechaIngreso.getTime() + 60 * 60 * 1000); // Fecha de salida 1 hora después
        Ticket ticket1 = new Ticket(1, fechaIngreso, 15.0f, 2.0f, fechaSalida, "BBB123", "A2");

        // Calcular el monto total (calculando antes de mostrarlo)
        ticket1.calcularMontoTotal(); // El monto se calcula directamente dentro del objeto
        System.out.println("\nMonto total calculado: " + ticket1.getMontoTotal());

        // Verificación de las fechas y otros datos del ticket creado
        System.out.println("\n===== Test Constructor con Parámetros =====");
        System.out.println("IdTicket: " + ticket1.getIdTicket());
        System.out.println("Fecha de Ingreso: " + ticket1.getFechaIngreso());
        System.out.println("Número de Matrícula: " + ticket1.getNumeroMatricula());
        System.out.println("Espacio de Aparcamiento: " + ticket1.getEspacioAparcamiento());
        System.out.println("Tarifa por Hora: " + ticket1.getTarifaHora());
        System.out.println("Fecha de Salida: " + ticket1.getFechaSalida());
        System.out.println("Monto Total: " + ticket1.getMontoTotal());

        // Mostrar el toString
        System.out.println("\n------ Test Constructor con Parámetros con el método Detalle: -------");
        System.out.println(ticket1.toString());

        // Probando los métodos SETTERS
        System.out.println("\n===== Probando los métodos SETTERS =====");
        ticket1.setIdTicket(2);
        ticket1.setFechaIngreso(fechaIngreso);
        ticket1.setNumeroMatricula("CCC123");
        ticket1.setEspacioAparcamiento("A3");
        ticket1.setTarifaHora(1f); // Nueva tarifa
        ticket1.setFechaSalida(fechaSalida);

        // Recalcular automáticamente el monto total después de los cambios
        ticket1.calcularMontoTotal();
        System.out.println(ticket1.toString());

        // METODOS ADICIONALES: CREAR TICKET Y CONSULTAR TICKET
        // Crear un nuevo ticket
        ticket1.crearTicket(autoPark, ticket1.getIdTicket(), fechaIngreso, "CCC123", "A3");

        // Consultar un ticket creado a través del método consultarTicket
        String resultadoConsulta = ticket1.consultarTicket(autoPark, 2);
        System.out.println("\n------ Consultar Ticket ------");
        System.out.println(resultadoConsulta);
    }
}