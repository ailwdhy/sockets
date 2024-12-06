
import java.net.*;
import java.util.Arrays;

public class Ejemplo2ReceptorEmisor {

    public static void main(String[] args) {
        try {
            // Inicializar el socket en el puerto especificado
            int miPuerto = 5000; // Puerto del servidor
            MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);

            System.out.println("servidor esperando arreglo...");

            // Recibir el arreglo bidimensional
            int[][] arreglo = miSocket.recibeArregloBidimensional();
            System.out.println("arreglo recibido:");

            for (int[] fila : arreglo) {
                for (int valor : fila) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }

            // Ordenar el arreglo
            arreglo = ordenarArregloBidimensional(arreglo);
            System.out.println("arreglo ordenado:");

            for (int[] fila : arreglo) {
                for (int valor : fila) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }

            // Enviar el arreglo ordenado al cliente
            InetAddress cliente = InetAddress.getByName("localhost"); // Dirección del cliente
            int puertoCliente = 6000; // Puerto del cliente
            miSocket.enviaArregloBidimensional(cliente, puertoCliente, arreglo);

            // Cerrar el socket
            miSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método para ordenar el arreglo bidimensional
    public static int[][] ordenarArregloBidimensional(int[][] arreglo) {
        int[] temporal = Arrays.stream(arreglo).flatMapToInt(Arrays::stream).toArray();
        Arrays.sort(temporal);
        int filas = arreglo.length;
        int columnas = arreglo[0].length;
        int[][] ordenado = new int[filas][columnas];
        for (int i = 0, k = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++, k++) {
                ordenado[i][j] = temporal[k];
            }
        }
        return ordenado;
    }
}
