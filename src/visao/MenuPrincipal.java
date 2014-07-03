package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import modelo.Observado;
import modelo.Observador;
import modelo.SistemaDoJogo;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.awt.Component;
import javax.swing.Box;

public class MenuPrincipal extends JFrame {
	
	private JPanel contentPane;
	private CriarLogin criarLogin;
	private Logar logar;

	private MenuLogado logado;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		setResizable(false);
		
		criarLogin = new CriarLogin();
		criarLogin.setLocationRelativeTo(this);
		logar = new Logar();
		logar.setLocationRelativeTo(this);
		
		logado = new MenuLogado();
		logado.setLocationRelativeTo(this);
		logar.setMenu(logado);
		logar.getPrincipal(this);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 530, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEscolhaUmaDas = new JLabel("Escolha uma das Op\u00E7\u00F5es");
		lblEscolhaUmaDas.setForeground(Color.DARK_GRAY);
		lblEscolhaUmaDas.setFont(new Font("Helvetica", Font.BOLD, 14));
		lblEscolhaUmaDas.setBounds(172, 43, 180, 26);
		contentPane.add(lblEscolhaUmaDas);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(16, 87, 489, 116);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnCriarLogin = new JButton("Criar Login");
		btnCriarLogin.setForeground(SystemColor.inactiveCaptionBorder);
		btnCriarLogin.setBounds(50, 25, 141, 63);
		panel.add(btnCriarLogin);
		btnCriarLogin.setBackground(SystemColor.activeCaption);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar.setVisible(true);
			}
		});
		btnLogar.setForeground(SystemColor.inactiveCaptionBorder);
		btnLogar.setBounds(300, 25, 140, 63);
		panel.add(btnLogar);
		btnLogar.setBackground(SystemColor.activeCaption);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(203, 53, 85, 2);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 25, 1, 63);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(480, 25, 1, 63);
		panel.add(panel_3);
		
		JLabel lblYugihmagic = new JLabel("YugihMagic");
		lblYugihmagic.setForeground(Color.ORANGE);
		lblYugihmagic.setFont(new Font("Helvetica", Font.BOLD, 18));
		lblYugihmagic.setBounds(210, 16, 126, 26);
		contentPane.add(lblYugihmagic);
		btnCriarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				criarLogin.setVisible(true);
			}
		});
	}

	public CriarLogin getCriarLogin() {
		return criarLogin;
	}

	public Logar getLogar() {
		return logar;
	}
}
