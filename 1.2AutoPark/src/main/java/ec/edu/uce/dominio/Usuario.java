package ec.edu.uce.dominio;

/**
 * La clase representa a un usuario dentro del sistema de parqueo.
 * Contiene información sobre el usuario, como su ID, nombre, correo y contraseña.
 */
public class Usuario {

    private String nombre;
    private int idUsuario;
    private String correo;
    private String contrasenia;
    private Usuario[] usuarios;
    private int cantidadUsuarios;

    /**
     * Constructor vacío que inicializa los atributos con valores predeterminados.
     */
    public Usuario() {
        this.idUsuario = 0;
        this.nombre = null;
        this.correo = null;
        this.contrasenia = null;
    }

    /**
     * Constructor con parámetros para inicializar los atributos del usuario.
     *
     * @param idUsuario El ID del usuario.
     * @param nombre El nombre del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contrasenia La contraseña del usuario.
     */
    public Usuario(int idUsuario, String nombre, String correo, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param idUsuario El ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        if (idUsuario <= 0) {
            System.out.println("Error: El ID del usuario debe ser mayor a cero.");
            return;
        }
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
        } else {
            this.nombre = nombre;
        }
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        if (contrasenia == null || contrasenia.trim().isEmpty()) {
            System.out.println("Error: La contraseña no puede estar vacía.");
        } else {
            this.contrasenia = contrasenia;
        }
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            System.out.println("Error: El correo no puede estar vacío.");
        } else {
            this.correo = correo;
        }
    }

    /**
     * Obtiene una cadena con los detalles del usuario, incluyendo su ID, nombre, correo y contraseña.
     *
     * @return Una cadena con los detalles del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

    /**
     * Constructor que inicializa el arreglo de usuarios con un tamaño fijo.
     */
    public Usuario(int tamanioArreglo) {
        this.usuarios = new Usuario[tamanioArreglo];
        this.cantidadUsuarios = 0;
    }

    /**
     * Crea un nuevo usuario y lo agrega al arreglo.
     *
     * @param idUsuario El ID del usuario.
     * @param nombre El nombre del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return true si el usuario se creó correctamente, false si no hay espacio en el arreglo.
     */
    public boolean crearUsuario(int idUsuario, String nombre, String correo, String contrasenia) {
        if (cantidadUsuarios < usuarios.length) {
            Usuario usuario = new Usuario(idUsuario, nombre, correo, contrasenia);
            usuarios[cantidadUsuarios] = usuario;
            cantidadUsuarios++;
            return true;
        }
        return false; // No hay espacio suficiente
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param idUsuario El ID del usuario.
     * @return El usuario encontrado o null si no existe.
     */
    public Usuario consultarUsuario(int idUsuario) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                return usuarios[i]; // No se modifican los datos, solo se consulta
            }
        }
        return null; // No se encontró el usuario
    }

    /**
     * Modifica los datos de un usuario.
     *
     * @param idUsuario El ID del usuario a modificar.
     * @param nombre El nuevo nombre del usuario.
     * @param correo El nuevo correo del usuario.
     * @param contrasenia La nueva contraseña del usuario.
     * @return true si el usuario fue modificado, false si no se encontró.
     */
    public boolean modificarUsuario(int idUsuario, String nombre, String correo, String contrasenia) {
        Usuario usuario = consultarUsuario(idUsuario);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);
            usuario.setContrasenia(contrasenia);
            return true;
        }
        return false;
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a eliminar.
     * @return true si el usuario fue eliminado, false si no se encontró.
     */
    public boolean eliminarUsuario(int idUsuario) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                // Mover los elementos restantes una posición hacia atrás
                for (int j = i; j < cantidadUsuarios - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuarios[cantidadUsuarios - 1] = null; // Eliminar la última referencia
                cantidadUsuarios--;
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return El arreglo de usuarios.
     */
    public Usuario[] obtenerTodosLosUsuarios() {
        Usuario[] usuariosActivos = new Usuario[cantidadUsuarios];
        System.arraycopy(usuarios, 0, usuariosActivos, 0, cantidadUsuarios);
        return usuariosActivos;
    }

    /**
     * Método para mostrar todos los usuarios en formato de cadena.
     */
    public void mostrarUsuarios() {
        for (int i = 0; i < cantidadUsuarios; i++) {
            System.out.println(usuarios[i]);
        }
    }
}
