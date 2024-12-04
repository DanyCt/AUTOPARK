import ec.edu.uce.dominio.Usuario;

public class TestUsuario {

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorParametros();
        testSettersYGetters();
        testToString();
        testCrearUsuario();
        testConsultarUsuario();
        testModificarUsuario();
        testEliminarUsuario();
    }

    // Test del constructor vacío
    public static void testConstructorPorDefecto() {
        Usuario usuario = new Usuario();
        System.out.println("=============== Test Constructor Vacío ===============");
        System.out.println("ID Usuario: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("--------------------------------------------------------");
    }

    // Test del constructor con parámetros
    public static void testConstructorParametros() {
        Usuario usuario = new Usuario(1, "Juan Pérez", "juan@email.com", "contraseña123");
        System.out.println("=============== Test Constructor con Parámetros ===============");
        System.out.println("ID Usuario: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("--------------------------------------------------------");
    }

    // Test de los Setters y Getters
    public static void testSettersYGetters() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2);
        usuario.setNombre("Ana López");
        usuario.setCorreo("ana@email.com");
        usuario.setContrasenia("contraseña456");

        System.out.println("=============== Test Setters y Getters ===============");
        System.out.println("ID Usuario: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("--------------------------------------------------------");
    }

    // Test de toString()
    public static void testToString() {
        Usuario usuario = new Usuario(3, "Carlos García", "carlos@email.com", "contraseña789");
        System.out.println("=============== Test toString() ===============");
        System.out.println(usuario.toString());
        System.out.println("--------------------------------------------------------");
    }

    // Test de Crear Usuario
    public static void testCrearUsuario() {
        Usuario gestor = new Usuario(5);

        System.out.println("=============== Test Crear Usuario ===============");
        boolean creado1 = gestor.crearUsuario(1, "Juan Pérez", "juan@correo.com", "12345");
        boolean creado2 = gestor.crearUsuario(2, "Ana Gómez", "ana@correo.com", "password");
        boolean creado3 = gestor.crearUsuario(3, "Carlos López", "carlos@correo.com", "abc123");

        System.out.println("Creación de usuario 1: " + (creado1 ? "Éxito" : "Error"));
        System.out.println("Creación de usuario 2: " + (creado2 ? "Éxito" : "Error"));
        System.out.println("Creación de usuario 3: " + (creado3 ? "Éxito" : "Error"));
        System.out.println("--------------------------------------------------------");
    }

    // Test de Consultar Usuario
    public static void testConsultarUsuario() {
        Usuario gestor = new Usuario(5);
        gestor.crearUsuario(1, "Juan Pérez", "juan@correo.com", "12345");

        System.out.println("=============== Test Consultar Usuario ===============");
        Usuario usuario = gestor.consultarUsuario(1);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
        System.out.println("--------------------------------------------------------");
    }

    // Test de Modificar Usuario
    public static void testModificarUsuario() {
        Usuario gestor = new Usuario(5);
        gestor.crearUsuario(1, "Juan Pérez", "juan@correo.com", "12345");

        System.out.println("=============== Test Modificar Usuario ===============");
        boolean modificado = gestor.modificarUsuario(1, "Juan Pérez Actualizado", "juan.nuevo@correo.com", "newpass");
        System.out.println("Modificación de usuario con ID 1: " + (modificado ? "Éxito" : "Error"));
        System.out.println("--------------------------------------------------------");
    }

    // Test de Eliminar Usuario
    public static void testEliminarUsuario() {
        Usuario gestor = new Usuario(5);
        gestor.crearUsuario(1, "Juan Pérez", "juan@correo.com", "12345");
        gestor.crearUsuario(2, "Ana Gómez", "ana@correo.com", "password");

        System.out.println("=============== Test Eliminar Usuario ===============");

        // Eliminar usuario con ID 2
        boolean eliminado = gestor.eliminarUsuario(2);
        System.out.println("Eliminación de usuario con ID 2: " + (eliminado ? "Éxito" : "Error"));

        // Intentar eliminar un usuario que no existe
        boolean eliminadoNoExistente = gestor.eliminarUsuario(3);
        System.out.println("Eliminación de usuario con ID 3 (no existente): " + (eliminadoNoExistente ? "Éxito" : "Error"));

        // Mostrar usuarios después de la eliminación
        System.out.println("\nUsuarios después de la eliminación:");
        gestor.mostrarUsuarios();
        System.out.println("--------------------------------------------------------");
    }
}
