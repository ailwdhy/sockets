import java.net.*;
import java.io.*;

public class Ejemplo5SolicitanteConexion {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Este programa requiere dos argumentos de línea de mandato");
        } else {
            try {
                String maquinaAceptadora = args[0];
                int puertoAceptador = Integer.parseInt(args[1]);

                MiSocketStream miSocket = new MiSocketStream(maquinaAceptadora, puertoAceptador);
                System.out.println("Solicitud de conexión concedida");

                String mensaje = miSocket.recibeMensaje();
                System.out.println("Mensaje recibido: " + mensaje);

                miSocket.close();
                System.out.println("Socket de datos cerrado");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
