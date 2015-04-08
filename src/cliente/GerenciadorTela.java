package cliente;

import static eventos.TipoEvento.FECHAR;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import eventos.Evento;
import eventos.TipoEvento;

public class GerenciadorTela implements Observer
{
	private Socket clienteServidor;

	public GerenciadorTela(Socket clienteServidor)
	{
		this.clienteServidor = clienteServidor;
	}

	@Override
	public void update(Observable tela, Object object)
	{
		if(object instanceof Evento)
		{
			Evento evento = (Evento) object;
			
			if((evento.getTipo() != FECHAR))
			{
				return;
			}
			
			try
			{
				clienteServidor.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
