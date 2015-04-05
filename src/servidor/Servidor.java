package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            
            String mensagemLida = "";
            
            while (!"#".equals(mensagemLida))
            {
                InputStreamReader reader = new InputStreamReader(cliente.getInputStream());
                BufferedReader leitor = new BufferedReader(reader);
                
                mensagemLida = leitor.readLine();
                
                System.out.println(mensagemLida);
            }
        }

    }

}
