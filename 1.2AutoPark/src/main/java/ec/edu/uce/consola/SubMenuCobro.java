package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SubMenuCobro {

    // Arreglo para almacenar los cobros
    private static Cobro[] cobros = new Cobro[100]; // Arreglo con tamaño fijo
    private static int indice = 0; // Índice para llevar el control de las posiciones ocupadas
    private static Validacion validacion = new Validacion();

    public static void gestionarCobro() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== Gestionar Cobro =====");
            System.out.println("1. Crear Cobro");
            System.out.println("2. Modificar Cobro");
            System.out.println("3. Eliminar Cobro");
            System.out.println("4. Consultar Cobro");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("==============================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            switch (opcion) {
                case 1:
                    crearCobro(scanner);
                    break;
                case 2:
                    modificarCobro(scanner);
                    break;
                case 3:
                    eliminarCobro(scanner);
                    break;
                case 4:
                    consultarCobro(scanner);
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearCobro(Scanner scanner) {
        System.out.println("\n===== Crear Cobro =====");

        // Seleccionar el tipo de vehículo
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Auto ($1/hora)");
        System.out.println("2. Moto ($1/hora)");
        System.out.println("3. Camión ($2/hora)");
        System.out.println("================================");
        System.out.print("Seleccione una opción: ");
        int opcionTipo = scanner.nextInt();
        scanner.nextLine();

        String tipoVehiculo;
        double tarifaHora;
        switch (opcionTipo) {
            case 1:
                tipoVehiculo = "Auto";
                tarifaHora = 1.0;
                break;
            case 2:
                tipoVehiculo = "Moto";
                tarifaHora = 1.0;
                break;
            case 3:
                tipoVehiculo = "Camión";
                tarifaHora = 2.0;
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                return;
        }

        // Solicitar la placa del vehículo
        System.out.println("Tener en cuenta (A-Z\0-9)");
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        if (!validacion.validarPlaca(placa)) {
            System.out.println("La placa ingresada no es válida. Intente nuevamente.");
            return;
        }

        // Verificar si ya existe un cobro para esa placa
        for (int i = 0; i < indice; i++) {
            if (cobros[i] != null && cobros[i].getPlaca().equals(placa)) {
                System.out.println("Ya existe un cobro registrado para esta placa.");
                return;
            }
        }

        // Generar la fecha y hora actual
        LocalDateTime fechaHora = LocalDateTime.now();

        // Crear y registrar el cobro
        Cobro cobro = new Cobro(placa, tipoVehiculo, tarifaHora, fechaHora);
        cobros[indice++] = cobro;

        System.out.println("Cobro creado exitosamente.");
    }

    private static void modificarCobro(Scanner scanner) {
        System.out.println("\n===== Modificar Cobro =====");

        System.out.print("Ingrese la placa del vehículo a modificar: ");
        String placa = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (cobros[i].getPlaca().equals(placa)) {
                System.out.println("Seleccione el nuevo tipo de vehículo:");
                System.out.println("1. Auto ($1/hora)");
                System.out.println("2. Moto ($1/hora)");
                System.out.println("3. Camión ($2/hora)");
                System.out.print("Seleccione una opción: ");
                int opcionTipo = scanner.nextInt();
                scanner.nextLine();

                String tipoVehiculo;
                double tarifaHora;
                switch (opcionTipo) {
                    case 1:
                        tipoVehiculo = "Auto";
                        tarifaHora = 1.0;
                        break;
                    case 2:
                        tipoVehiculo = "Moto";
                        tarifaHora = 1.0;
                        break;
                    case 3:
                        tipoVehiculo = "Camión";
                        tarifaHora = 2.0;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        return;
                }

                cobros[i].setTipoVehiculo(tipoVehiculo);
                cobros[i].setTarifaHora(tarifaHora);
                cobros[i].setFechaHora(LocalDateTime.now());

                System.out.println("Cobro modificado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un cobro con esta placa.");
    }

    private static void eliminarCobro(Scanner scanner) {
        System.out.println("\n===== Eliminar Cobro =====");

        System.out.print("Ingrese la placa del vehículo a eliminar: ");
        String placa = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (cobros[i].getPlaca().equals(placa)) {
                cobros[i] = null;
                System.out.println("Cobro eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró un cobro con esta placa.");
    }

    private static void consultarCobro(Scanner scanner) {
        System.out.println("\n===== Consultar Cobro =====");

        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (cobros[i].getPlaca().equals(placa)) {
                Cobro cobro = cobros[i];
                System.out.println(cobro);

                // Calcular el tiempo transcurrido
                Duration duration = Duration.between(cobro.getFechaHora(), LocalDateTime.now());
                long horas = duration.toHours();
                long minutos = duration.toMinutes() % 60;
                System.out.println("Tiempo transcurrido: " + horas + " horas y " + minutos + " minutos.");

                // Calcular el cobro
                double totalCobro = cobro.getTarifaHora() * horas;
                System.out.println("Total a pagar: $" + totalCobro);
                return;
            }
        }

        System.out.println("No se encontró un cobro con esta placa.");
    }

    // Clase Cobro
    private static class Cobro {
        private String placa;
        private String tipoVehiculo;
        private double tarifaHora;
        private LocalDateTime fechaHora;

        public Cobro(String placa, String tipoVehiculo, double tarifaHora, LocalDateTime fechaHora) {
            this.placa = placa;
            this.tipoVehiculo = tipoVehiculo;
            this.tarifaHora = tarifaHora;
            this.fechaHora = fechaHora;
        }

        public String getPlaca() {
            return placa;
        }

        public String getTipoVehiculo() {
            return tipoVehiculo;
        }

        public double getTarifaHora() {
            return tarifaHora;
        }

        public LocalDateTime getFechaHora() {
            return fechaHora;
        }

        public void setTipoVehiculo(String tipoVehiculo) {
            this.tipoVehiculo = tipoVehiculo;
        }

        public void setTarifaHora(double tarifaHora) {
            this.tarifaHora = tarifaHora;
        }

        public void setFechaHora(LocalDateTime fechaHora) {
            this.fechaHora = fechaHora;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return "Placa: " + placa +
                    "\nTipo de Vehículo: " + tipoVehiculo +
                    "\nTarifa por Hora: $" + tarifaHora +
                    "\nFecha y Hora de Cobro: " + fechaHora.format(formatter);
        }
    }
}
