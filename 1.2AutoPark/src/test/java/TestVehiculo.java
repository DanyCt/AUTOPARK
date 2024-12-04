import ec.edu.uce.dominio.Vehiculo;

public class TestVehiculo {

    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        //Instancia con el metodo constructor por defecto
        System.out.println("\n===== Probando getters con constructor por defecto: =====");
        System.out.println("Numero de Matricula: "+vehiculo.getNumeroMatricula());
        System.out.println("Tipo de Vehiculo: "+vehiculo.getTipoVehiculo());

        //probar metodo getDetalle con el constructor por defecto
        System.out.println("\n------ Test Constructor por Defecto con el método Detalle: -------");
        System.out.println(vehiculo.toString());

        //Instancia con el metodo constructor por parametros
        Vehiculo vehiculo1= new Vehiculo("XYZ123","Camion");

        System.out.println("\n===== Probando getters con constructor por parametros: =====");
        System.out.println("Numero de Matricula: " +vehiculo1.getNumeroMatricula());
        System.out.println("Tipo de Vehiculo: " +vehiculo1.getTipoVehiculo());

        //probar metodo getDetalle con el constructor por parametros
        System.out.println("\n------ Test Constructor por Parametros con el método Detalle: -------");
        System.out.println(vehiculo1.toString());

        //Probando los metodos set
        System.out.println("\n===== Probando getters =====");
        vehiculo1.setNumeroMatricula("DDD123");
        vehiculo1.setTipoVehiculo("Camion");
        System.out.println(vehiculo1.toString());


    }
}
