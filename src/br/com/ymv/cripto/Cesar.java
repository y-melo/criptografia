package br.com.ymv.cripto;

import br.com.ymv.tools.StringAdapter;


/**
 *  
 * @author yuri.melo
 * 
 * Criptografia de cesar
 * 
 *  Realiza criptografia e descriptografia de cesar
 *
 */
public class Cesar {

	public String criptCS(String textoClaro) {
		textoClaro = StringAdapter.stringRemover(textoClaro);
		
	StringBuffer txtCript = new StringBuffer();
	for (char l : textoClaro.toCharArray()) {
		int il = charToInt(l);

		il += 3;
		if (il >= 90) {
			il -= 26;
		}
//		System.out.println(l + " " + il);
		txtCript.append(intToChar(il));
	}
	return txtCript.toString().toLowerCase();
	}

	public String deCriptCS(String txtCript) {
	StringBuffer txtClaro = new StringBuffer();
	for (char l : txtCript.toCharArray()) {
		int il = charToInt(l);
		// System.out.println(il);
		il -= 3;
		// System.out.println(il);
		if (il < 65)
			il += 26;

		// System.out.println(il);
		txtClaro.append(intToChar(il));
	}
	return txtClaro.toString().toLowerCase();
	}

	private int charToInt(char letra) {
	String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	int cont = 65;
	for (char l : alfabeto.toCharArray()) {
		// System.out.println("l: " + l + "| letra " + letra);
		if (l == letra) {
			break;
		} else
			cont++;
	}

	return cont;
	}

	private char intToChar(int iLetra) {

	return (char) iLetra;
	}
}
