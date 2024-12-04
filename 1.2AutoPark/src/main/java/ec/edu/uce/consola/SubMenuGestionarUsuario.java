package ec.edu.uce.consola;

import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.util.Validacion;
import java.util.Scanner;

public class SubMenuGestionarUsuario {

    // Estructura para almacenar las cuentas utilizando un arreglo
    private static Cuenta[] cuentas = new Cuenta[10]; // Arreglo con un tamaño inicial
    private static int contadorCuentas = 0;  // Contador de cuentas almacenadas
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarCuenta() {
        int opcion;

        do {
            System.out.println("\n============= Gestionar Cuenta ===============");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Editar Cuenta");
            System.out.println("3. Consultar Cuenta");
            System.out.println("4. Eliminar Cuenta");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("==================================================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    editarCuenta();
                    break;
                case 3:
                    consultarCuenta();
                    break;
                case 4:
                    eliminarCuenta();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearCuenta() {
        System.out.println("\n================== CREAR CUENTA ====================");

        // Validar nombre de usuario
        String nombreUsuario = "";
        while (true) {
            System.out.print("Ingrese su nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            if (Validacion.validarNombreUsuario(nombreUsuario)) {
                break;
            } else {
                System.out.println("Nombre de usuario no válido. Intente nuevamente.");
            }
        }

        // Validar correo
        String correo = "";
        while (true) {
            System.out.print("Ingrese su correo electrónico: ");
            correo = scanner.nextLine();
            if (Validacion.validarCorreo(correo)) {
                break;
            } else {
                System.out.println("Correo no válido. Intente nuevamente.");
            }
        }

        // Validar contraseña
        String contrasenia = "";
        while (true) {
            System.out.print("Ingrese su contraseña: ");
            contrasenia = scanner.nextLine();
            if (Validacion.validarContrasenia(contrasenia)) {
                break;
            } else {
                System.out.println("Contraseña no válida. Intente nuevamente.");
            }
        }

        // Generar un ID único para la cuenta
        int idUsuario = generarIDUnico();

        // Comprobar si ya existe una cuenta con ese ID
        if (buscarCuentaPorId(idUsuario) != null) {
            System.out.println("La cuenta con este ID ya existe. Intente nuevamente.");
        } else {
            // Si el arreglo está lleno, redimensionarlo
            if (contadorCuentas == cuentas.length) {
                redimensionarArreglo();
            }

            // Crear el objeto Usuario
            Usuario usuario = new Usuario(idUsuario, nombreUsuario, correo, contrasenia);
            cuentas[contadorCuentas] = new Cuenta(usuario);
            contadorCuentas++;

            // Mostrar el ID de la cuenta antes del mensaje de éxito
            System.out.println("ID de la cuenta creada: " + idUsuario);  // Mostrar el ID
            System.out.println("Cuenta creada exitosamente.");
        }
    }

    private static void editarCuenta() {
        System.out.println("\n================== EDITAR CUENTA ====================");

        // Validar ID de la cuenta a editar
        int idUsuario = 0;
        while (true) {
            System.out.print("Ingrese el ID de la cuenta a editar: ");
            if (scanner.hasNextInt()) {
                idUsuario = scanner.nextInt();
                if (idUsuario > 0) {
                    break;
                } else {
                    System.out.println("El ID debe ser un número positivo.");
                }
            } else {
                System.out.println("ID no válido. Intente nuevamente.");
                scanner.next(); // Limpiar el buffer
            }
        }

        Cuenta cuenta = buscarCuentaPorId(idUsuario);
        if (cuenta != null) {
            System.out.println("\nEstá editando la cuenta");

            // Nuevos datos
            String nuevoNombreUsuario = "";
            while (true) {
                System.out.print("Nuevo nombre de usuario (actual: " + cuenta.getUsuario().getNombre() + "): ");
                nuevoNombreUsuario = scanner.nextLine();
                if (Validacion.validarNombreUsuario(nuevoNombreUsuario)) {
                    break;
                } else {
                    System.out.println("Nombre de usuario no válido. Intente nuevamente.");
                }
            }

            String nuevoCorreo = "";
            while (true) {
                System.out.print("Nuevo correo (actual: " + cuenta.getUsuario().getCorreo() + "): ");
                nuevoCorreo = scanner.nextLine();
                if (Validacion.validarCorreo(nuevoCorreo)) {
                    break;
                } else {
                    System.out.println("Correo no válido. Intente nuevamente.");
                }
            }

            String nuevaContrasenia = "";
            while (true) {
                System.out.print("Nueva contraseña: ");
                nuevaContrasenia = scanner.nextLine();
                if (Validacion.validarContrasenia(nuevaContrasenia)) {
                    break;
                } else {
                    System.out.println("Contraseña no válida. Intente nuevamente.");
                }
            }

            // Usando los métodos de la clase Usuario
            cuenta.getUsuario().setNombre(nuevoNombreUsuario);
            cuenta.getUsuario().setCorreo(nuevoCorreo);
            cuenta.getUsuario().setContrasenia(nuevaContrasenia);

            System.out.println("Cuenta actualizada exitosamente.");
        } else {
            System.out.println("No se encontró una cuenta con el ID proporcionado.");
        }
    }

    private static void consultarCuenta() {
        System.out.println("\n================== CONSULTAR CUENTA ====================");

        // Validar ID de la cuenta a consultar
        int idUsuario = 0;
        while (true) {
            System.out.print("Ingrese el ID de la cuenta para consultar: ");
            if (scanner.hasNextInt()) {
                idUsuario = scanner.nextInt();
                if (idUsuario > 0) {
                    break;
                } else {
                    System.out.println("El ID debe ser un número positivo.");
                }
            } else {
                System.out.println("ID no válido. Intente nuevamente.");
                scanner.next(); // Limpiar el buffer
            }
        }

        Cuenta cuenta = buscarCuentaPorId(idUsuario);
        if (cuenta != null) {
            System.out.println("\nInformación de la cuenta:");
            System.out.println(cuenta.getUsuario().getClass());  // Usando el método getDetalle() de Usuario
        } else {
            System.out.println("No se encontró una cuenta con el ID proporcionado.");
        }
    }

    private static void eliminarCuenta() {
        System.out.println("\n================== ELIMINAR CUENTA ====================");

        // Validar ID de la cuenta a eliminar
        int idUsuario = 0;
        while (true) {
            System.out.print("Ingrese el ID de la cuenta a eliminar: ");
            if (scanner.hasNextInt()) {
                idUsuario = scanner.nextInt();
                if (idUsuario > 0) {
                    break;
                } else {
                    System.out.println("El ID debe ser un número positivo.");
                }
            } else {
                System.out.println("ID no válido. Intente nuevamente.");
                scanner.next(); // Limpiar el buffer
            }
        }

        Cuenta cuenta = buscarCuentaPorId(idUsuario);
        if (cuenta != null) {
            eliminarCuentaPorReferencia(cuenta);
            System.out.println("Cuenta eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una cuenta con el ID proporcionado.");
        }
    }

    private static Cuenta buscarCuentaPorId(int idUsuario) {
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas[i].getUsuario().getIdUsuario() == idUsuario) {
                return cuentas[i];
            }
        }
        return null;  // Si no se encuentra la cuenta
    }

    private static void eliminarCuentaPorReferencia(Cuenta cuenta) {
        for (int i = 0; i < contadorCuentas; i++) {
            if (cuentas[i] == cuenta) {
                for (int j = i; j < contadorCuentas - 1; j++) {
                    cuentas[j] = cuentas[j + 1];  // Desplazar las cuentas hacia la izquierda
                }
                cuentas[contadorCuentas - 1] = null;  // Eliminar la última cuenta
                contadorCuentas--;
                break;
            }
        }
    }

    private static void redimensionarArreglo() {
        // Redimensionar el arreglo para permitir más cuentas
        Cuenta[] nuevoArreglo = new Cuenta[cuentas.length * 2];
        System.arraycopy(cuentas, 0, nuevoArreglo, 0, cuentas.length);
        cuentas = nuevoArreglo;
    }

    private static int generarIDUnico() {
        return contadorCuentas + 1;  // Generar un ID único basado en el contador de cuentas
    }

    // Clase interna para almacenar los datos de una cuenta
    public static class Cuenta {
        private Usuario usuario;

        public Cuenta(Usuario usuario) {
            this.usuario = usuario;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
    }
}

