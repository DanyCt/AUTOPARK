import ec.edu.uce.dominio.AutoPark;
import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.dominio.EspacioAparcamiento;
import ec.edu.uce.dominio.Ticket;

/**
 *
 * @author usuario
 */
public class TestAutoPark {
    public static void main(String[] args) {
        testConstructorDefecto();
        testConstructorParametros();
        testToString();
        testGetNumUsuario();
        testSetNumUsuario();
        testCrearUsuario();
        testModificarUsuario();
        testConsultarUsuario();
        testEliminarUsuario();
        testUsuariosInicializacion();
        testTicketsInicializacion();
        testEspaciosAparcamientoInicializacion();
    }

    public static void testConstructorDefecto() {
        AutoPark a = new AutoPark();
        System.out.println("-----Test Metodo Constructor Por Defecto----\n");
        System.out.println(a);
    }

    public static void testConstructorParametros() {
        Usuario[] usuarios = {new Usuario(1, "Daniel", "daniel123", "daniel@gmail.com"), new Usuario(2, "Domenica", "dome123", "dome@gmail.com")};
        EspacioAparcamiento[] espacios = new EspacioAparcamiento[10];
        Ticket[] tickets = new Ticket[10];
        AutoPark a = new AutoPark(usuarios, 10, espacios, tickets,1,1);
        System.out.println("\n----Test Metodo Constructor Por Parametros----\n");
        System.out.println(a);
    }

    public static void testToString() {
        AutoPark a = new AutoPark();
        System.out.println("\n----Test To String---\n");
        System.out.println(a);
    }

    public static void testGetNumUsuario() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Get Numero Usuario---\n");
        System.out.println("Num Usuario:" + a.getNumUsuario());
    }

    public static void testSetNumUsuario() {
        AutoPark a = new AutoPark();
        a.setNumUsuario(3);
        System.out.println("\n---Test Set Numero Usuario--\n");
        System.out.println("Num Usuario:" + a.getNumUsuario());
    }

    public static void testCrearUsuario() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método CrearUsuario---\n");
        a.crearUsuario(4, "Carlos", "carlos123", "carlos@gmail.com");
        System.out.println(a.consultarUsuario());
    }

    public static void testModificarUsuario() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método ModificarUsuario---\n");
        a.modificarUsuario(0, "Daniel", "NuevoPass123", "nuevoCorreo@gmail.com");
        System.out.println(a.consultarUsuario());
    }

    public static void testConsultarUsuario() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método ConsultarUsuario---\n");
        System.out.println(a.consultarUsuario());
    }

    public static void testEliminarUsuario() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método EliminarUsuario---\n");
        a.eliminarUsuario(2); // Elimina el primer usuario
        System.out.println(a.consultarUsuario());
    }

    public static void testUsuariosInicializacion() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método UsuariosInicializacion---\n");
        a.inicializarUsuarios();
        System.out.println(a.consultarUsuario());
    }

    public static void testTicketsInicializacion() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método TicketsInicializacion---\n");
        a.inicializarTickets();
        for (Ticket ticket : a.tickets) {
            if (ticket != null) {
                System.out.println(ticket);
            }
        }
    }

    public static void testEspaciosAparcamientoInicializacion() {
        AutoPark a = new AutoPark();
        System.out.println("\n---Test Método EspaciosAparcamientoInicializacion---\n");
        a.inicializarEspacios();
        for (EspacioAparcamiento espacio : a.espacioAparcamientos) {
            System.out.println(espacio);
        }
    }
}
