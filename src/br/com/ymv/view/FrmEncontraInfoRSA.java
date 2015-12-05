package br.com.ymv.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import br.com.ymv.cripto.RSA;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class FrmEncontraInfoRSA extends JFrame {

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
					FrmEncontraInfoRSA frame = new FrmEncontraInfoRSA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setListener(MenuG listener){
	}

	/**
	 * Create the frame.
	 */
	public FrmEncontraInfoRSA() {
		setTitle("Encontra Informa\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 312, 301);
		
		final RSA rsa = new RSA();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		mnAjuda.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblP = new JLabel("P");
		lblP.setBounds(10, 11, 29, 14);
		contentPane.add(lblP);
		
		final JSpinner numP = new JSpinner();
		numP.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		numP.setBounds(40, 8, 60, 20);
		contentPane.add(numP);
		
		JLabel lblQ = new JLabel("Q");
		lblQ.setBounds(10, 36, 29, 14);
		contentPane.add(lblQ);
		
		JLabel lblZ = new JLabel("Z");
		lblZ.setBounds(10, 61, 29, 14);
		contentPane.add(lblZ);
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(10, 85, 21, 14);
		contentPane.add(lblE);
		
		JLabel lblD = new JLabel("D");
		lblD.setBounds(10, 110, 21, 14);
		contentPane.add(lblD);
		
		JLabel lblN = new JLabel("N");
		lblN.setBounds(10, 138, 21, 14);
		contentPane.add(lblN);
		
		final JSpinner numQ = new JSpinner();
		numQ.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		numQ.setBounds(40, 33, 60, 20);
		contentPane.add(numQ);
		
		final JSpinner numZ = new JSpinner();
		numZ.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		numZ.setBounds(40, 58, 60, 20);
		contentPane.add(numZ);
		
		final JSpinner numE = new JSpinner();
		numE.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		numE.setBounds(40, 82, 60, 20);
		contentPane.add(numE);
		
		final JSpinner numD = new JSpinner();
		numD.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		numD.setBounds(40, 107, 60, 20);
		contentPane.add(numD);
		
		final JSpinner numN = new JSpinner();
		numN.setModel(new SpinnerNumberModel(new Integer(-1), new Integer(-1), null, new Integer(1)));
		numN.setBounds(40, 135, 60, 20);
		contentPane.add(numN);

		final JTextArea rEncInfoTipo1 = new JTextArea();
		rEncInfoTipo1.setEditable(false);
		rEncInfoTipo1.setWrapStyleWord(true);
		rEncInfoTipo1.setLineWrap(true);
		rEncInfoTipo1.setBounds(140, 6, 119, 107);
		contentPane.add(rEncInfoTipo1);
		
		final JTextArea rEncInfoTipo2 = new JTextArea();
		rEncInfoTipo2.setEditable(false);
		rEncInfoTipo2.setWrapStyleWord(true);
		rEncInfoTipo2.setLineWrap(true);
		rEncInfoTipo2.setBounds(139, 122, 120, 98);
		contentPane.add(rEncInfoTipo2);

		JButton btnEncontraInformaes = new JButton("Encontrar");
		btnEncontraInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				rsa.setP((int) numP.getValue());
				rsa.setQ((int) numQ.getValue());
				rsa.setZ((int) numZ.getValue());
				rsa.setE((int) numE.getValue());
				rsa.setD((int) numD.getValue());
				rsa.setN((int) numN.getValue());
				
				String rTipo1 = rsa.encontraK1K2(2);
				String rTipo2 = rsa.encontraK1K2(1);
				
				rEncInfoTipo1.setText(rTipo1);
				rEncInfoTipo2.setText(rTipo2);
			}
		});
		btnEncontraInformaes.setBounds(10, 163, 119, 23);
		contentPane.add(btnEncontraInformaes);
		
		JButton btnPreencheRsa = new JButton("Preenche RSA");
		btnPreencheRsa.setEnabled(false);
		btnPreencheRsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			
			}
		});
		btnPreencheRsa.setBounds(11, 197, 118, 23);
		contentPane.add(btnPreencheRsa);
			}
}
