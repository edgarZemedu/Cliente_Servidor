package servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainS {

    public static void main(String[] args) throws IOException {

        //CREACIÓN DE UN SOCKET ASOCIADO A UN PUERTO
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);

        //ESPERANDO CONEXIÓN CON EL CLIENTE
        System.out.println("Esperando conexion ...");
        Socket cliente = servidor.accept();

        //CREACIÓN DE UN FLUJO DE ENTRADA Y DE RECEPCIÓN DE MENSAJE DEL CLIENTE
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoE = new DataInputStream(entrada);
        System.out.println("Cliete: "+flujoE.readUTF());

        //CREACIÓN DE UN FLUJO DE SALIDA Y ENVIO DE MENSAJE AL CLIENTE
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoS = new DataOutputStream(salida);
        String mensajeEnviar = "Saludos, En que te puedo ayudar?";
        System.out.println("Servidor: "+mensajeEnviar);
        flujoS.writeUTF(mensajeEnviar);

        //CIERRE DE STREAMS Y SOCKETS
        entrada.close();
        flujoE.close();
        salida.close();
        flujoS.close();
        cliente.close();
        servidor.close();

    }
}
