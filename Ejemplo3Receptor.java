import java.net.*;

public class Ejemplo3Receptor {
    
    public static void main(String[] args) {
        if (args.length != 4)
            System.out.println("Este programa requiere 4 argumentos de línea de mandato");
        else {
            try {
                InetAddress maquinaRemitente = InetAddress.getByName(args[0]);
                int puertoRemitente = Integer.parseInt(args[1]);
                int miPuerto = Integer.parseInt(args[2]);
                String mensaje = args[3];

                MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
                miSocket.connect(maquinaRemitente, puertoRemitente);

                for (int i = 0; i < 10; i++)
                    System.out.println(miSocket.recibeMensaje());

                miSocket.enviaMensaje(maquinaRemitente, puertoRemitente, mensaje);

                miSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
