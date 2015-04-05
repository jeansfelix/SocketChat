package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket servidor = new ServerSocket(7777);
        System.out.println("Porta 7777 aberta!");

        while (true)
        {
            Socket cliente = servidor.accept();

            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
        }

    }

}
