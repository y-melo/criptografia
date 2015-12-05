package br.com.ymv.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSobre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSobre frame = new FrmSobre();
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
	public FrmSobre() {
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yuri.melo\\Desktop\\peixe stencil.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText("Segurança da informação - Criptografia\n" + 
						 "Versão: 1.0\nData: 15/11/2015\n"+
						 "Software de criptografia RSA, Congruencua, Transposição, Cifração, Permutação e Cesar.\n\n"+
						 "Autor : Yuri de Melo (YMV)\n"+
						 "contato: vieira.yurim@gmail.com");
		textArea.setBounds(10, 11, 361, 239);
		contentPane.add(textArea);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnSair.setBounds(381, 227, 53, 23);
		contentPane.add(btnSair);
	}
}
