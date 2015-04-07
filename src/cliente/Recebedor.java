package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import servidor.Servidor;
import utils.GerenciadorLog;

public class Recebedor implements Runnable
{
    private Socket clienteServidor;

    public Recebedor(Socket clienteServidor)
    {
        this.clienteServidor = clienteServidor;
    }

    @Override
    public void run()
    {
        String mensagemLida = "";
        
        while (!"#".equals(mensagemLida))
        {
            InputStreamReader reader;
            
            try
            {
                reader = new InputStreamReader(clienteServidor.getInputStream());
                BufferedReader leitor = new BufferedReader(reader);
                mensagemLida = leitor.readLine();
                
                if(mensagemLida == null)
                {
                    break;
                }
                
                System.out.println(mensagemLida);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
