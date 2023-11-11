public class Usuario {
    // atributo encargado de almacenar el nombre del usuario.
    private String username;
    // atributo encargado de almacena la contraseña del usuario.
    private String password;
    // atributo que almacena el tipo de usuario en la aplicación.
    private String tipo;


    /**
     * método que permite crear objetos de tipo usuario.
     * 
     * @param username atributo encargado de almacenar el nombre del usuario.
     * @param password atributo encargado de almacena la contraseña del usuario.
     * @param tipo atributo que almacena el tipo de usuario en la aplicación.
     */
    public Usuario(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    /**
     * 
     * @return método que devuelve el nombre de usuario.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 
     * método que establece el nombre de usuario.
     * 
     * @param username atributo encargado de almacenar el nombre del usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * método que devuelve la contraseña.
     * 
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 
     * método que establece la contraseña.
     * 
     * @param password atributo encargado de almacena la contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return método que devuelve el tipo de usuario.
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * 
     * método que establece el tipo de usuario.
     * 
     * @param tipo atributo que almacena el tipo de usuario en la aplicación.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    /**
     * 
     * Método que retorna la información de un usuario.
     * 
     */
    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }


}
