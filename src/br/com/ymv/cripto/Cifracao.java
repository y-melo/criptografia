package br.com.ymv.cripto;

import br.com.ymv.tools.StringAdapter;

public class Cifracao {

	public String criptCifracao(String textoClaro, String chave) {
		textoClaro = StringAdapter.stringRemover(textoClaro);
		if(chaveVazia(chave)) chave = "a";
		chave = StringAdapter.stringRemover(chave);
		
	StringBuffer txtCript = new StringBuffer();
//	int aux = txtClaro.length() / chave.length();
	char[] cchave = chave.toCharArray();
	int j = 0;

	for (char letra : textoClaro.toCharArray()) {
//		System.out.println("J" + j + "| cchavelgh" + cchave.length);
		if (j >= cchave.length)
			j = 0;
		// System.out.println(letra + "|" + cchave[j]);
		int iletraCript = charToInt(letra) + charToInt(cchave[j]);
		// System.out.println(charToInt(letra) + " " + charToInt(cchave[j]) + "
		// " + iletraCript);
		while (iletraCript > 26)
			iletraCript -= 26;
		// System.out.println(iletraCript);
		// System.out.println(intToChar(iletraCript));
		txtCript.append(intToChar(iletraCript));

		j++;
	}
	return txtCript.toString().toLowerCase();
	}

	public String deCriptCifracao(String textoCripto, String chave) {
		textoCripto = StringAdapter.stringRemover(textoCripto);
		if(chaveVazia(chave)) chave = "a";
		chave = StringAdapter.stringRemover(chave);
	StringBuffer txtCript = new StringBuffer();
//	int aux = txtClaro.length() / chave.length();
	char[] cchave = chave.toCharArray();
	int j = 0;

	for (char letra : textoCripto.toCharArray()) {
		if (j >= cchave.length)
			j = 0;
		int iletraCript = charToInt(letra) - charToInt(cchave[j]);
		while (iletraCript <= 0)
			iletraCript += 26;

		txtCript.append(intToChar(iletraCript));

		j++;
	}
	return txtCript.toString().toLowerCase();
	}

	public String encontrarChave(String textoCripto, String textoClaro) {
		textoClaro = StringAdapter.stringRemover(textoClaro);
		textoCripto = StringAdapter.stringRemover(textoCripto);
		
	return deCriptCifracao(textoCripto, textoClaro);
	}

	private int charToInt(char letra) {
	String alfabeto = "abcdefghijklmnopqrstuvwxyz";
	int cont = 1;
	for (char l : alfabeto.toCharArray()) {
		// System.out.println("l: " + l + "| letra " + letra);
		if (l == letra) {
			break;
		} else
			cont++;
	}

	return cont;
	}
	private boolean chaveVazia(String chave){
		if(chave.isEmpty())
			return true;
		
		return false;
	}

	private char intToChar(int iLetra) {
	return (char) (iLetra + 64);
	}
}
