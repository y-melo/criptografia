package br.com.ymv.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ymv.tools.Primes;


import javax.swing.JTextPane;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrmEncontraPrimo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1941665663317435899L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem menuItem;
	private JButton btnEncontraPrimos;
	private JMenu mnAjuda;
	private JMenuItem mntmSobre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEncontraPrimo frame = new FrmEncontraPrimo();
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
	public FrmEncontraPrimo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		mnMenu.setEnabled(false);
		menuBar.add(mnMenu);
		
		menuItem = new JMenuItem("");
		mnMenu.add(menuItem);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setEnabled(false);
		mnAjuda.add(mntmSobre);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnAjuda.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelEncontraPrimos = new JPanel();
		contentPane.add(panelEncontraPrimos, BorderLayout.CENTER);
		panelEncontraPrimos.setLayout(null);
		
		JLabel lblNumeroInicial = new JLabel("Inicio");
		lblNumeroInicial.setBounds(10, 11, 40, 14);
		panelEncontraPrimos.add(lblNumeroInicial);
		
		JLabel lblNumeroFinal = new JLabel("Final");
		lblNumeroFinal.setBounds(133, 11, 40, 14);
		panelEncontraPrimos.add(lblNumeroFinal);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(100, 99, 6, 20);
		panelEncontraPrimos.add(textPane);
		
		final JSpinner numIni = new JSpinner();
		numIni.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numIni.setBounds(44, 8, 64, 20);
		panelEncontraPrimos.add(numIni);
		
		final JSpinner numFim = new JSpinner();
		numFim.setModel(new SpinnerNumberModel(new Integer(100), new Integer(1), null, new Integer(1)));
		numFim.setBounds(168, 8, 64, 20);
		panelEncontraPrimos.add(numFim);
		
		final JTextArea campoNumerosPrimos = new JTextArea();
		campoNumerosPrimos.setLineWrap(true);
		campoNumerosPrimos.setWrapStyleWord(true);
		campoNumerosPrimos.setRows(1);
		campoNumerosPrimos.setBounds(10, 73, 254, 57);
		panelEncontraPrimos.add(campoNumerosPrimos);
		
		btnEncontraPrimos = new JButton("Encontra Primos");
		btnEncontraPrimos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			
				String numerosPrimos = Primes.calculaPrimo((int) numIni.getValue(), (int) numFim.getValue()).toString();
				campoNumerosPrimos.setText(numerosPrimos);
				
			}
		});
		btnEncontraPrimos.setBounds(10, 39, 147, 23);
		panelEncontraPrimos.add(btnEncontraPrimos);
		
		
		
		
		
		
	}
}
