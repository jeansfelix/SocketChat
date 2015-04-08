package eventos;

public class Evento
{
	private TipoEvento tipo;
	private String mensagem;
	
	public Evento(TipoEvento tipo)
	{
		this.tipo = tipo;
	}
	
	public Evento(TipoEvento tipo, String mensagem)
	{
		this(tipo);
		this.mensagem = mensagem;
	}

	public String getMensagem()
	{
		return mensagem;
	}

	public TipoEvento getTipo()
	{
		return tipo;
	}
}
