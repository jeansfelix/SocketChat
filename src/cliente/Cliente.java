package cliente;

import java.io.IOException;
import java.net.Socket;

public class Cliente
{

    public static void main(String[] args) throws IOException
    {
        Socket cliente = new Socket("127.0.0.1",7777);
        System.out.println("O cliente se conectou ao servidor!");

        cliente.close();
    }

}
