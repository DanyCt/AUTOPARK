package ec.edu.uce.consola;

import java.util.Scanner;

public class MenuCasosUso {

    private final MenuPrincipal menuPrincipal;

    public MenuCasosUso(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;  // Recibir el menú principal para volver a él
    }

    public void mostrarMenuCasosUso() {
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equals("0")) {
            System.out.println("\n***************************************");
            System.out.println("              AUTOPARK  ");
            System.out.println("***************************************");
            System.out.println("             MENU CASOS DE USO          ");
            System.out.println("***************************************");
            System.out.println("1. Gestionar Cuenta");
            System.out.println("2. Gestionar Espacio Aparcamiento");
            System.out.println("3. Gestionar Acceso");
            System.out.println("4. Gestionar Cobro");
            System.out.println("0. Salir al Menú Anterior");
            System.out.println("______________________________________");
            System.out.print("Ingrese una opción: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    SubMenuGestionarUsuario subMenuUsuario = new SubMenuGestionarUsuario();
                    subMenuUsuario.gestionarCuenta();
                    break;
                case "2":
                    SubMenuEspacioAparcamiento subMenuEspacio = new SubMenuEspacioAparcamiento();
                    subMenuEspacio.gestionarAparcamiento();
                    break;
                case "3":
                    SubMenuAcceso subMenuAcceso = new SubMenuAcceso();
                    subMenuAcceso.administrarAcceso();
                    break;
                case "4":
                    SubMenuCobro subMenuCobro = new SubMenuCobro();
                    subMenuCobro.gestionarCobro();
                    break;
                case "0":
                    // Salir y volver al menú principal
                    System.out.println("Volviendo al Menú Principal...");
                    menuPrincipal.seleccionarMenu();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
}
