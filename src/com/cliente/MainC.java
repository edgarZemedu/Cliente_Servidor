package com.cliente;

import java.io.*;
import java.net.Socket;

public class MainC {

    public static void main(String[] args) throws IOException {

        //CREACIÓN DE UN SOCKET ASOCIADO A UN PUERTO
        String host = "localHost";
        int puerto = 6000;
        Socket cliente = new Socket(host,puerto);

        //CREACIÓN DE UN FLUJO DE SALIDA Y EL ENVIO DEL FLUJO AL SERVIDOR
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoS = new DataOutputStream(salida);
        String mensajeEnvio = "Hola servidor";
        System.out.println("Cliente: "+mensajeEnvio);
        flujoS.writeUTF(mensajeEnvio);

        //CREACIÓN DE UN FLUJO DE ENTRADA Y RECEPTOR DE FLIJO DEL CLIENTE
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoE = new DataInputStream(entrada);
        System.out.println(flujoE.readUTF());

            //cerramos el straems y el sockets
        flujoE.close();
        flujoS.close();
        cliente.close();

    }
}
