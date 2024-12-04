package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubMenuEspacioAparcamiento {

    // Almacenamiento de espacios en memoria (numeroEspacio -> detalles)
    private static Map<Integer, Espacio> espacios = new HashMap<>();
    private static Validacion validacion = new Validacion();

    public static void gestionarAparcamiento() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== Gestión de Aparcamiento =====");
            System.out.println("1. Crear Espacio");
            System.out.println("2. Modificar Espacio");
            System.out.println("3. Consultar Espacio");
            System.out.println("4. Eliminar Espacio");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("======================================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearEspacio(scanner);
                    break;
                case 2:
                    modificarEspacio(scanner);
                    break;
                case 3:
                    consultarEspacio(scanner);
                    break;
                case 4:
                    eliminarEspacio(scanner);
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearEspacio(Scanner scanner) {
        System.out.println("===== Crear Espacio =====");

        // Solicitar el número del espacio
        System.out.print("Ingrese el número del espacio (ID): ");
        int numeroEspacio = scanner.nextInt();
        scanner.nextLine();

        // Verificar si el espacio ya existe
        if (espacios.containsKey(numeroEspacio)) {
            System.out.println("El espacio con este número ya existe. Intente con otro número.");
            return;
        }

        // Validar el estado del espacio
        System.out.println("\nSeleccione el estado del espacio:");
        System.out.println("1. Disponible");
        System.out.println("2. No disponible");
        System.out.println("==============================================");
        System.out.print("Seleccione una opción: ");
        int opcionEstado = scanner.nextInt();
        scanner.nextLine();
        String estado = validacion.validarEstado(opcionEstado);

        if (estado == null) {
            System.out.println("Estado inválido. Intente nuevamente.");
            return;
        }

        // Generar automáticamente la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crear y guardar el espacio
        Espacio nuevoEspacio = new Espacio(numeroEspacio, estado, fechaHoraActual);
        espacios.put(numeroEspacio, nuevoEspacio);
        System.out.println("Espacio creado exitosamente.");
    }

    private static void modificarEspacio(Scanner scanner) {
        System.out.println("===== Modificar Espacio =====");

        System.out.print("Ingrese el número del espacio a modificar: ");
        int numeroEspacio = scanner.nextInt();
        scanner.nextLine();

        // Verificar si el espacio existe
        if (espacios.containsKey(numeroEspacio)) {
            Espacio espacio = espacios.get(numeroEspacio);

            // Cambiar el estado
            System.out.println("Seleccione el nuevo estado del espacio:");
            System.out.println("1. Disponible");
            System.out.println("2. No disponible");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            int opcionEstado = scanner.nextInt();
            scanner.nextLine();
            String nuevoEstado = validacion.validarEstado(opcionEstado);

            if (nuevoEstado == null) {
                System.out.println("Estado inválido. Intente nuevamente.");
                return;
            }

            espacio.setEstado(nuevoEstado);
            espacio.setUltimaModificacion(LocalDateTime.now());
            System.out.println("Espacio modificado exitosamente.");
        } else {
            System.out.println("El espacio no existe.");
        }
    }

    private static void consultarEspacio(Scanner scanner) {
        System.out.println("===== Consultar Espacio =====");

        System.out.print("Ingrese el número del espacio (ID) a consultar: ");
        int numeroEspacio = scanner.nextInt();
        scanner.nextLine();

        if (espacios.containsKey(numeroEspacio)) {
            Espacio espacio = espacios.get(numeroEspacio);
            System.out.println("Número del Espacio: " + espacio.getNumeroEspacio());
            System.out.println("Estado: " + espacio.getEstado());
            System.out.println("Fecha y Hora de Creación: " + espacio.getFechaHoraCreacion());
            System.out.println("Última Modificación: " + espacio.getUltimaModificacion());
        } else {
            System.out.println("El espacio no existe.");
        }
    }

    private static void eliminarEspacio(Scanner scanner) {
        System.out.println("===== Eliminar Espacio =====");

        System.out.print("Ingrese el número del espacio (ID) a eliminar: ");
        int numeroEspacio = scanner.nextInt();
        scanner.nextLine();

        if (espacios.containsKey(numeroEspacio)) {
            espacios.remove(numeroEspacio);
            System.out.println("Espacio eliminado exitosamente.");
        } else {
            System.out.println("El espacio no existe. Verifique el número ingresado.");
        }
    }

    // Clase para representar un Espacio
    private static class Espacio {
        private int numeroEspacio;
        private String estado;
        private LocalDateTime fechaHoraCreacion;
        private LocalDateTime ultimaModificacion;

        public Espacio(int numeroEspacio, String estado, LocalDateTime fechaHoraCreacion) {
            this.numeroEspacio = numeroEspacio;
            this.estado = estado;
            this.fechaHoraCreacion = fechaHoraCreacion;
            this.ultimaModificacion = fechaHoraCreacion;
        }

        public int getNumeroEspacio() {
            return numeroEspacio;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public LocalDateTime getFechaHoraCreacion() {
            return fechaHoraCreacion;
        }

        public LocalDateTime getUltimaModificacion() {
            return ultimaModificacion;
        }

        public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
            this.ultimaModificacion = ultimaModificacion;
        }
    }
}
