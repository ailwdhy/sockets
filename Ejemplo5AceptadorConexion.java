import java.net.*;
import java.io.*;

public class Ejemplo5AceptadorConexion {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Este programa requiere dos argumentos de línea de mandato");
        } else {
            try {
                int numPuerto = Integer.parseInt(args[0]);
                String mensaje = args[1];

                ServerSocket socketConexion = new ServerSocket(numPuerto);
                System.out.println("Preparado para aceptar una conexión");

                MiSocketStream socketDatos = new MiSocketStream(socketConexion.accept());
                System.out.println("Conexión aceptada");

                socketDatos.enviaMensaje(mensaje);
                System.out.println("Mensaje enviado");

                socketDatos.close();
                System.out.println("Socket de datos cerrado");
                socketConexion.close();
                System.out.println("Socket de conexión cerrado");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
