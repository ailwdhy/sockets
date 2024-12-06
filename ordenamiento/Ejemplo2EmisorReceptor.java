
import java.net.*;
import java.util.Scanner;

public class Ejemplo2EmisorReceptor {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // se solicita la dirección ip y los puertos
            System.out.print("ip del servidor");
            InetAddress maquinaReceptora = InetAddress.getByName(sc.nextLine());
            System.out.print("puerto del servidor");
            int puertoReceptor = sc.nextInt();
            System.out.print("puerto local");
            int miPuerto = sc.nextInt();

            // crear los sockets
            MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);

            // arreglo
            System.out.print("número de filas");
            int filas = sc.nextInt();
            System.out.print("número de columnas");
            int columnas = sc.nextInt();
            int[][] arreglo = new int[filas][columnas];
            System.out.println("introduce los elementos del arreglo:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    arreglo[i][j] = sc.nextInt();
                }
            }

            // enviar el arreglo al servidor
            miSocket.enviaArregloBidimensional(maquinaReceptora, puertoReceptor, arreglo);
            System.out.println("se ha enviado el arreglo al servidor");

            // recibir el arreglo ordenado
            int[][] arregloOrdenado = miSocket.recibeArregloBidimensional();
            System.out.println("arreglo ordenado recibido:");
            for (int[] fila : arregloOrdenado) {
                for (int valor : fila) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }

            miSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
