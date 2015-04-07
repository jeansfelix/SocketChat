package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TratadorCliente implements Runnable
{
    private Socket cliente;
    
    private static int serial = 0;
    
    public TratadorCliente(Socket cliente)
    {
        this.cliente = cliente;
        serial++;
    }
    
    @Override
    public void run()
    {
        System.out.println("Recebi o cliente: " + serial);
        
        String mensagemLida = "";
        
        while (!"#".equals(mensagemLida))
        {
            InputStreamReader reader;
            
            try
            {
                reader = new InputStreamReader(cliente.getInputStream());
                BufferedReader leitor = new BufferedReader(reader);
                mensagemLida = leitor.readLine();
                System.out.println(mensagemLida);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
