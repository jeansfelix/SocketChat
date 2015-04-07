package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import utils.GerenciadorLog;

public class Servidor
{
    private static final int PORTA_CHAT = 7777;
    private static List<Socket> clientes = new ArrayList<Socket>();
    
    public static void main(String[] args) throws IOException
    {
        ServerSocket servidor = new ServerSocket(PORTA_CHAT);
        System.out.println("[" + GerenciadorLog.obterDataFormatada() + "]" + " Servidor startado. Escutando a porta: " + PORTA_CHAT);

        while (true)
        {
            Socket servidorCliente = servidor.accept();
            clientes.add(servidorCliente);

            TratadorCliente tratadorCliente = new TratadorCliente(servidorCliente);
            new Thread(tratadorCliente).start();
        }
    }
    
    public synchronized static void distribuirMensagem(String mensagem) throws IOException
    {
        PrintStream printStream;
        
        System.out.println(mensagem);
        
        for (Socket cliente : clientes)
        {
            printStream = new PrintStream(cliente.getOutputStream());
            printStream.println(mensagem);
        }
    }
}
