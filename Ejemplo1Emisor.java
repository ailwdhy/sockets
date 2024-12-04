import java.net.*;
import java.io.*;

public class Ejemplo1Emisor {
    
    public static void main(String[] args) {
        if (args.length != 3)
            System.out.println("Este programa requiere 3 argumentos de línea de mandato");
        else {
            try {
                InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
                int puertoReceptor = Integer.parseInt(args[1]);
                String mensaje = args[2];

                DatagramSocket miSocket = new DatagramSocket();
                byte[] almacen = mensaje.getBytes();
                DatagramPacket datagrama =
                    new DatagramPacket(almacen, almacen.length, maquinaReceptora, puertoReceptor);
                miSocket.send(datagrama);
                miSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
