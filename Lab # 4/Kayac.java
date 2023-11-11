import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayac implements IReserva{
    // atributo que almacena la lista de usuario del programa.
    ArrayList<Usuario> listaUsuarios;
    // atributo que almacena la lista de reservaciones del programa.
    ArrayList<Reserva> listaReservas;
    // atributo que almacena el usuario que esta logeado en la aplicación.
    Usuario usuario;
    // atributo que almacena la reserva que se esta realizando en tiempo real.
    Reserva reserva;

    /**
     * método que permite crear instancias de tipo kayac.
     */
    public Kayac(){
        listaUsuarios = new ArrayList<Usuario>();
        listaReservas = new ArrayList<Reserva>();   
        usuario = new Usuario("", "", "");
        reserva = new Reserva("", false, 0, "", "", "", 0, "", "", 0);
    }

    /**
     * Método que sirve para logearse en la aplicación.
     */
    @Override
    public Usuario login(String username, String password) {
        usuario = null;
        for (Usuario usuarioLista : listaUsuarios) {
            if (usuarioLista.getUsername().equals(username) && usuarioLista.getPassword().equals(password)){
                usuario = usuarioLista;
            }
        }
        return usuario;
    }

    /**
     * Método que registra un usuario en la aplicación.
     */
    @Override
    public void registroUsuario(String username, String password, String tipo) {
        boolean bandera = false;
        Usuario usuario = new Usuario(username, password, tipo);
        for (Usuario usuarioLista : listaUsuarios) {
            if (usuarioLista.getUsername().equals(username)){
                bandera = true;
            }
        }
        if (bandera){
            System.out.println("¡Nombre de usuario ya existente, elije otro!");
        }else {
            listaUsuarios.add(usuario);
            System.out.println("Usuario agregado exitosamente.");
            System.out.println();
        }
    }

    /**
     * Método que sirve para cambiar la contraseña del usuario.
     */
    @Override
    public void cambiarPassword(String nuevaPassword) {
        for (Usuario usuarioLista : listaUsuarios) {
            if (usuarioLista == usuario){
                usuarioLista.setPassword(nuevaPassword);
            }
        }
    }

    /**
     * Método que sirve para cambair el tipo de usuario
     */
    @Override
    public void cambiarTipoUsuario() {
        for (Usuario usuarioLista : listaUsuarios) {
            if (usuarioLista == usuario){
                usuarioLista.setTipo("Premium");
            }
        }
        System.out.println("Cambio de tipo de usuario exitoso.");
    }

    /**
     * Método que establcece la reservación del vuelo
     */
    @Override
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username) {
        Scanner sc = new Scanner(System.in);
        reserva.setFechaVuelo(fechaVuelo);
        reserva.setTipoVuelo(tipoVuelo);
        reserva.setCantidadBoletos(cantidadBoletos);
        reserva.setAerolinea(aerolinea);
        reserva.setUsername(username);
        System.out.println();
        System.out.println("INFORMACIÓN RESERVA:");
        System.out.println("- Fecha de vuelo: " + fechaVuelo);
        String tipo = "";
        if (tipoVuelo){
            tipo = "Ida y Vuelta";
        }else{
            tipo = "Ida";
        }
        System.out.println("¿Desea aplicar un cupón del 10%?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int cupon = sc.nextInt();
        String answer = "";
        if (cupon == 1){
            answer = "Si";
        } else if (cupon == 2){
            answer = "No";
        }

        System.out.println("- Tipo de Vuelo: " + tipo);
        System.out.println("- Cantidad de Boletos: " + cantidadBoletos);
        System.out.println("- Aerolinea: " + aerolinea);
        System.out.println("- Cupón aplicado: " + answer);
        System.out.println();
    }

    /**
     * Método que realiza la confirmación del vuelo
     */
    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
        reserva.setNumeroTarjeta(numeroTarjeta);
        reserva.setCuotas(cuotas);
        reserva.setClaseVuelo(claseVuelo);
        reserva.setNumeroAsiento(numeroAsiento);
        reserva.setCantidadMaletas(cantidadMaletas);
        System.out.println();
        System.out.println("INFORMACIÓN CONFIRMACIÓN:");
        System.out.println("- Numero tarjeta: " + numeroTarjeta);
        System.out.println("- Cuotas: " + cuotas);
        System.out.println("- Clase de Vuelo: " + claseVuelo);
        System.out.println("- Número de Asiento: " + numeroAsiento);
        System.out.println("- Cantidad Maletas: " + cantidadMaletas);

        // Se agrega la reserva a la lista
        listaReservas.add(reserva);
        System.out.println("Itinerario completo de la reserva: ");
        System.out.println(itinerario());
        System.out.println();
    }

    /**
     * Método que muestra la reserva completa
     */
    @Override
    public String itinerario() {
        return reserva.toString();
    }

    
    /*
    Método encargado de cargar la data del archivo CSV a la lista de usuarios
    */
    @Override
    public void leerUsuario() {
        try {
            // Creación del BufferedReader, el cuál permitirá leer el archivo indicado
            BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"));
            String linea;
            boolean primeraLinea = true; // Para saltar la línea de encabezado
            
            // Loop donde se recorrerá la archivo CSV y se cargará la data
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Se salta la línea de encabezado
                }
                
                String[] partes = linea.split(";");
                
                if (partes.length == 3) { // 3 Columnas en el CSV
                    // Se crea la instancia de tiipo usuario
                    Usuario usuario = new Usuario("", "", "");
                    
                    
                    // Se setenan los campos al usuario creado del CSV
                    usuario.setUsername(partes[0]);
                    usuario.setPassword(partes[1]);
                    usuario.setTipo(partes[2]);
                    
                    // Se agrega el usuario a la lista
                    listaUsuarios.add(usuario);
                    
                }else {
                    System.out.println("Error al leer línea: " + linea);
                }
            }
            
        } catch (Exception e) {
            System.out.println("¡Archico usuarios.csv se encuentra vacío!");
        }
    }
    
    /**
     * Método encargado de almacenar un usuario en el csv.
     */
    @Override
    public void guardarUsuario() {
        String archivo = "usuarios.csv";
        // Se crea el archivo CSV
        File fichero = new File(archivo);
        
        try {
            // Creación del BufferedReader, el cuál permitirá escribir en el archivo indicado
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            
            // Si el archivo esta vacío se crea su encabezado
            if (fichero.length() == 0){
                // Escribe las líneas en el archivo CSV
                bw.write("username;password;tipo"); // Encabezado
                bw.newLine(); // Nueva línea
            }
            
            for (Usuario usuario : listaUsuarios){
                // Se crea el String a ingregar en el CSV
                String lineaUsuario = usuario.getUsername() + ";" + usuario.getPassword() + ";" + usuario.getTipo();
                // Se escribe en el archivo CSV
                bw.write(lineaUsuario);
                bw.newLine(); 
            }
            
            // Se cierra el BufferedWriter
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     Método encargado de cargar la data del archivo CSV a la lista de reservaciones
    */
    @Override
    public void leerReserva() {
        try {
            // Creación del BufferedReader, el cuál permitirá leer el archivo indicado
            BufferedReader br = new BufferedReader(new FileReader("reservaciones.csv"));
            String linea;
            boolean primeraLinea = true; // Para saltar la línea de encabezado
            
            // Loop donde se recorrerá la archivo CSV y se cargará la data
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Se salta la línea de encabezado
                }
                
                String[] partes = linea.split(";");
                
                if (partes.length == 10) { // 10 Columnas en el CSV
                    // Se crea la instancia de tipo reserva
                    Reserva reserva = new Reserva("", false, 0, "", "", "", 0, "", "", 0);
                    
                    // Se setenan los campos a la reserva creado del CSV
                    reserva.setFechaVuelo(partes[0]);
                    reserva.setTipoVuelo(Boolean.parseBoolean(partes[1]));
                    reserva.setCantidadBoletos(Integer.parseInt(partes[2]));
                    reserva.setAerolinea(partes[3]);  
                    reserva.setUsername(partes[4]);
                    reserva.setNumeroTarjeta(partes[5]);  
                    reserva.setCuotas(Integer.parseInt(partes[6]));
                    reserva.setClaseVuelo(partes[7]); 
                    reserva.setNumeroAsiento(partes[8]);
                    reserva.setCantidadMaletas(Integer.parseInt(partes[9]));            
                    
                    // Se agrega el usuario a la lista
                    listaReservas.add(reserva);
                    
                }else {
                    System.out.println("Error al leer línea: " + linea);
                }
            }
        } catch (Exception e) {
            System.out.println("¡Archico reservaciones.csv se encuentra vacío!");
        }
    }

    /**
     * Método que sirve para almacenar la reserva.
     */
    @Override
    public void guardarReserva() {
        String archivo = "reservaciones.csv";
        // Se crea el archivo CSV
        File fichero = new File(archivo);
        
        try {
            // Creación del BufferedReader, el cuál permitirá escribir en el archivo indicado
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            
            // Si el archivo esta vacío se crea su encabezado
            if (fichero.length() == 0){
                // Escribe las líneas en el archivo CSV
                bw.write("fechaVuelo;tipoVuelo;cantidadBoletos;aerolinea;username;numeroTarjeta;cuotas;claseVuelo;numeroAsiento;cantidadMaletas"); // Encabezado
                bw.newLine(); // Nueva línea
            }
            
            for (Reserva reserva : listaReservas){
                // Se crea el String a ingregar en el CSV
                String lineaReserva = reserva.getFechaVuelo() + ";" + reserva.getTipoVuelo() + ";" + String.valueOf(reserva.getCantidadBoletos()) + ";" + reserva.getAerolinea() + ";" +
                                reserva.getUsername() + ";" + reserva.getNumeroTarjeta() + ";" + String.valueOf(reserva.getCuotas()) + ";" + reserva.getClaseVuelo() + ";" +
                                String.valueOf(reserva.getNumeroAsiento()) + ";" + String.valueOf(reserva.getCantidadMaletas());

                // Se escribe en el archivo CSV
                bw.write(lineaReserva);
                bw.newLine(); 
            }
            
            // Se cierra el BufferedWriter
            bw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
