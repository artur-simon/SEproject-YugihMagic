package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import modelo.Observado;
import modelo.Observador;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Logar extends JFrame implements Observado, Observador {
	private MenuLogado menuLog;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JPasswordField textFieldSenha;
	private MenuPrincipal menuprincipal;
	public String nome, senha;
	private List<Observador> observadores;

	public Logar() {
		observadores = new ArrayList<Observador>();
		setTitle("Logar");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(82, 82, 212, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(26, 85, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(26, 130, 46, 14);
		contentPane.add(lblSenha);

		textFieldSenha = new JPasswordField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(82, 127, 212, 20);
		contentPane.add(textFieldSenha);

		JLabel lblParaCriarUma = new JLabel(
				"Digite Seu Login e Senha para logar");
		lblParaCriarUma.setForeground(Color.GRAY);
		lblParaCriarUma.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParaCriarUma.setBounds(26, 20, 322, 26);
		contentPane.add(lblParaCriarUma);

		JButton btnEnviar = new JButton("Logar");
		btnEnviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					nome = textFieldNome.getText();
					senha = textFieldSenha.getText();
					setVisible(false);
					textFieldNome.setText("");
					textFieldSenha.setText("");
					notificarObservador();
				}
			}
		});
		btnEnviar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				nome = textFieldNome.getText();
				senha = textFieldSenha.getText();
				setVisible(false);
				textFieldNome.setText("");
				textFieldSenha.setText("");
				notificarObservador();
			}
		});
		btnEnviar.setForeground(SystemColor.inactiveCaption);
		btnEnviar.setBackground(SystemColor.activeCaption);
		btnEnviar.setBounds(150, 165, 89, 38);
		contentPane.add(btnEnviar);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 57, 338, 157);
		contentPane.add(panel);
		contentPane.getRootPane().setDefaultButton(btnEnviar);
	}

	public void registrarObservador(Observador o) {
		observadores.add(o);

	}

	public void removerObservador(Observador o) {
		int i = observadores.indexOf(o);
		if (i >= 0) {
			observadores.remove(i);
		}
	}

	public void notificarObservador() {
		for (int i = 0; i < observadores.size(); i++) {
			Observador observador = (Observador) observadores.get(i);
			observador.atualizarLogar(this.nome, this.senha);
		}
	}

	public void atualizarCriar(String nome, String senha) {
	}

	public void atualizarLogar(String nome, String senha) {
	}
	public void setMenu(MenuLogado menu){
		menuLog = menu;
	}
	public void getPrincipal(MenuPrincipal menuprincipal){
		this.menuprincipal = menuprincipal;
	}
	public void atualizarLogin(boolean logou, String usuario) {
			if (logou){
			menuLog.setUser(usuario);
			menuLog.setVisible(true);
			menuprincipal.setVisible(false);
			}else
				JOptionPane.showMessageDialog(contentPane,
					"Login ou Senha incorretos");
	}
}
