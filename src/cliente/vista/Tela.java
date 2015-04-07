package cliente.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Tela extends JFrame {

	private JPanel mensagensChat;
	private JPanel envioMensagens;

	public Tela() {

		this.setTitle("Chat");

		this.setSize(800, 600);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		mensagensChat = new JPanel();
		envioMensagens = new JPanel();

		this.getContentPane().setLayout(new FlowLayout());

		mensagensChat.setLayout(new GridLayout());
		mensagensChat.setBackground(new Color(0, 0, 255));
		mensagensChat.setSize(800, 400);

		envioMensagens.setLayout(new GridLayout(1, 2));
		envioMensagens.setBackground(new Color(200, 200, 200));
		envioMensagens.setSize(800, 200);
		envioMensagens.setBounds(0, 400, 800, 200);

		JTextArea sendBox = new JTextArea();
		JTextArea viewBox = new JTextArea();
		JButton btnEnviar = new JButton();

		btnEnviar.setSize(10, 20);

		mensagensChat.add(viewBox);
		envioMensagens.add(sendBox);
		envioMensagens.add(btnEnviar);
		
		this.getLayeredPane().add(mensagensChat);
		this.getLayeredPane().add(envioMensagens);

		this.setVisible(true);
	}

	public JPanel getMensagensChat() {
		return mensagensChat;
	}

	public JPanel getEnvioMensagens() {
		return envioMensagens;
	}

}