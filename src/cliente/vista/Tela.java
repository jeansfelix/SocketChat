package cliente.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Tela extends JFrame {

	private String mensagem;
	private JPanel mensagensChat;
	private JPanel envioMensagens;
	private JTextArea viewBox;

	public Tela() {

		this.setTitle("Chat");
		this.setSize(800, 560);
		this.getContentPane().setLayout(new FlowLayout());
		this.setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
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

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mensagem = sendBox.getText();
			}
		};

		btnEnviar.addActionListener(listener);

		envioMensagens.add(scrollSendBox);
		envioMensagens.add(btnEnviar);

		this.getContentPane().add(mensagensChat);
		this.getContentPane().add(envioMensagens);

		this.setVisible(true);
	}

	public JTextArea getViewBox() {
		return viewBox;
	}

	public JPanel getMensagensChat() {
		return mensagensChat;
	}

	public JPanel getEnvioMensagens() {
		return envioMensagens;
	}

	public String getMensagem() {
		return mensagem;
	}

}