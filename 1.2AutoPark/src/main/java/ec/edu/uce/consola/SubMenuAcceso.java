package ec.edu.uce.consola;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubMenuAcceso {

    // Almacenamiento de entradas, tickets y salidas
    private static Map<String, Entrada> entradas = new HashMap<>();
    private static Map<String, Ticket> tickets = new HashMap<>();

    public static void administrarAcceso() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== Gestión de Acceso =====");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Asignar Espacio");
            System.out.println("3. Generar Ticket");
            System.out.println("4. Registrar Salida");
            System.out.println("5. Consultar Ticket");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("===============================");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            switch (opcion) {
                case 1:
                    registrarEntrada(scanner);
                    break;
                case 2:
                    asignarEspacio(scanner);
                    break;
                case 3:
                    generarTicket(scanner);
                    break;
                case 4:
                    registrarSalida(scanner);
                    break;
                case 5:
                    consultarTicket(scanner);
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void registrarEntrada(Scanner scanner) {
        System.out.println("\n===== Registrar Entrada =====");

        System.out.print("Ingrese el número de matrícula: ");
        String matricula = scanner.nextLine();

        if (entradas.containsKey(matricula)) {
            System.out.println("Ya existe una entrada registrada para esta matrícula.");
        } else {
            LocalDateTime fechaHoraIngreso = LocalDateTime.now();
            Entrada entrada = new Entrada(matricula, fechaHoraIngreso);
            entradas.put(matricula, entrada);
            System.out.println("Entrada registrada exitosamente.");
        }
    }

    private static void asignarEspacio(Scanner scanner) {
        System.out.println("\n===== Asignar Espacio =====");

        System.out.print("Ingrese el número de matrícula: ");
        String matricula = scanner.nextLine();

        if (entradas.containsKey(matricula)) {
            System.out.print("Ingrese el ID del espacio: ");
            int idEspacio = scanner.nextInt();

            Entrada entrada = entradas.get(matricula);
            entrada.setIdEspacio(idEspacio);
            System.out.println("Espacio asignado exitosamente.");
        } else {
            System.out.println("No se encontró una entrada para esta matrícula.");
        }
    }

    private static void generarTicket(Scanner scanner) {
        System.out.println("\n===== Generar Ticket =====");

        System.out.print("Ingrese el número de matrícula: ");
        String matricula = scanner.nextLine();

        if (entradas.containsKey(matricula)) {
            Entrada entrada = entradas.get(matricula);
            int idEspacio = entrada.getIdEspacio();

            if (idEspacio == -1) {
                System.out.println("Debe asignar un espacio antes de generar un ticket.");
                return;
            }

            LocalDateTime fechaHoraIngreso = entrada.getFechaHoraIngreso();
            int idTicket = tickets.size() + 1;

            Ticket ticket = new Ticket(matricula, idEspacio, idTicket, fechaHoraIngreso);
            tickets.put(matricula, ticket);
            System.out.println("Ticket generado exitosamente: ");
            System.out.println(ticket);
        } else {
            System.out.println("No se encontró una entrada para esta matrícula.");
        }
    }

    private static void registrarSalida(Scanner scanner) {
        System.out.println("\n===== Registrar Salida =====");

        System.out.print("Ingrese el número de matrícula: ");
        String matricula = scanner.nextLine();

        if (tickets.containsKey(matricula)) {
            Ticket ticket = tickets.get(matricula);
            LocalDateTime fechaHoraSalida = LocalDateTime.now();
            ticket.setFechaHoraSalida(fechaHoraSalida);

            System.out.println("Salida registrada exitosamente.");
            System.out.println(ticket);
        } else {
            System.out.println("No se encontró un ticket para esta matrícula.");
        }
    }

    private static void consultarTicket(Scanner scanner) {
        System.out.println("\n===== Consultar Ticket =====");

        System.out.print("Ingrese el número de matrícula: ");
        String matricula = scanner.nextLine();

        if (tickets.containsKey(matricula)) {
            Ticket ticket = tickets.get(matricula);
            System.out.println(ticket);
        } else {
            System.out.println("No se encontró un ticket para esta matrícula.");
        }
    }

    // Clase para representar una Entrada
    private static class Entrada {
        private String matricula;
        private LocalDateTime fechaHoraIngreso;
        private int idEspacio;

        public Entrada(String matricula, LocalDateTime fechaHoraIngreso) {
            this.matricula = matricula;
            this.fechaHoraIngreso = fechaHoraIngreso;
            this.idEspacio = -1; // Inicialmente sin asignar
        }

        public LocalDateTime getFechaHoraIngreso() {
            return fechaHoraIngreso;
        }

        public int getIdEspacio() {
            return idEspacio;
        }

        public void setIdEspacio(int idEspacio) {
            this.idEspacio = idEspacio;
        }
    }

    // Clase para representar un Ticket
    private static class Ticket {
        private String matricula;
        private int idEspacio;
        private int idTicket;
        private LocalDateTime fechaHoraIngreso;
        private LocalDateTime fechaHoraSalida;

        public Ticket(String matricula, int idEspacio, int idTicket, LocalDateTime fechaHoraIngreso) {
            this.matricula = matricula;
            this.idEspacio = idEspacio;
            this.idTicket = idTicket;
            this.fechaHoraIngreso = fechaHoraIngreso;
        }

        public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
            this.fechaHoraSalida = fechaHoraSalida;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return "Ticket ID: " + idTicket +
                    "\nMatrícula: " + matricula +
                    "\nID Espacio: " + idEspacio +
                    "\nFecha y Hora de Ingreso: " + fechaHoraIngreso.format(formatter) +
                    (fechaHoraSalida != null ? "\nFecha y Hora de Salida: " + fechaHoraSalida.format(formatter) : "");
        }
    }
}