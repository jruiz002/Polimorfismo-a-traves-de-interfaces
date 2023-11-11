public class Reserva {
    // atritbuo que almacena la fecha del vuelo.
    private String fechaVuelo;
    // atributo que almacena el tipo de vuelo.
    private boolean tipoVuelo;
    // atributo que almacena la cantidad de boletos.
    private int cantidadBoletos;
    // atributo que almacena el nombre de la aerolínea.
    private String aerolinea;
    // atributo que almacena el nombre del usuario, perteneciente a esta factura.
    private String username;
    // atributo que almacena el número de tarjeta del cliente.
    private String numeroTarjeta;
    // atributo que almacena las cuotas en las que se pagará la reservación.
    private int cuotas;
    // atributo que almacena la clase de vuelo en donde viajará el cliente.
    private String claseVuelo;
    // atributo que almacena el número de asiento del cliente.
    private String numeroAsiento;
    // atributo que almacena la cantidad de maletas.
    private int cantidadMaletas;

    /**
     * 
     * método que permite crear objetos de tipo reserva.
     * 
     * @param fechaVuelo atritbuo que almacena la fecha del vuelo.
     * @param tipoVuelo atributo que almacena el tipo de vuelo.
     * @param cantidadBoletos atributo que almacena la cantidad de boletos.
     * @param aerolinea atributo que almacena el nombre del usuario, perteneciente a esta factura.
     * @param username atributo que almacena el número de tarjeta del cliente.
     * @param numeroTarjeta atributo que almacena las cuotas en las que se pagará la reservación.
     * @param cuotas atributo que almacena las cuotas en las que se pagará la reservación.
     * @param claseVuelo atributo que almacena la clase de vuelo en donde viajará el cliente.
     * @param numeroAsiento atributo que almacena el número de asiento del cliente.
     * @param cantidadMaletas atributo que almacena la cantidad de maletas.
     */
    public Reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username, String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.username = username;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * 
     * @return método que devuelve la fecha de vuelo.
     */
    public String getFechaVuelo() {
        return this.fechaVuelo;
    }

    /**
     * 
     * método que establece la fecha de vuelo.
     * 
     * @param fechaVuelo atritbuo que almacena la fecha del vuelo.
     */
    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    /**
     * 
     * @return método que devuelve el tipo de vuelo.
     */
    public boolean isTipoVuelo() {
        return this.tipoVuelo;
    }

    /**
     * 
     * @return método que devuelve el tipo de vuelo.
     */
    public boolean getTipoVuelo() {
        return this.tipoVuelo;
    }

    /**
     * 
     * método que establece el tipo de vuelo.
     * 
     * @param tipoVuelo atributo que almacena el tipo de vuelo.
     */
    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    /**
     * 
     * @return método que devuelve la cantidad de boletos.
     */
    public int getCantidadBoletos() {
        return this.cantidadBoletos;
    }

    /**
     * 
     * método que establece la cantidad de boletos.
     * 
     * @param cantidadBoletos atributo que almacena la cantidad de boletos.
     */
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    /**
     * 
     * @return método que devuelve la aerolinea.
     */
    public String getAerolinea() {
        return this.aerolinea;
    }

    /**
     * 
     * método que establece la aerolinea.
     * 
     * @param aerolinea atributo que almacena el nombre de la aerolínea.
     */
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * 
     * @return método que devuelve el username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 
     * método que establece el username.
     * 
     * @param username atributo que almacena el nombre del usuario, perteneciente a esta factura.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return método que devuelve el número de tarjeta.
     */
    public String getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    /**
     * 
     * método que establece el número de tarjeta.
     * 
     * @param numeroTarjeta atributo que almacena el número de tarjeta del cliente.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * 
     * @return método que devuelve el número de cuotas.
     */
    public int getCuotas() {
        return this.cuotas;
    }

    /**
     * 
     * método que establece el número de cuotas.
     * 
     * @param cuotas atributo que almacena las cuotas en las que se pagará la reservación.
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * 
     * @return método que devuelve la clase de vuelo.
     */
    public String getClaseVuelo() {
        return this.claseVuelo;
    }

    /**
     * 
     * método que establece la clase de vuelo.
     * 
     * @param claseVuelo atributo que almacena la clase de vuelo en donde viajará el cliente.
     */
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * 
     * @return método que devuelve el número de asiento.
     */
    public String getNumeroAsiento() {
        return this.numeroAsiento;
    }

    /**
     * 
     * método que establece el número de asiento.
     * 
     * @param numeroAsiento atributo que almacena el número de asiento del cliente.
     */
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * 
     * @return método que devuelve la cantidad de maletas.
     */
    public int getCantidadMaletas() {
        return this.cantidadMaletas;
    }

    /**
     * 
     * método que establece el número de maletas.
     * 
     * @param cantidadMaletas atributo que almacena la cantidad de maletas.
     */
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }


    /**
     * método que retorna la información de la reserva.
     */
    @Override
    public String toString() {
        return "{" +
            " fechaVuelo='" + getFechaVuelo() + "'" +
            ", tipoVuelo='" + isTipoVuelo() + "'" +
            ", cantidadBoletos='" + getCantidadBoletos() + "'" +
            ", aerolinea='" + getAerolinea() + "'" +
            ", numeroTarjeta='" + getNumeroTarjeta() + "'" +
            ", cuotas='" + getCuotas() + "'" +
            ", claseVuelo='" + getClaseVuelo() + "'" +
            ", numeroAsiento='" + getNumeroAsiento() + "'" +
            ", cantidadMaletas='" + getCantidadMaletas() + "'" +
            "}";
    }


}