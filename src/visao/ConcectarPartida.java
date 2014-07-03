package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class ConcectarPartida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcectarPartida frame = new ConcectarPartida();
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
	public ConcectarPartida() {
		setTitle("Conectar Partida");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteOIp = new JLabel("Digite o IP e a Porta da partida a se conectar");
		lblDigiteOIp.setBounds(16, 16, 440, 16);
		lblDigiteOIp.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblDigiteOIp.setForeground(Color.ORANGE);
		contentPane.add(lblDigiteOIp);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(16, 88, 202, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setText("127.0.0.1");
		textField.setBounds(55, 6, 111, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(17, 12, 61, 16);
		panel.add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(17, 45, 61, 16);
		panel.add(lblPorta);
		
		textField_1 = new JTextField();
		textField_1.setText("4964");
		textField_1.setColumns(10);
		textField_1.setBounds(55, 39, 111, 28);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(230, 134, 31, 3);
		contentPane.add(panel_1);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setBounds(273, 117, 117, 35);
		contentPane.add(btnConectar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(316, 164, 31, 3);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(316, 179, 31, 3);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(316, 103, 31, 3);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(316, 90, 31, 3);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(316, 76, 31, 3);
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(316, 191, 31, 3);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(397, 134, 31, 3);
		contentPane.add(panel_8);
	}
}
