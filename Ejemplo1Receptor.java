import java.net.*;
import java.io.*;

public class Ejemplo1Receptor {
    
    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Este programa requiere un argumento de línea de mandato.");
        else {
            try {
                int puerto = Integer.parseInt(args[0]);
                final int MAX_LON = 10;

                DatagramSocket miSocket = new DatagramSocket(puerto);
                byte[] almacen = new byte[MAX_LON];
                DatagramPacket datagrama = new DatagramPacket(almacen, MAX_LON);
                miSocket.receive(datagrama);
                String mensaje = new String(almacen);
                System.out.println(mensaje);
                miSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
