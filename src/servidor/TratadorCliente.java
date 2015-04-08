package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import utils.GerenciadorLog;

public class TratadorCliente implements Runnable
{
    private Socket cliente;
    
    private static int serial = 0;
    
    private int id;
    
    public TratadorCliente(Socket cliente)
    {
        this.cliente = cliente;
        this.id = ++serial;
    }
    
    @Override
    public void run()
    {
    	try
    	{
    		Servidor.distribuirMensagem("[" + GerenciadorLog.obterDataFormatada() + "]" + " Cliente #" + id + " entrou.");

            String mensagemLida = "";
            while (!"#".equals(mensagemLida))
            {
                InputStreamReader reader;
                
                reader = new InputStreamReader(cliente.getInputStream());
                BufferedReader leitor = new BufferedReader(reader);
                mensagemLida = leitor.readLine();
                
                if(mensagemLida == null)
                {
                	cliente.close();
                	break;
                }
                
                Servidor.distribuirMensagem("[" + GerenciadorLog.obterDataFormatada() + "]" + " Cliente #" + id + ": " + mensagemLida);
            }
    	}
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
