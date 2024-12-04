package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;

import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner scanner = new Scanner(System.in);
    private final MenuCasosUso menuCasosUso;

    // Variables estáticas para almacenar los datos del usuario registrado
    private static String nombreUsuario;
    private static String correoRegistrado;
    private static String contraseniaRegistrada;

    public MenuPrincipal() {
        this.menuCasosUso = new MenuCasosUso(this); // Pasamos la instancia de MenuPrincipal a MenuCasosUso
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n*************************************************");
        System.out.println("                    MENU PRINCIPAL                ");
        System.out.println("**************************************************");
        System.out.println("1. Registrarse");
        System.out.println("2. Ingresar al Sistema");
        System.out.println("3. Salir");
        System.out.println("**************************************************");
        System.out.print("Seleccione una opción (1-3): ");
    }

    public void seleccionarMenu() {
        int opcion = -1;
        do {
            mostrarMenuPrincipal();
            while (!scanner.hasNextInt()) {
                System.out.println("Opción no válida. Ingrese un número entero positivo.");
                scanner.nextLine();
                mostrarMenuPrincipal();
            }
            opcion = scanner.nextInt();
            if (opcion <= 0 || opcion > 3) {
                System.out.println("Opción no válida. Seleccione entre 1 a 3.");
                continue;
            }
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarse();
                    break;
                case 2:
                    ingresar();
                    break;
                case 3:
                    System.out.println("Gracias por usar AutoPark.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private void registrarse() {
        System.out.println("============= REGISTRO DE USUARIO =============");
        String nombre;
        String correo;
        String contrasenia;

        // Validar nombre de usuario
        boolean esValido;
        do {
            System.out.print("Ingrese su nombre de usuario: ");
            nombre = scanner.nextLine();
            esValido = Validacion.validarNombreUsuario(nombre);
            if (!esValido) {
                System.out.println(" ");
            }
        } while (!esValido);

        // Validar correo
        do {
            System.out.print("Ingrese su correo electrónico: ");
            correo = scanner.nextLine();
            esValido = Validacion.validarCorreo(correo);
            if (!esValido) {
                System.out.println(" ");
            }
        } while (!esValido);

        // Validar contraseña
        do {
            System.out.print("Ingrese su contraseña: ");
            contrasenia = scanner.nextLine();
            esValido = Validacion.validarContrasenia(contrasenia);
            if (!esValido) {
                System.out.println(" ");
            }
        } while (!esValido);

        // Guardar los datos del usuario registrado en las variables estáticas
        nombreUsuario = nombre;
        correoRegistrado = correo;
        contraseniaRegistrada = contrasenia;

        System.out.println("Usuario registrado exitosamente.");
    }

    private void ingresar() {
        System.out.println("============== INGRESO AL SISTEMA =================");
        String correo;
        String contrasenia;

        do {
            System.out.print("Ingrese su correo electrónico: ");
            correo = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            contrasenia = scanner.nextLine();

            // Verificar si el correo y la contraseña coinciden con los registrados
            if (correo.equals(correoRegistrado) && contrasenia.equals(contraseniaRegistrada)) {
                System.out.println("Inicio de sesión exitoso.");
                menuCasosUso.mostrarMenuCasosUso();  // Llamamos al menú de casos de uso
                return;
            } else {
                System.out.println("Correo o contraseña no válidos.");
            }
        } while (true);
    }

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.seleccionarMenu();
    }
}
