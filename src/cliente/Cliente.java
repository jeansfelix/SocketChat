package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import utils.GerenciadorLog;
import cliente.vista.Tela;

public class Cliente
{
	public static void main(String[] args) throws IOException
	{
		Tela tela = new Tela();
		Socket clienteServidor = new Socket("127.0.0.1", 7777);
		GerenciadorTela gerenciadorFechar = new GerenciadorTela(clienteServidor);
		GerenciadorEnvioMensagem gerenciadorEnvio = new GerenciadorEnvioMensagem(clienteServidor);
		tela.addObserver(gerenciadorFechar);
		tela.addObserver(gerenciadorEnvio);

		System.out.println("[" + GerenciadorLog.obterDataFormatada() + "]" + " Eu me conectei ao servidor!");

		Recebedor recebedor = new Recebedor(clienteServidor, tela);
		new Thread(recebedor).start();

		Scanner scanner = new Scanner(System.in);

		String mensagem = "";

		while (!"#".equals(mensagem))
		{
			PrintStream printStream = new PrintStream(clienteServidor.getOutputStream());

			mensagem = scanner.nextLine();

			printStream.println(mensagem);
		}

		clienteServidor.close();
		scanner.close();
	}
}
