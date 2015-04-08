package cliente.vista;

import static eventos.TipoEvento.ENVIAR;
import static eventos.TipoEvento.FECHAR;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import eventos.Evento;
import eventos.TipoEvento;

public class Tela extends Observable
{
	private JFrame tela;
	private String mensagem;
	private JPanel mensagensChat;
	private JPanel envioMensagens;
	private JTextArea viewBox;

	public Tela()
	{
		tela = new JFrame();
		tela.setTitle("Chat");
		tela.setSize(800, 560);
		tela.getContentPane().setLayout(new FlowLayout());
		tela.setResizable(false);

		tela.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				setChanged();
				Evento fechar = new Evento(FECHAR);
				notifyObservers(fechar);
				System.exit(0);
			}
		});

		mensagensChat = new JPanel();
		envioMensagens = new JPanel();

		mensagensChat.setLayout(new FlowLayout());
		mensagensChat.setBackground(new Color(0, 0, 0));

		viewBox = new JTextArea(25, 71);
		viewBox.setEditable(false);
		mensagensChat.add(viewBox);

		envioMensagens.setLayout(new FlowLayout());
		envioMensagens.setBackground(new Color(0, 0, 144));

		final JTextArea sendBox = new JTextArea(6, 64);
		sendBox.setLineWrap(true);
		JScrollPane scrollSendBox = new JScrollPane(sendBox);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setPreferredSize(new Dimension(70, 95));

		ActionListener enviarListener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				setChanged();
				Evento enviar = new Evento(ENVIAR, sendBox.getText());
				notifyObservers(enviar);
				sendBox.setText("");
			}
		};

		btnEnviar.addActionListener(enviarListener);

		envioMensagens.add(scrollSendBox);
		envioMensagens.add(btnEnviar);

		tela.getContentPane().add(mensagensChat);
		tela.getContentPane().add(envioMensagens);

		tela.setVisible(true);
	}

	public JTextArea getViewBox()
	{
		return viewBox;
	}

	public JPanel getMensagensChat()
	{
		return mensagensChat;
	}

	public JPanel getEnvioMensagens()
	{
		return envioMensagens;
	}

	public String getMensagem()
	{
		return mensagem;
	}
}