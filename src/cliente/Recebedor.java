package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

import cliente.vista.Tela;

public class Recebedor implements Runnable
{
    private Socket clienteServidor;
    private Tela tela;

    public Recebedor(Socket clienteServidor, Tela tela)
    {
        this.clienteServidor = clienteServidor;
        this.tela = tela;
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
                
                tela.getViewBox().append(mensagemLida);
                tela.getViewBox().append("\n");
            }
            catch (SocketException e)
            {
            	return;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
