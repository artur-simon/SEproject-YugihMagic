package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
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
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CriarPartida extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarPartida frame = new CriarPartida();
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
	public CriarPartida() {
		setTitle("Criar Partida");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteOIp = new JLabel("Digite o IP e a Porta da partida a ser criada");
		lblDigiteOIp.setBounds(16, 16, 440, 16);
		lblDigiteOIp.setFont(new Font("Helvetica", Font.BOLD, 15));
		lblDigiteOIp.setForeground(Color.ORANGE);
		contentPane.add(lblDigiteOIp);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(16, 50, 202, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		ButtonGroup bg = new ButtonGroup();
		textField = new JTextField();
		rdbtnNewRadioButton_1 = new JRadioButton("IP Local");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(59, 6, 141, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("Outro IP");
		rdbtnNewRadioButton.setBounds(59, 33, 141, 23);
		panel.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);

		textField.setBounds(57, 68, 111, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(19, 74, 61, 16);
		panel.add(lblIp);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(19, 107, 61, 16);
		panel.add(lblPorta);
		
		textField_1 = new JTextField();
		textField_1.setText("4964");
		textField_1.setColumns(10);
		textField_1.setBounds(57, 101, 111, 28);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(230, 134, 31, 3);
		contentPane.add(panel_1);
		
		JButton btnConectar = new JButton("Criar");
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
