public interface IReserva {
    public Usuario login(String username, String password);
    public void registroUsuario(String username, String password, String tipo);
    public void cambiarPassword(String nuevaPassword);
    public void cambiarTipoUsuario();
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username);
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas);
    public String itinerario();
    public void leerReserva();
    public void leerUsuario();
    public void guardarReserva();
    public void guardarUsuario();

}
