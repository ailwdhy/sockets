
import java.net.*;
import java.io.*;

public class MiSocketDatagrama extends DatagramSocket {
    static final int MAX_LON = 1024;

    MiSocketDatagrama(int numPuerto) throws SocketException {
        super(numPuerto);
    }
    public void enviaMensaje(InetAddress maquinaReceptora, int puertoReceptor, String mensaje) throws IOException {
        byte[] almacenEnvio = mensaje.getBytes();
        DatagramPacket datagrama = new DatagramPacket(almacenEnvio, almacenEnvio.length, maquinaReceptora, puertoReceptor);
        this.send(datagrama);
    }

    public String recibeMensaje() throws IOException {
        byte[] almacenRecepcion = new byte[MAX_LON];
        DatagramPacket datagrama = new DatagramPacket(almacenRecepcion, MAX_LON);
        this.receive(datagrama);
        return new String(datagrama.getData()).trim();
    }

    public void enviaArregloBidimensional(InetAddress maquinaReceptora, int puertoReceptor, int[][] arreglo) throws IOException {
        StringBuilder mensaje = new StringBuilder();
        for (int[] fila : arreglo) {
            for (int valor : fila) {
                mensaje.append(valor).append(",");
            }
            mensaje.append(";");
        }
        enviaMensaje(maquinaReceptora, puertoReceptor, mensaje.toString());
    }

    public int[][] recibeArregloBidimensional() throws IOException {
        String mensaje = recibeMensaje();
        String[] filas = mensaje.split(";");
        int[][] arreglo = new int[filas.length][]; 
        for (int i = 0; i < filas.length; i++) {
            String[] valores = filas[i].split(","); 
            arreglo[i] = new int[valores.length];
            for (int j = 0; j < valores.length; j++) {
                arreglo[i][j] = Integer.parseInt(valores[j]); 
            }
        }
        return arreglo;
    }
}
