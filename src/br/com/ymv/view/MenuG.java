package br.com.ymv.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;

import br.com.ymv.cripto.Cesar;
import br.com.ymv.cripto.Cifracao;
import br.com.ymv.cripto.Congruencia;
import br.com.ymv.cripto.Permutacao;
import br.com.ymv.cripto.RSA;
import br.com.ymv.cripto.Transposicao;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

/**
 * 
 * @author yuri.melo
 * @version 1.0
 *
 *
 * Projeto da Disciplina de Seguranï¿½a da informaï¿½ï¿½o 
 * 
 * MenuG ï¿½ uma interface grï¿½fica que realiza 5 tipos de criptografia
 *  1 - rsa
 *  2 - Congruencia - BUG conhecido
 *  3 - Cifraï¿½ï¿½o
 *  4 - Permutaï¿½ï¿½o
 *  5 - Cesar
 *  
 *  Ainda estï¿½ na versï¿½o BETA
 *   
 */
public class MenuG extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RSA rsa = new RSA();
	
	Transposicao tran = new Transposicao();
	Cifracao cif = new Cifracao();
	Permutacao perm = new Permutacao();
	Cesar cesar = new Cesar();
	Congruencia con;// possui Singleton
	
	private JTextField cifChave;
	private JTextField permChave;
	
	//PARA PERMITIR O ENTER
	
	JTextArea rsaTexto; 
	JTextArea rsaArray;
	JSpinner drsaN ,drsaD, crsaE, crsaN;
	JSpinner conN1, conN2;
	JTextArea conTextoClaro;
	JTextArea conTextoCripto;
	boolean conBugVisto = false;
	
	JTextArea cifTextoCripto;
	JTextArea cifTextoClaro;
	
	JTextArea tranTextoClaro;
	JTextArea tranTextoCripto;
	
	JTextArea permTextoClaro;
	JTextArea permTextoCripto;
	
	JTextArea cesarTextoClaro;
	JTextArea cesarTextoCripto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuG frame = new MenuG();
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
	public MenuG() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yuri.melo\\Desktop\\peixe stencil.png"));
		setResizable(false);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Seguran\u00E7a da Informa\u00E7\u00E3o -  Criptografia");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "name_184384018268581");
		
		
		JPanel panelRSA = new JPanel();
		
		tabbedPane.addTab("RSA", null, panelRSA, null);
		panelRSA.setLayout(null);
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(7, 9, 19, 14);
		panelRSA.add(lblE);
		
		
		crsaE = new JSpinner();
		lblE.setLabelFor(crsaE);
		crsaE.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		crsaE.setBounds(45, 6, 70, 20);
		panelRSA.add(crsaE);
		
		JLabel lblN = new JLabel("N");
		lblN.setBounds(186, 9, 18, 14);
		panelRSA.add(lblN);
		
		crsaN = new JSpinner();
		lblN.setLabelFor(crsaN);
		crsaN.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		crsaN.setBounds(214, 6, 70, 20);
		panelRSA.add(crsaN);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(7, 54, 36, 14);
		panelRSA.add(lblTexto);
		
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(7, 102, 417, 1);
		panelRSA.add(horizontalStrut);
		
		JLabel lblD = new JLabel("D");
		lblD.setBounds(9, 105, 34, 14);
		panelRSA.add(lblD);
		
		drsaD = new JSpinner();
		
		drsaD.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		drsaD.setBounds(45, 102, 70, 20);
		panelRSA.add(drsaD);
		
		JLabel lblN_1 = new JLabel("N");
		lblN_1.setBounds(187, 105, 19, 14);
		panelRSA.add(lblN_1);
		
		drsaN = new JSpinner();
		drsaN.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		drsaN.setBounds(214, 102, 70, 20);
		panelRSA.add(drsaN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 140, 250, 60);
		panelRSA.add(scrollPane);
		
		rsaArray = new JTextArea();
		rsaArray.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				executa(1, 2);
			}
		});
		rsaArray.setWrapStyleWord(true);
		rsaArray.setLineWrap(true);
		scrollPane.setViewportView(rsaArray);
		
		JLabel lblArray = new JLabel("Array");
		lblArray.setBounds(9, 152, 34, 14);
		panelRSA.add(lblArray);
		
		rsaTexto = new JTextArea();
		rsaTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				executa(1, 1);
			}
		});
		rsaTexto.setWrapStyleWord(true);
		rsaTexto.setLineWrap(true);
		JButton btnDescritografar = new JButton("Descritografar");
		btnDescritografar.setBounds(320, 177, 121, 23);
		btnDescritografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				String txtClaro = rsa.encontraTc(rsaArray.getText(), (int) drsaD.getValue(), (int) drsaN.getValue(),true);
//				JOptionPane.showMessageDialog(null, txtClaro);
				rsaTexto.setText(txtClaro);
			}
		});
			
		
		JButton button = new JButton("Criptografar");
		button.setBounds(320, 66, 121, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			String txtCript = rsa.encontraC(rsaTexto.getText(), (int) crsaE.getValue(), (int) crsaN.getValue());
//				JOptionPane.showMessageDialog(null, txtCript);
				rsaArray.setText(txtCript);
			}
		});
			
		panelRSA.add(button);
		
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblN_1, lblN, panelRSA, lblE, tabbedPane, lblTexto, button, horizontalStrut, lblD, lblArray, btnDescritografar}));
		panelRSA.add(btnDescritografar);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(7, 211, 420, 1);
		panelRSA.add(horizontalStrut_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(55, 35, 250, 60);
		panelRSA.add(scrollPane_1);
		
	
		scrollPane_1.setViewportView(rsaTexto);
		
		JButton btnCUploadTxt = new JButton("Upload TXT");
		btnCUploadTxt.setEnabled(false);
		btnCUploadTxt.setBounds(320, 35, 121, 20);
		panelRSA.add(btnCUploadTxt);
		
		JButton btnDUploadTxt = new JButton("Upload TXT");
		btnDUploadTxt.setEnabled(false);
		btnDUploadTxt.setBounds(320, 142, 121, 20);
		panelRSA.add(btnDUploadTxt);
		
		JPanel panelCon = new JPanel();
		tabbedPane.addTab("Congruencia", null, panelCon, null);
		panelCon.setLayout(new BoxLayout(panelCon, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panelCon.add(panel);
		panel.setLayout(null);
		
		JLabel lblFormulaFx = new JLabel("Formula: F(x) = n1*x + n2");
		lblFormulaFx.setBounds(10, 11, 158, 26);
		panel.add(lblFormulaFx);
		
		JLabel lblN_2 = new JLabel("n1 :");
		lblN_2.setBounds(10, 48, 35, 17);
		panel.add(lblN_2);
		
		this.conN1 = new JSpinner();
		conN1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "A congruencia contem um bug, se colocar numero par neste campo o resultado da descriptografia sairï¿½ errado!\n"
						+ "Coloque apenas numeros impares atï¿½ que uma nova versï¿½o seja lanï¿½ada.");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!conBugVisto){
					conBugVisto = true;
					JOptionPane.showMessageDialog(null, "A congruencia contem um bug, se colocar numero par neste campo o resultado da descriptografia sairï¿½ errado!\n"
						+ "Coloque apenas numeros impares atï¿½ que uma nova versï¿½o seja lanï¿½ada.");
				}
			}
		});
		
		conN1.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(2)));
		lblN_2.setLabelFor(conN1);
		conN1.setBounds(44, 45, 50, 20);
		panel.add(conN1);
		
		JLabel lblN_3 = new JLabel("n2:");
		lblN_3.setBounds(10, 76, 35, 14);
		panel.add(lblN_3);
		
		this.conN2 = new JSpinner();
		lblN_3.setLabelFor(conN2);
		conN2.setBounds(44, 76, 50, 20);
		panel.add(conN2);
		
		JButton conBtnCriptografar = new JButton("Criptografar");
		conBtnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executa(2, 2);				
			}
		});
		conBtnCriptografar.setBounds(10, 115, 116, 23);
		panel.add(conBtnCriptografar);
		
		JButton conBtnDescritografar = new JButton("Descritografar");
		conBtnDescritografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con = Congruencia.instancia((int) conN1.getValue(), (int) conN2.getValue());
				conTextoClaro.setText(con.deCriptCongruencia(conTextoCripto.getText()));
			}
		});
		conBtnDescritografar.setBounds(10, 162, 121, 23);
		panel.add(conBtnDescritografar);
		
		JLabel lblNewLabel = new JLabel("Texto Claro");
		lblNewLabel.setBounds(160, 11, 151, 14);
		panel.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(144, 0, 5, 222);
		panel.add(verticalStrut);
		
		JLabel lblTextoCritografado = new JLabel("Texto Critografado");
		lblTextoCritografado.setBounds(160, 119, 151, 14);
		panel.add(lblTextoCritografado);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(160, 30, 270, 70);
		panel.add(scrollPane_2);
		
		this.conTextoClaro = new JTextArea();
		scrollPane_2.setViewportView(conTextoClaro);
		conTextoClaro.setWrapStyleWord(true);
		conTextoClaro.setLineWrap(true);
		conTextoClaro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println(e);
//				if(e.equals('\n'))
//					System.out.println("bla");
				executa(2, 2);
			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(160, 140, 270, 70);
		panel.add(scrollPane_3);
		
		this.conTextoCripto = new JTextArea();
		scrollPane_3.setViewportView(conTextoCripto);
		conTextoCripto.setWrapStyleWord(true);
		conTextoCripto.setLineWrap(true);
		conTextoCripto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e);
				if(e.equals('\n'))
					System.out.println("bla");
				executa(2, 1);
			}
		});
		
		JPanel panelCif = new JPanel();
		tabbedPane.addTab("Cifra\u00E7\u00E3o", null, panelCif, null);
		panelCif.setLayout(new BoxLayout(panelCif, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panelCif.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblChave = new JLabel("Chave");
		lblChave.setBounds(10, 30, 45, 20);
		panel_1.add(lblChave);
		
		cifChave = new JTextField();
		cifChave.setBounds(55, 30, 85, 20);
		panel_1.add(cifChave);
		cifChave.setColumns(10);
		
		JLabel lblTextoClaor = new JLabel("Texto Claro");
		lblTextoClaor.setBounds(10, 60, 80, 15);
		panel_1.add(lblTextoClaor);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 80, 425, 50);
		panel_1.add(scrollPane_4);
		
		final JTextArea cifTextoClaro = new JTextArea();
		cifTextoClaro.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				executa(3,1);
//			}
		});
		scrollPane_4.setViewportView(cifTextoClaro);
		cifTextoClaro.setWrapStyleWord(true);
		cifTextoClaro.setLineWrap(true);
		
		JLabel lblTextoCriptografado = new JLabel("Texto Criptografado");
		lblTextoCriptografado.setBounds(10, 140, 140, 15);
		panel_1.add(lblTextoCriptografado);
		
		JButton btnCriptografar = new JButton("Criptografar");
		btnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cifTextoCripto.setText(cif.criptCifracao(cifTextoClaro.getText(), cifChave.getText()));
			}
		});
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 160, 425, 50);
		panel_1.add(scrollPane_5);
		this.tranTextoCripto = new JTextArea();
		this.tranTextoClaro = new JTextArea();
		this.cifTextoCripto = new JTextArea();
		cifTextoCripto.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				executa(3,2);
//			}
		});
		scrollPane_5.setViewportView(cifTextoCripto);
		cifTextoCripto.setLineWrap(true);
		cifTextoCripto.setWrapStyleWord(true);
		btnCriptografar.setBounds(170, 30, 130, 20);
		panel_1.add(btnCriptografar);
		
		JButton btnDescriptografar = new JButton("Descriptografar");
		btnDescriptografar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cifTextoClaro.setText(cif.deCriptCifracao(cifTextoCripto.getText(), cifChave.getText()));
			}
		}	);
		btnDescriptografar.setBounds(320, 30, 130, 20);
		panel_1.add(btnDescriptografar);
		
		JPanel panelTran = new JPanel();
		tabbedPane.addTab("Transposi\u00E7\u00E3o", null, panelTran, null);
		panelTran.setLayout(new BoxLayout(panelTran, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panelTran.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblChave_1 = new JLabel("Chave");
		lblChave_1.setBounds(10, 30, 45, 20);
		panel_2.add(lblChave_1);
		
		final JSpinner tranChave = new JSpinner();
		tranChave.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		tranChave.setBounds(55, 30, 85, 20);
		panel_2.add(tranChave);
		
		JLabel lblTextoClaro = new JLabel("Texto Claro");
		lblTextoClaro.setBounds(10, 61, 80, 15);
		panel_2.add(lblTextoClaro);
		
		final JTextPane tranContTextoClaro = new JTextPane();
		tranContTextoClaro.setForeground(Color.BLACK);
		tranContTextoClaro.setEditable(false);
		tranContTextoClaro.setBounds(437, 120, 25, 20);
		panel_2.add(tranContTextoClaro);
		
		final JTextPane tranContTextoCripto = new JTextPane();
		tranContTextoCripto.setEditable(false);
		tranContTextoCripto.setBounds(437, 190, 25, 20);
		panel_2.add(tranContTextoCripto);
		
		JLabel lblNewLabel_1 = new JLabel("Texto Criptografado");
		lblNewLabel_1.setBounds(10, 140, 140, 15);
		panel_2.add(lblNewLabel_1);
		
		JButton tranBtnCriptografar = new JButton("Criptografar");
		tranBtnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tranTextoCripto.setText(tran.criptTp(tranTextoClaro.getText(), (int) tranChave.getValue()));
			}
		});
		
		tranBtnCriptografar.setBounds(170, 30, 130, 20);
		panel_2.add(tranBtnCriptografar);
		
		JButton tranBtnDescriptografar = new JButton("Descriptografar");
		tranBtnDescriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tranTextoClaro.setText(tran.deCriptTp(tranTextoCripto.getText(), (int) tranChave.getValue()));
			}
		});
		tranBtnDescriptografar.setBounds(320, 30, 130, 20);
		panel_2.add(tranBtnDescriptografar);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 80, 425, 50);
		panel_2.add(scrollPane_6);
		
		
		scrollPane_6.setViewportView(tranTextoClaro);
		tranTextoClaro.addKeyListener(new KeyAdapter() {		
			@Override
			public void keyReleased(KeyEvent e) {
				int qntTextoClaro = tranTextoClaro.getText().length();
				if(e.equals('\b')){
					qntTextoClaro =- 1;
				}
				if(tranTextoClaro.getText().isEmpty())
					tranContTextoClaro.setText("0");
				
				tranContTextoClaro.setText(""+qntTextoClaro);
//				executa(4,1);
				super.keyReleased(e);
			}
		});
		tranTextoClaro.setWrapStyleWord(true);
		tranTextoClaro.setLineWrap(true);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 160, 425, 50);
		panel_2.add(scrollPane_7);
		
		
		scrollPane_7.setViewportView(tranTextoCripto);
		tranTextoCripto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int qntTextoCripto = tranTextoCripto.getText().length();
				if(e.equals('\b')){
					qntTextoCripto =- 1;
				}
				if(tranTextoCripto.getText().isEmpty())
					tranContTextoCripto.setText("0");
				
				tranContTextoCripto.setText(""+qntTextoCripto);
//				executa(4,2);
				super.keyReleased(e);
				
				
			}
		});
		tranTextoCripto.setWrapStyleWord(true);
		tranTextoCripto.setLineWrap(true);
		
		
		
		
		JPanel panelPerm = new JPanel();
		tabbedPane.addTab("Permuta\u00E7\u00E3o", null, panelPerm, null);
		panelPerm.setLayout(new BoxLayout(panelPerm, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panelPerm.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Chave");
		lblNewLabel_2.setBounds(10, 30, 45, 20);
		panel_3.add(lblNewLabel_2);
		
		permChave = new JTextField();
		permChave.setBounds(50, 30, 85, 20);
		panel_3.add(permChave);
		permChave.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Texto Claro");
		lblNewLabel_3.setBounds(10, 60, 80, 15);
		panel_3.add(lblNewLabel_3);
		
		final JTextPane permContTextoClaro = new JTextPane();
		permContTextoClaro.setEditable(false);
		permContTextoClaro.setBounds(437, 120, 25, 20);
		panel_3.add(permContTextoClaro);
		
		final JTextPane permContTextoCripto = new JTextPane();
		permContTextoCripto.setEditable(false);
		permContTextoCripto.setBounds(437, 190, 25, 20);
		panel_3.add(permContTextoCripto);
		
		JLabel lblNewLabel_4 = new JLabel("Texto Criptografado");
		lblNewLabel_4.setBounds(10, 140, 140, 15);
		panel_3.add(lblNewLabel_4);
		
		JButton permBtnCriptografar = new JButton("Criptografar");
		permBtnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				permTextoCripto.setText(perm.criptPMT(permTextoClaro.getText(), permChave.getText()));
			}
		});
		permBtnCriptografar.setBounds(170, 30, 130, 20);
		panel_3.add(permBtnCriptografar);
		
		JButton permBtnDescriptografar = new JButton("Descriptografar");
		permBtnDescriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				permTextoClaro.setText(perm.deCriptPMT(permTextoCripto.getText(), permChave.getText()));
			}
		});
		permBtnDescriptografar.setBounds(320, 30, 130, 20);
		panel_3.add(permBtnDescriptografar);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 80, 425, 50);
		panel_3.add(scrollPane_8);
		
		
		this.permTextoClaro = new JTextArea();
		permTextoClaro.setWrapStyleWord(true);
		permTextoClaro.setLineWrap(true);
		scrollPane_8.setViewportView(permTextoClaro);
		permTextoClaro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int qntTextoClaro = permTextoClaro.getText().length();
				if(e.equals('\b')){
					qntTextoClaro =- 1;
				}
				if(permContTextoClaro.getText().isEmpty())
					permContTextoClaro.setText("0");
				
				permContTextoClaro.setText(""+qntTextoClaro);
//				executa(5,1);
				super.keyReleased(e);
			}
		});
		permTextoClaro.setText("");
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(10, 160, 425, 50);
		panel_3.add(scrollPane_9);
		
		this.permTextoCripto = new JTextArea();
		scrollPane_9.setViewportView(permTextoCripto);
		permTextoCripto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int qntTextoCripto = permTextoCripto.getText().length();
				if(e.equals('\b')){
					qntTextoCripto=- 1;
				}
				if(permTextoCripto.getText().isEmpty())
					permContTextoCripto.setText("0");
				
				permContTextoCripto.setText(""+qntTextoCripto);
//				executa(5,2);
				super.keyReleased(e);
			}
		});
		permTextoCripto.setWrapStyleWord(true);
		permTextoCripto.setLineWrap(true);
		
		
		JPanel panelCesar = new JPanel();
		tabbedPane.addTab("Cesar", null, panelCesar, null);
		panelCesar.setLayout(new BoxLayout(panelCesar, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panelCesar.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Texto Claro");
		lblNewLabel_5.setBounds(10, 45, 80, 15);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Texto Criptografado");
		lblNewLabel_6.setBounds(10, 130, 140, 15);
		panel_4.add(lblNewLabel_6);
		
		JButton cesarBtnCriptografar = new JButton("Criptografar");
		cesarBtnCriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cesarTextoCripto.setText(cesar.criptCS(cesarTextoClaro.getText()));
			}
		});
		cesarBtnCriptografar.setBounds(150, 15, 130, 20);
		panel_4.add(cesarBtnCriptografar);
		
		JButton cesarBtnDescriptografar = new JButton("Descriptografar");
		cesarBtnDescriptografar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cesarTextoClaro.setText(cesar.deCriptCS(cesarTextoCripto.getText()));
			}
		});
		cesarBtnDescriptografar.setBounds(300, 15, 130, 20);
		panel_4.add(cesarBtnDescriptografar);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(10, 65, 445, 60);
		panel_4.add(scrollPane_10);
		
		this.cesarTextoClaro = new JTextArea();
		cesarTextoClaro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			executa(5,1);
			
			}
		});
		scrollPane_10.setViewportView(cesarTextoClaro);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(10, 150, 445, 60);
		panel_4.add(scrollPane_11);
		
		this.cesarTextoCripto = new JTextArea();
		cesarTextoCripto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			executa(5,2);
			}
		});
		cesarTextoCripto.setWrapStyleWord(true);
		cesarTextoCripto.setLineWrap(true);
		scrollPane_11.setViewportView(cesarTextoCripto);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmEncontrarPrimo = new JMenuItem("Encontrar Primo");
		mntmEncontrarPrimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmEncontraPrimo.main(null);;
			}
		});
		mnMenu.add(mntmEncontrarPrimo);
		
		JMenuItem mntmEncontrarInformaoRsa = new JMenuItem("Encontrar Informa\u00E7\u00E3o RSA");
		mntmEncontrarInformaoRsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmEncontraInfoRSA.main(null);
			}
		});
		mnMenu.add(mntmEncontrarInformaoRsa);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		mnConfiguraes.setEnabled(false);
		menuBar.add(mnConfiguraes);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenu mnCriptografias = new JMenu("Criptografias");
		mnCriptografias.setEnabled(false);
		mnAjuda.add(mnCriptografias);
		
		JMenuItem mntmRsa = new JMenuItem("RSA");
		mnCriptografias.add(mntmRsa);
		
		JMenuItem mntmCongruencia = new JMenuItem("Congruencia");
		mnCriptografias.add(mntmCongruencia);
		
		JMenuItem mntmCifrao = new JMenuItem("Cifra\u00E7\u00E3o");
		mnCriptografias.add(mntmCifrao);
		
		JMenuItem mntmPermutao = new JMenuItem("Permuta\u00E7\u00E3o");
		mnCriptografias.add(mntmPermutao);
		
		JMenuItem mntmTransposio = new JMenuItem("Transposi\u00E7\u00E3o");
		mnCriptografias.add(mntmTransposio);
		
		JMenuItem mntmCesar = new JMenuItem("Cesar");
		mnCriptografias.add(mntmCesar);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmSobre.main(null);
			}
		});
		mnAjuda.add(mntmSobre);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		mnAjuda.add(mntmSair);
	}
	
	/**
	 * @author yuri.melo
	 * @param tipoCripto
	 * 			1 - RSA
	 * 			2 - Congruencia
	 * 			3 - Cifraï¿½ï¿½o
	 * 			4 - Permutaï¿½ï¿½o
	 * 			6 - Cesar
	 * @param Campo
	 * 
	 * 
//	 */
//	
	private void executa(int tipoCripto, int campo){
		//TODO implementar metodo preenche
		
		switch (tipoCripto){
		case 1://RSA
			if(campo == 1)
				rsaArray.setText( rsa.encontraC(rsaTexto.getText(),(int) crsaE.getValue(),(int) crsaN.getValue()));
			if(campo == 2)
				rsaTexto.setText(rsa.encontraTc(rsaArray.getText(),(int) drsaD.getValue(),(int) drsaN.getValue(),true));
			break;
		case 2://Congruencias
			con = Congruencia.instancia((int) conN1.getValue(), (int) conN2.getValue());
			if(campo == 1)
				conTextoClaro.setText(con.criptCongruencia(conTextoCripto.getText()));
			if(campo == 2)
				conTextoCripto.setText(con.criptCongruencia(conTextoClaro.getText()));
			break;
//		case 3://Crifração
//			if(cifChave.getText().isEmpty()){
//				cifTextoCripto.setText("Preencha o campo chave");
//				cifTextoClaro.setText("Preencha o campo chave");
//			}else if(campo == 1)
//				cifTextoCripto.setText(cif.criptCifracao(cifTextoClaro.getText(), cifChave.getText()));
//			else if(campo == 2)
//				cifTextoClaro.setText(cif.deCriptCifracao(cifTextoCripto.getText(), cifChave.getText()));
//			break;
//		case 4://Permutação
//			if(campo == 1)
//				permTextoCripto.setText(perm.criptPMT(permTextoClaro.getText(), cifChave.getText()));
//			if(campo == 2)
//				permTextoClaro.setText(perm.deCriptPMT(permTextoCripto.getText(), cifChave.getText()));
//			break;
		case 5://Cesar
			if(campo == 1)
				cesarTextoCripto.setText(cesar.criptCS(cesarTextoClaro.getText()));
			if(campo == 2)
				cesarTextoClaro.setText(cesar.deCriptCS(cesarTextoCripto.getText()));
			break;
		
		}
	}
}
