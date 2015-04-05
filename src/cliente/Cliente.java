package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente
{

    public static void main(String[] args) throws IOException
    {
        Socket cliente = new Socket("127.0.0.1", 7777);
        System.out.println("O cliente se conectou ao servidor!");

        Scanner scanner = new Scanner(System.in);

        String mensagem = "";

        while (!"#".equals(mensagem))
        {
            PrintStream printStream = new PrintStream(cliente.getOutputStream());

            mensagem = scanner.nextLine();

            printStream.println(mensagem);
        }

        cliente.close();
    }

}
