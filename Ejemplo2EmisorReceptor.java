import java.net.*;

public class Ejemplo2EmisorReceptor {
    
    public static void main(String[] args) {
        if (args.length != 4)
            System.out.println("Este programa requiere 4 argumentos de línea de mandato");
        else {
            try {
                InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
                int puertoReceptor = Integer.parseInt(args[1]);
                int miPuerto = Integer.parseInt(args[2]);
                String mensaje = args[3];

                MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
                
                miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
                System.out.println(miSocket.recibeMensaje());
                miSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
