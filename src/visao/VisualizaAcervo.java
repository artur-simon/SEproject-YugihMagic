package visao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JSlider;

import java.awt.FlowLayout;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import modelo.Acervo;
import modelo.AcervoGenerico;
import modelo.Tipo;
import modelo.cartas.Carta;

import java.awt.SystemColor;

import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class VisualizaAcervo extends JFrame {

	private JPanel contentPane;
	private AcervoGenerico acervo;
	private final static String newline = "\n";
	private JTextArea textArea;
	private int cardPos = 0;
	private JSlider slider;
	private JLabel cardNumberDisplay;
	private ImageIcon image1,image2,image3,image4;
	private JLabel monsterLabel,magicLabel,enchantLabel,artefactLabel;
	boolean inicializou = false;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizaAcervo frame = new VisualizaAcervo();
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
	public VisualizaAcervo() {
		setResizable(false);
		setBounds(100, 100, 610, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(6, 18, 598, 277);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(120, 5, 351, 266);
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255,
				215, 0)));
		panel.add(panel_1);
		panel_1.setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(2, 163, 347, 101);
		textArea.setForeground(SystemColor.window);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setEditable(false);
		textArea.setFont(new Font("Helvetica", Font.BOLD, 16));
		panel_1.add(textArea);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(2, 3, 347, 159);
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(42, 70, 1, 100);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(55, 70, 1, 100);
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(68, 70, 1, 100);
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(520, 70, 1, 100);
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(533, 70, 1, 100);
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(546, 70, 1, 100);
		panel.add(panel_10);
		String path = new File("src/imagens/dragonMonster.jpg").getAbsolutePath();
		image1 = new ImageIcon(path);
		path = path = new File("src/imagens/magicBook.jpg").getAbsolutePath();
		image2 = new ImageIcon(path);
		path = path = new File("src/imagens/artefato.jpg").getAbsolutePath();
		image3 = new ImageIcon(path);
		path = path = new File("src/imagens/encantamento.jpg").getAbsolutePath();
		image4 = new ImageIcon(path);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		monsterLabel = new JLabel(image1);
		magicLabel = new JLabel(image2);
		artefactLabel = new JLabel(image3);
		enchantLabel = new JLabel(image4);
		panel_4.add(monsterLabel);
		panel_4.add(magicLabel);
		panel_4.add(artefactLabel);
		panel_4.add(enchantLabel);
		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cardPos > 0) {
					cardPos--;
					atualizarCarta();
				}
			}
		});
		btnNewButton.setBounds(80, 335, 117, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cardPos <acervo.mostrarTodasAsCartas().size()-1) {
					cardPos++;
					atualizarCarta();
				}

			}
		});
		btnNewButton_1.setBounds(409, 335, 117, 29);
		contentPane.add(btnNewButton_1);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(inicializou){
				cardPos = slider.getValue();
				atualizarCarta();
				}
			}
		});
		slider.setMaximum(0);
		slider.setValue(0);
		slider.setBounds(205, 335, 197, 29);
		contentPane.add(slider);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		panel_2.setBounds(290, 310, 25, 21);
		contentPane.add(panel_2);
		
		cardNumberDisplay = new JLabel("0");
		panel_2.add(cardNumberDisplay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(6, 295, 598, 5);
		contentPane.add(panel_3);
		acervo = Acervo.instancia();
	}

	public void atualizarCarta() {
		Carta a = acervo.mostrarTodasAsCartas().get(cardPos);
		//Carta b = acervo.mostrarTodasAsCartas().get(cardPos + 1);
		textArea.setText(newline + a.toString());
		//textArea_1.setText(newline + newline + newline + b.toString());
		slider.setValue(cardPos);
		cardNumberDisplay.setText(cardPos+"");
		setImage(a.retornarTipo());
		
	}
	public void setImage(Tipo tipo){
		switch (tipo) {
		case MONSTRO:
			monsterLabel.setVisible(true);
			magicLabel.setVisible(false);
			artefactLabel.setVisible(false);
			enchantLabel.setVisible(false);
			break;
		case MAGIA:
			monsterLabel.setVisible(false);
			magicLabel.setVisible(true);
			artefactLabel.setVisible(false);
			enchantLabel.setVisible(false);
			break;
		case ENCANTAMENTO:
			monsterLabel.setVisible(false);
			magicLabel.setVisible(false);
			artefactLabel.setVisible(false);
			enchantLabel.setVisible(true);
			break;
		case ATRIBUTO:
			monsterLabel.setVisible(false);
			magicLabel.setVisible(false);
			artefactLabel.setVisible(true);
			enchantLabel.setVisible(false);
			break;
		default:
			break;
		}
	}
	public void setIni(){
		inicializou = true;
		int maxAcervo = (acervo.mostrarTodasAsCartas().size())-1;
		slider.setMaximum(maxAcervo);
		
	}
}
