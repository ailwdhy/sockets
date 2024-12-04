import java.net.*;
import java.io.*;

public class MiSocketStream extends Socket {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    MiSocketStream(String maquinaAceptadora, int puertoAceptador) throws SocketException, IOException {
        socket = new Socket(maquinaAceptadora, puertoAceptador);
        establecerFlujos();
    }

    MiSocketStream(Socket socket) throws IOException {
        this.socket = socket;
        establecerFlujos();
    }

    private void establecerFlujos() throws IOException {
        InputStream flujoEntrada = socket.getInputStream();
        entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
        OutputStream flujoSalida = socket.getOutputStream();
        salida = new PrintWriter(flujoSalida, true);
    }

    public void enviaMensaje(String mensaje) throws IOException {
        salida.println(mensaje);
        salida.flush();
    }

    public String recibeMensaje() throws IOException {
        return entrada.readLine();
    }

    public void close() throws IOException {
        socket.close();
    }
}
