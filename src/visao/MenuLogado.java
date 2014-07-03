package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuLogado extends JFrame {

	private JPanel contentPane;
	private String nomeUsuario;
	private JLabel lblLogadoCom;
	private VisualizaAcervo v_Acervo;
	private ConcectarPartida conectP;
	private CriarPartida criarP;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLogado frame = new MenuLogado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuLogado() {
		setResizable(false);
		v_Acervo = new VisualizaAcervo();
		v_Acervo.setLocationRelativeTo(this);
		conectP = new ConcectarPartida();
		conectP.setLocationRelativeTo(this);
		criarP = new CriarPartida();
		criarP.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 335);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel.setBounds(16, 56, 503, 209);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnConectarPartida = new JButton("Conectar Partida");
		btnConectarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conectP.setVisible(true);
			}
		});
		btnConectarPartida.setBounds(16, 16, 155, 87);
		panel.add(btnConectarPartida);

		JButton btnNewButton = new JButton("Criar Partida");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarP.setVisible(true);
			}
		});
		btnNewButton.setBounds(175, 16, 152, 87);
		panel.add(btnNewButton);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(456, 16, 0, 87);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(464, 16, 0, 87);
		panel.add(label_3);

		JButton btnVisualisarBaralho = new JButton("Visualisar Baralho");
		btnVisualisarBaralho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualisarBaralho.setBounds(16, 107, 155, 86);
		panel.add(btnVisualisarBaralho);

		JButton btnVisualisarAcervo = new JButton("Visualisar Acervo");
		btnVisualisarAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v_Acervo.setVisible(true);
				v_Acervo.atualizarCarta();
				v_Acervo.setIni();
			}
		});
		btnVisualisarAcervo.setBounds(175, 107, 152, 86);
		panel.add(btnVisualisarAcervo);

		JButton button = new JButton("Editar Baralho");
		button.setBounds(334, 16, 152, 87);
		panel.add(button);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSair.setBounds(334, 107, 152, 86);
		panel.add(btnSair);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(16, 43, 503, 230);
		contentPane.add(panel_1);

		lblLogadoCom = new JLabel("Logado com:");
		lblLogadoCom.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblLogadoCom.setForeground(Color.ORANGE);
		lblLogadoCom.setBackground(Color.DARK_GRAY);
		lblLogadoCom.setBounds(365, 15, 154, 16);
		contentPane.add(lblLogadoCom);

		JLabel lblYugimagic = new JLabel("YugiMagic");
		lblYugimagic.setFont(new Font("Helvetica", Font.BOLD, 18));
		lblYugimagic.setForeground(Color.ORANGE);
		lblYugimagic.setBackground(Color.DARK_GRAY);
		lblYugimagic.setBounds(16, 15, 154, 19);
		contentPane.add(lblYugimagic);
	}

	public void setUser(String user) {
		nomeUsuario = user;
		lblLogadoCom.setText(lblLogadoCom.getText() + nomeUsuario);
	}

	public VisualizaAcervo getV_Acervo() {
		return v_Acervo;
	}
}
