package br.com.ymv.cripto;

import java.util.ArrayList;

import br.com.ymv.tools.StringAdapter;

/**
 * 
 * 
 * Transposição Simples, apenas texto sem espaço e chave compativel metodo de
 * criptogravia começa com cript e o de descriptografia começa com deCript
 * 
 * @author yuri.melo
 * @version 1.0
 * 
 * 
 * 
 */
public class Transposicao {

	/**
	 * 
	 * @param textoClaro
	 *            tipo String esse campo deve-se informar um texto claro sem
	 *            espaço
	 * @param ch
	 *            - Chave
	 * 
	 * @return texto criptografado - String
	 */
	public String criptTp(String textoClaro, int ch) {
		textoClaro = StringAdapter.stringRemover(textoClaro);
	if (!verificaChave(textoClaro, ch)) {
		String chaves = tpChavesPossiveis(textoClaro).toString();
		return "Chave nao é compativel com texto\n As chaves possiveis são:" + chaves;
	}
	if (ch <= 0) {
		ch *= (-1);
	}
	StringBuffer txtCripto = new StringBuffer();

	int count = 0;
	// int linha = 0;
	for (int i = 0; i < textoClaro.length(); i++) {
		for (int j = i; j < textoClaro.length(); j += ch) {
			// System.out.println("count" + count + " |j " + j + " |i " + i + "
			// | " + txtClaro.charAt(j));
			count++;
			txtCripto.append(textoClaro.charAt(j));
		}

		if (count >= textoClaro.length())
			break;
	}

	return txtCripto.toString();

	}

	public String deCriptTp(String textoCript, int ch) {
		textoCript= StringAdapter.stringRemover(textoCript);
	if (!verificaChave(textoCript, ch)) {
		return "Chave nao é compativel com texto";
	}
	if (ch <= 0) {
		ch *= (-1);
	}
	StringBuffer textoClaro = new StringBuffer();

	int count = 0;
	int nlinha = textoCript.length() / ch;
	for (int i = 0; i < textoCript.length(); i++) {
		for (int j = i; j < textoCript.length(); j += nlinha) {
			// System.out.println("count" + count + " |j " + j + " |i " + i + "
			// | " + textoClaro.charAt(j));
			count++;
			textoClaro.append(textoCript.charAt(j));
		}
		if (count >= textoCript.length())
			break;
	}
//	int nLinhas = count + 1;

	return textoClaro.toString();

	}

	// ----------------------------------------------------
	public ArrayList<Integer> tpChavesPossiveis(String textoClaro) {
		textoClaro = StringAdapter.stringRemover(textoClaro);
	ArrayList<Integer> chaves = new ArrayList<>();
	for (int posicaoLetra = 1; posicaoLetra <= textoClaro.length(); posicaoLetra++) {
		if (textoClaro.length() % posicaoLetra == 0)
			chaves.add(posicaoLetra);
	}

	return chaves;
	}

	// ----------------------------------------------------
	private boolean verificaChave(String textoClaro, int ch) {

	if (textoClaro.length() % ch == 0)
		return true;

	return false;
	}

}
