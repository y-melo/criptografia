package br.com.ymv.cripto;

import java.util.ArrayList;

import br.com.ymv.tools.StringAdapter;

/**
 * 
 * Permutação simples não identifica espaços e chave(p) tem que ser exata,
 * tambem nao faz verificação de chave.
 * 
 * @version 1.0
 * @author yuri.melo
 * 
 */
public class Permutacao {
	
	public String criptPMT(String textoClaro, String p){
		textoClaro = StringAdapter.stringRemover(textoClaro);
		int[] novaChave = verificaPadrao(p);
		return criptPMT(textoClaro, novaChave);
	}
	public String criptPMT(String txtClaro, int[] p) {

	StringBuffer txtCript = new StringBuffer();
	ArrayList<String> txtDividido = new ArrayList<>();
	int qntdDiv = txtClaro.length() / p.length;

	int ini = 0, fim = p.length;
	for (int i = 1; i <= qntdDiv; i++) {
		// System.out.println("ini" + ini + "| fim " + fim);
		txtDividido.add(txtClaro.substring(ini, fim));
		ini += p.length;
		fim += p.length;
	}

	for (String itens : txtDividido) {
		for (int l = 0; l < p.length; l++) {
			// l representa a letra
			try {
				txtCript.append(itens.charAt(p[l] - 1));
			} catch (IndexOutOfBoundsException e) {
				return "Chave incorreta! "
					 + "\n A chave digitada deve ser um divisor da quantidade de letras da sua frase.\n"
					 + "Sua frase tem: " + txtClaro.length()+" caracteres \n"
			 		 + "e sua chave:"+ p.length;
			}
			
		}
	}

	return txtCript.toString();
	}

	public String deCriptPMT(String textoCripto, String p){
		textoCripto= StringAdapter.stringRemover(textoCripto);
		p = StringAdapter.stringRemover(p);
		int[] novaChave = verificaPadrao(p);
		return deCriptPMT(textoCripto, novaChave);
	}
	
	public String deCriptPMT(String txtCripto, int[] p) {

	int[] dp = genDeCriptKey(p);

	StringBuffer txtClaro = new StringBuffer();
	ArrayList<String> txtDividido = new ArrayList<>();
	int qntdDiv = txtCripto.length() / dp.length;

	int ini = 0, fim = dp.length;
	for (int i = 1; i <= qntdDiv; i++) {
		// System.out.println("ini" + ini + "| fim " + fim);
		txtDividido.add(txtCripto.substring(ini, fim));
		ini += dp.length;
		fim += dp.length;
	}

	for (String itens : txtDividido) {
		for (int l = 0; l < dp.length; l++) {
			// l representa a letra
			try{
				txtClaro.append(itens.charAt(dp[l] - 1));
			} catch (IndexOutOfBoundsException e) {
				return "Chave incorreta! "
					 + "\n A chave digitada deve ser um divisor da quantidade de letras da sua frase.\n"
					 + "Sua frase tem: " + txtClaro.length()+" caracteres \n"
			 		 + "e sua chave:"+ p.length;
			}
		}
	}

	return txtClaro.toString();
	}
	
	private int[] verificaPadrao(String chavePMT){
		chavePMT= StringAdapter.stringRemover(chavePMT);
		String arr = chavePMT;
		// Caso digite apenas numeros esse trecho corrige para o padrão
		// [1,2,3,4,5,6]
		if (!arr.startsWith("[")) {
			StringBuffer aux = new StringBuffer();
			int i = 0;
			aux.append("[");
			for (char c : arr.toCharArray()) {
				if (i >= arr.length())
					break;
				aux.append(c + ",");
				i++;
			}
			aux.append("]");
			arr = aux.toString();
		}
		String[] items = arr.replaceAll("\\[", "").replaceAll("\\]", "").split(",");

		int[] results = new int[items.length];

		for (int i = 0; i < items.length; i++) {
			try {
				results[i] = Integer.parseInt(items[i]);
			} catch (NumberFormatException nfe) {
			}
		}
		return results;
	}
	
	private int[] genDeCriptKey(int[] p) {

	int[] dp = new int[p.length];

	int j = 0;
	for (int i = 1; i <= p.length; i++) {

		while (i != p[j]) {
			// System.out.println("WHILE\ni" + i + "|j " + j + "| p[j]" + p[j] +
			// "| AUX" + aux[j]);
			j++;
		}

		dp[i - 1] = j + 1;
		j = 0;

	}

	return dp;
	}
}
