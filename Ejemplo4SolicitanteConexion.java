import java.net.*;
import java.io.*;

public class Ejemplo4SolicitanteConexion {

    public static void main(String[] args) {
        if (args.length != 2)
            System.out.println("Este programa requiere dos argumentos de línea de mandato");
        else {
            try {
                InetAddress maquinaAceptadora = InetAddress.getByName(args[0]);
                int puertoAceptador = Integer.parseInt(args[1]);

                Socket miSocket = new Socket(maquinaAceptadora, puertoAceptador);
                System.out.println("Solicitud de conexión concedida");

                InputStream flujoEntrada = miSocket.getInputStream();
                BufferedReader socketInput =
                    new BufferedReader(new InputStreamReader(flujoEntrada));

                System.out.println("Esperando leer");
                String mensajeRecibido = socketInput.readLine();
                System.out.println("Mensaje recibido: " + mensajeRecibido);

                miSocket.close();
                System.out.println("Socket de datos cerrado");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
