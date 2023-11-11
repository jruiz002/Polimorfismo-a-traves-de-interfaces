import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * - Clase que posee el método main, lo cual permite ser el archivo de arranque
 * del programa.
 * - Sistema que permite gestionar la reservación y confirmación de boletos.
 * MENU
 * 1. Login
 * 2. Registrarse
 * 3. Salir
 * 
 * SUBMENU
 * 1. Realizar reservación
 * 2. Cambiar tipo usuario.
 * 3. Cambiar constraseña.
 * 4. Salir
 * 
 * - Es importante mencionar, que el programa cuenta con persistencia incluida,
 * asimismo posee método de seguridad lo cuál permite que el usuario ingrese la
 * información de manera correcta y cada uno de los campos que se solicitan.
 * 
 * - DATOS IMPORTANTES:
 *   - Forma de ingresar la fecha 10-11-2023.
 *   - Se valida que no existan nombres de usuario repetidos, ya que cada reservación tiene el nombre de usuario al cuál le pertenece.
 * 
 * - @author Jose Ruiz
 * - @version 0.1
 * - @since 10/11/2023
 */

public class Main {
    public static void main(String[] args) {
        // Variables
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        int opcion = 0;
        Usuario usuario;

        // LINEA A CAMBIAR PARA INTERFAZ
        IReserva iReserva = new Kayac();

        // Se lee el CSV de usuarios y reservaciones
        iReserva.leerUsuario();
        iReserva.leerReserva();

        // Loop que controla el flujo del programa
        while (continueProgram) {
            try {
                Menu();
                opcion = sc.nextInt();
                if (opcion == 1) {
                    // Se solicita la data
                    sc.nextLine();
                    System.out.println("Ingrese el nombre de usuario.");
                    String username = sc.nextLine();
                    System.out.println("Ingrese la contraseña.");
                    String password = sc.nextLine();

                    // Se llama a la funcion de login
                    usuario = iReserva.login(username, password);

                    if (usuario != null) { // Si usuario es distinto de nulo quiere decir que si ingreso la credenciales
                                           // correctas
                        boolean continueSubMenu = true;
                        int opcionSubmenu = 0;
                        // Loop que controla el sub menu
                        while (continueSubMenu) {
                            subMenu();
                            opcionSubmenu = sc.nextInt();
                            if (opcionSubmenu == 1) { // Realizar reservación.
                                // MODO RESERVACIÓN
                                System.out.println("MODO RESERVACIÓN");
                                sc.nextLine();
                                // Se solicita la data para realizar la reservación.
                                System.out.println("Ingrese la fecha de vuelo: ");
                                String fechaVuelo = sc.nextLine();
                                System.out.println("Ingrese el tipo de vuelo: ");
                                System.out.println("1. Ida y vuelta");
                                System.out.println("2. Solo Ida");
                                int opcionTipoVuelo = sc.nextInt();
                                boolean tipoVuelo = false;

                                // Se valida cual es el tipo de vuelo.
                                if (opcionTipoVuelo == 1) {
                                    tipoVuelo = true;
                                } else if (opcionTipoVuelo == 2) {
                                    tipoVuelo = false;
                                }

                                System.out.println("Ingrese la cantidad de boletos:");
                                int cantidadBoletos = sc.nextInt();
                                System.out.println("Ingrese la aerolínea: ");
                                sc.nextLine();
                                String aerolinea = sc.nextLine();

                                // Se hace llamada a la funcion para hacer la reservación.
                                iReserva.reservacion(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea,
                                        usuario.getUsername());

                                // MODO CONFIRMACIÓN
                                System.out.println("MODO CONFIRMACIÓN");
                                System.out.println();
                                System.out.println("Ingrese el número de tarjeta con el que pagará: ");
                                String numeroTarjeta = sc.nextLine();

                                // Se definen las variables en las que variará su información dependiento si es
                                // base o premium
                                int cuotas = 0;
                                String claseVuelo = "";
                                String numeroAsiento = "";
                                int cantidadMaletas = 0;

                                if (usuario.getTipo().equals("Base")) {
                                    // Se solicitan las cuotas
                                    System.out.println("Ingrese el número de cuotas en el que realizará el pago (1 - 24)");
                                    cuotas = sc.nextInt();
                                    if (cuotas>= 0 && cuotas <= 24) {
                                        // Se solicita la clase de vuelo
                                        System.out.println("Seleccione la clase de vuelo:");
                                        System.out.println("1. Coach");
                                        System.out.println("2. Primera clase");
                                        int opcionVuelo = sc.nextInt();
                                        if (opcionVuelo == 1) {
                                            claseVuelo = "Coach";
                                        } else if (opcionVuelo == 2) {
                                            claseVuelo = "Primera clase";
                                        } else {
                                            System.out.println("Opción no válida.");
                                        }
                                        cantidadMaletas = 1;
                                        // Definir letras disponibles
                                        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                                        // Generar letra aleatoria
                                        char letra = letras.charAt(new Random().nextInt(letras.length()));
                                        // Generar número aleatorio entre 1 y 1000
                                        int numero = new Random().nextInt(1000) + 1;
    
                                        numeroAsiento = letra + String.valueOf(numero);
                                    } else {
                                        cuotas = 0;
                                        System.out.println("Número de cuotas no válido.");
                                    }

                                } else if (usuario.getTipo().equals("Premium")) {
                                    cuotas = 0;
                                    claseVuelo = "Primera clase";
                                    System.out.println("Ingrese la cantidad de maletas: ");
                                    cantidadMaletas = sc.nextInt();
                                    System.out.println("Ingrese el número de asiento que desea.");
                                    sc.nextLine();
                                    numeroAsiento = sc.nextLine();
                                }

                                // Se hace llamada a la función de confirmar reserva, la cuál agregará la
                                // reserva.
                                iReserva.confirmacion(numeroTarjeta, cuotas, claseVuelo, numeroAsiento,
                                        cantidadMaletas);

                            } else if (opcionSubmenu == 2) { // Cambiar Tipo usuario
                                if (usuario.getTipo().equals("Base")) {
                                    // Se actualiza el tipo de usuario
                                    iReserva.cambiarTipoUsuario();

                                } else if (usuario.getTipo().equals("Premium")) {
                                    System.out.println("¡Ya eres premium!");
                                }

                            } else if (opcionSubmenu == 3) { // Cambiar constraseña.
                                System.out.println("Ingrese la nueva contraseña: ");
                                sc.nextLine();
                                String nuevaPassword = sc.nextLine();
                                iReserva.cambiarPassword(nuevaPassword);

                            } else if (opcionSubmenu == 4) { // Salir
                                continueSubMenu = false;

                            } else {
                                System.out.println("Opción no válida.");
                            }

                        }

                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }

                } else if (opcion == 2) { // Registrarse
                    // Se solicita la data
                    sc.nextLine();
                    System.out.println("Ingrese el nombre de usuario.");
                    String username = sc.nextLine();
                    System.out.println("Ingrese la contraseña.");
                    String password = sc.nextLine();
                    System.out.println("Seleccione el tipo de cliente. ");
                    System.out.println("1. Base");
                    System.out.println("2. Premium");
                    int opcionTipo = sc.nextInt();
                    String tipo = "";
                    if (opcionTipo == 1) {
                        tipo = "Base";
                    } else if (opcionTipo == 2) {
                        tipo = "Premium";
                    }
                    // Llamada a registro usuario
                    iReserva.registroUsuario(username, password, tipo);
                } else if (opcion == 3) { // Salir
                    System.out.println("Gracias por usar el programa.");
                    continueProgram = false;
                    iReserva.guardarUsuario();
                    iReserva.guardarReserva();
                } else {
                    System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }

        }

    }

    /**
     * Método que muestra la información del Menú
     */
    public static void Menu() {
        System.out.println("-----------Bienvenido-----------");
        System.out.println("1. Login");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
    }

    /**
     * Método que muestra la información del submenú
     */
    public static void subMenu() {
        System.out.println("");
        System.out.println("-----------Sub Menú-----------");
        System.out.println("1. Realizar reservación.");
        System.out.println("2. Cambiar tipo usuario.");
        System.out.println("3. Cambiar constraseña.");
        System.out.println("4. Salir");
    }
}