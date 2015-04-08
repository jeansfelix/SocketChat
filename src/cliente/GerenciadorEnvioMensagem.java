package cliente;

import static eventos.TipoEvento.ENVIAR;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import eventos.Evento;
import eventos.TipoEvento;

public class GerenciadorEnvioMensagem implements Observer
{
	private Socket clienteServidor;

	public GerenciadorEnvioMensagem(Socket clienteServidor)
	{
		this.clienteServidor = clienteServidor;
	}

	@Override
	public void update(Observable tela, Object object)
	{
		if(object instanceof Evento)
		{
			Evento evento = (Evento) object;
			
			if((evento.getTipo() != ENVIAR))
			{
				return;
			}
			
			try
			{
				PrintStream printStream = new PrintStream(clienteServidor.getOutputStream());
				
				printStream.println(evento.getMensagem());
				
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
