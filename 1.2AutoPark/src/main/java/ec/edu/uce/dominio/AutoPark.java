package ec.edu.uce.dominio;

import java.util.Arrays;
import java.util.Date;

/**
 * La clase repressenta un sistema de parqueo de autos donde se gestionan usuarios.
 * Permite gestionar la capacidad del parqueo y los usuarios registrados en el sistema.
 */
public class AutoPark {

    private Usuario[] usuarios;
    public EspacioAparcamiento [] espacioAparcamientos;
    public Ticket[] tickets;
    private  int numUsuario;
    private int espacioTotalAparcamiento;
    private int numTicket;
    private int numEspacioAparcamiento;


    /**
     * Constructor vacío que inicializa el arreglo de usuarios vacío y la capacidad total en 0.
     */
    public AutoPark() {
        this.numUsuario = 0;
        this.usuarios = new Usuario[3];
        this.espacioTotalAparcamiento = 0;
        this.espacioAparcamientos = new EspacioAparcamiento[3]; // 10 espacios de ejemplo
        this.tickets = new Ticket[10];
        this.numTicket=0;
        this.numEspacioAparcamiento=0;
        inicializarTickets();
        inicializarUsuarios();
        inicializarEspacios();
    }




    /**
     * Constructor con parámetros para inicializar el arreglo de usuarios y la capacidad total.
     *
     * @param usuarios Arreglo de objetos {@code Usuario} que representan los usuarios registrados.
     * @param espacioTotalAparcamiento total del parqueo.
     */
    public AutoPark(Usuario[] usuarios, int espacioTotalAparcamiento,EspacioAparcamiento [] espacioAparcamientos , Ticket[] tickets, int numTicket, int numEspacioAparcamiento ) {
        this.usuarios = usuarios;
        this.espacioTotalAparcamiento = espacioTotalAparcamiento;
        this.numUsuario =0;
        this.tickets= tickets;
        this.espacioAparcamientos = espacioAparcamientos;
        this.numTicket= numTicket;
        this.numEspacioAparcamiento=numEspacioAparcamiento;
    }

    /**
     * Obtiene el arreglo de usuarios registrados en el parqueo.
     *
     * @return Arreglo de objetosregistrados.
     */
    public Usuario[] getUsuarios() {

        return usuarios;
    }

    /**
     * Establece el arreglo de usuarios registrados en el parqueo.
     * Si el arreglo está vacío o es nulo, se imprime un mensaje de error.
     *
     * @param usuarios Arreglo de objetos  a establecer.
     */
    public void setUsuarios(Usuario[] usuarios) {
        if (usuarios == null || usuarios.length == 0) {
            System.out.println("Error: El arreglo de usuarios no puede estar vacío.");
        } else {
            this.usuarios = usuarios;
        }
    }
    public void setNumUsuario(int numUsuario) {
        this.numUsuario = numUsuario;
    }
    /**
     * Obtiene la capacidad total del parqueo.
     *
     * @return La capacidad total del parqueo.
     */
    public int espacioTotalAparcamiento() {

        return espacioTotalAparcamiento;
    }

    /**
     * Establece la capacidad total del parqueo. Si se intenta establecer un valor negativo,
     * se imprime un mensaje de error.
     *
     * @param espacioTotalAparcamiento La capacidad total a establecer.
     */
    public void setCapacidadTotal(int espacioTotalAparcamiento) {
        if (espacioTotalAparcamiento < 0) {
            System.out.println("Error: La capacidad total no puede ser negativa.");
        } else {
            this.espacioTotalAparcamiento = espacioTotalAparcamiento;
        }
    }

    public EspacioAparcamiento[] getEspacioAparcamientos() {
        return espacioAparcamientos;
    }


    public void setEspacioAparcamientos(EspacioAparcamiento[] espacioAparcamientos) {
        this.espacioAparcamientos = espacioAparcamientos;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public int getNumUsuario() {
        return numUsuario;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public int getNumEspacioAparcamiento() {
        return numEspacioAparcamiento;
    }

    public void setNumEspacioAparcamiento(int numEspacioAparcamiento) {
        this.numEspacioAparcamiento = numEspacioAparcamiento;
    }

    /**
     * metodo para crear un nuevo usuario
     */
    public void crearUsuario(int idUsuario , String nombre , String contrasenia, String correo ) {
    if (numUsuario == usuarios.length){
        Usuario [] aux = usuarios;
        usuarios = new Usuario[aux.length+1];
      System.arraycopy(aux,0,usuarios,0,aux.length);
    }
    usuarios[numUsuario] = new Usuario(idUsuario,nombre,correo,contrasenia);
    numUsuario++;
    }


    /**
     * metodo para modificar un usaurio existente.
     *
     * @return
     */
    public boolean modificarUsuario(int pos, String nombre, String contrasenia, String correo) {
        boolean resp = false;
        if (pos >= 0 && pos < usuarios.length) {
            usuarios[pos] = new Usuario(usuarios[pos].getIdUsuario(), nombre, contrasenia, correo);  // Usamos el id del usuario actual
            resp = true;
        }
        return resp;
    }
    /**
     * metodo para consultar un usuario
     *
     * @return Cadena con la información de todos los usuarios.
     */
    public String consultarUsuario() {
        String texto =" ";
        for (int i = 0 ; i< numUsuario;i++){
            texto+= usuarios [i].toString()+"\r\n";
        }
        return texto;
    }

    /**
     * metodo para elimianr un usuario
     */
    public void eliminarUsuario(int pos) {
        if (pos >=0 && pos < numUsuario){
            Usuario [] aux = usuarios;
            usuarios = new Usuario[aux.length-1];
            if (pos ==0){
                System.arraycopy(aux,1,usuarios,0,usuarios.length);
            } else if (pos == numUsuario - 1) {
                System.arraycopy(aux,0,usuarios,0,usuarios.length);
            } else {
                System.arraycopy(aux,0,usuarios,0,pos);
                System.arraycopy(aux,pos + 1,usuarios,pos,usuarios.length -pos);
            }
            numUsuario--;
        }
    }


    public  void inicializarUsuarios(){
this.crearUsuario(1,"Daniel","Daniel123","daniel@gmail.com");
this.crearUsuario(2,"Domenica","Dome1234","dome@gmail.com");
this.crearUsuario(3,"Luis","luis1234","luis@gmail.com");
    }


    public void inicializarTickets() {
        tickets[0] = new Ticket(1, new Date(), 10.0f, 2.5f, new Date(), "ABC123", "A1");
        tickets[1] = new Ticket(2, new Date(), 12.5f, 2.5f, new Date(), "DEF456", "A2");
        tickets[2] = new Ticket(3, new Date(), 15.0f, 2.5f, new Date(), "GHI789", "A3");
    }


    public void inicializarEspacios() {
        // Verificamos si el arreglo de espacios ha sido inicializado correctamente
        if (espacioAparcamientos != null) {
            // Supongamos que tienes 10 espacios, puedes usar números como "A1", "A2", ..., "A10"
            for (int i = 0; i < espacioAparcamientos.length; i++) {
                String numeroEspacio = "A" + (i + 1); // Crear un número de espacio como A1, A2, ...
                EspacioAparcamiento espacio = new EspacioAparcamiento(numeroEspacio, false); // Estado inicial es libre (false)
                espacioAparcamientos[i] = espacio;  // Asignamos el espacio al arreglo
            }
        } else {
            System.out.println("Error: El arreglo de espacios no está inicializado.");
        }
    }
    /**
     * Obtiene una cadena que contiene el detalle del estado actual del parqueo, incluyendo
     * la capacidad total y la cantidad de usuarios registrados.
     *
     * @return Una cadena con el detalle del parqueo.
     */
    @Override
    public String toString() {
        return "AutoPark { N" +  " \n"+
                "_usuarios= "  + Arrays.toString(usuarios) +
                ", numUsuario=" + numUsuario +
                ", capacidadTotal=" + espacioTotalAparcamiento +
                '}';
    }
}