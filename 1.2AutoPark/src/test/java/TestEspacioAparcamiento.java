import ec.edu.uce.dominio.EspacioAparcamiento;

public class TestEspacioAparcamiento {

    private static EspacioAparcamiento e; // Objeto para realizar las pruebas

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorConParametros();
        testSetNumeroEspacio();
        testSetEstado();
        testAsignarEspacio();
        testLiberarEspacio();
        testCopiarEspacios();
    }

    public static void testConstructorPorDefecto() {
        System.out.println("Prueba del Constructor por Defecto:");
        e = new EspacioAparcamiento(); // Instancia con el constructor por defecto
        System.out.println(e); // Muestra el estado inicial usando el toString
    }

    public static void testConstructorConParametros() {
        System.out.println("\nPrueba del Constructor con Parámetros:");
        e = new EspacioAparcamiento("A2", true); // Instancia con parámetros
        System.out.println(e); // Muestra el estado del espacio
    }

    public static void testSetNumeroEspacio() {
        System.out.println("\nPrueba de setNumeroEspacio:");
        e.setNumeroEspacio("B1"); // Cambia el número de espacio
        System.out.println("Nuevo número de espacio: " + e.getNumeroEspacio());
    }

    public static void testSetEstado() {
        System.out.println("\nPrueba de setEstado:");
        e.setEstado(false); // Cambia el estado a "Libre"
        System.out.println("Estado del espacio: " + (e.getEstado() ? "Ocupado" : "Libre"));
    }

    public static void testAsignarEspacio() {
        System.out.println("\nPrueba de Asignación de Espacio:");
        e.setEstado(true); // Asigna el espacio como "Ocupado"
        System.out.println("Estado después de asignar: " + (e.getEstado() ? "Ocupado" : "Libre"));
        System.out.println("Detalle del espacio: " + e.getDetalle());
    }

    public static void testLiberarEspacio() {
        System.out.println("\nPrueba de Liberar Espacio:");
        e.setEstado(false); // Libera el espacio
        System.out.println("Estado después de liberar: " + (e.getEstado() ? "Ocupado" : "Libre"));
        System.out.println("Detalle del espacio: " + e.getDetalle());
    }

    public static void testCopiarEspacios() {
        System.out.println("\nPrueba de Método copiarEspacios:");

        EspacioAparcamiento[] espaciosOriginales = {
                new EspacioAparcamiento("A1", true),
                new EspacioAparcamiento("A2", false),
                new EspacioAparcamiento("A3", true)
        };

        EspacioAparcamiento[] espaciosCopiados = new EspacioAparcamiento[3];

        // Copiar espacios
        EspacioAparcamiento.copiarEspacios(espaciosOriginales, espaciosCopiados, 3);

        // Imprimir los espacios copiados
        System.out.println("Espacios copiados:");
        for (EspacioAparcamiento espacioCopiado : espaciosCopiados) {
            System.out.println(espacioCopiado);
        }
    }
}
