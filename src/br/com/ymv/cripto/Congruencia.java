package br.com.ymv.cripto;

import br.com.ymv.tools.StringAdapter;

public class Congruencia {
	private String	sobre			= " ";
	private int		multiplodeX		= 0;
	private int		somadorLetra	= 0;
	private static Congruencia instance; 
	private static boolean estaInstanciado = false;

	
	public static Congruencia instancia(int multiplodeX, int somadordeX) {
		if(!estaInstanciado)
			instance = new Congruencia(multiplodeX, somadordeX);
		
		return instance;
	}
	private Congruencia(int multiplodeX, int somadorLetra) {
	
	this.multiplodeX = multiplodeX;

	this.somadorLetra = somadorLetra * (-1);
	}

	public String criptCongruencia(String textoClaro) {
		textoClaro = StringAdapter.stringRemover(textoClaro);
//		System.out.println("------------------Inicio CriptCongruencia--------------------------");
		StringBuffer tCript = new StringBuffer();
	for (char cLetra : textoClaro.toCharArray()) {
		int iLetra = charToInt(cLetra);
		
//		System.out.println("multiplodeX"+this.multiplodeX +"iLetra " + iLetra + "| somador " + somadorLetra );
//		/if(iLetra >= 14 ) iLetra -= 1;
		iLetra = (iLetra * this.multiplodeX) + (somadorLetra * (-1));
		
//		System.out.println("result: "+ iLetra);

		while(iLetra <= 1){
			iLetra += 26;
		}
		while ((iLetra > 26)) {
			iLetra -= 26;
//			System.out.println("iLetraC " + iLetra + "| iL%mult " + (iLetra % this.multiplodeX));
		}
//		System.out.println(iLetra+" | "+intToChar(iLetra));
		tCript.append(intToChar(iLetra));
		
	}
//	System.out.println("------------------Fim CriptCongruencia--------------------------");
	return tCript.toString().toLowerCase();
	}

	public String deCriptCongruencia(String textoCripto) {
		textoCripto= StringAdapter.stringRemover(textoCripto);
//	System.out.println("------------------ Inicio DeCriptCongruencia--------------------------");
	StringBuffer txtCript = new StringBuffer();
	int iLetraCript = 0;
	char letraCript;

	for (char cLetra : textoCripto.toCharArray()) {
		int iLetra = charToInt(cLetra);
//		System.out.println("MultiplodeX:"+this.multiplodeX+ "| iLetra: " + iLetra + "| somador:" + somadorLetra);
//		if(iLetra <= 14) iLetra += 1;
		iLetraCript = (iLetra + this.somadorLetra);
//		System.out.println("Result: "+iLetraCript+" |" );
//		System.out.println("iLetraCript " + iLetraCript);
			
		while (!(iLetraCript % this.multiplodeX == 0)) {
			iLetraCript += 26;
//			System.out.println("iLetraC " + iLetraCript + "| iL%mult " + (iLetraCript % this.multiplodeX));
		}
		
		if (multiplodeX >= 0)
			iLetraCript = iLetraCript / multiplodeX;
		else {
			iLetraCript = iLetraCript / multiplodeX * (-1);
			iLetraCript *= (-1);
			iLetraCript += 26;
		}
		if (iLetraCript > 26)
			iLetraCript -= 26;
		if (iLetraCript < 1)
			iLetraCript += 26;
		letraCript = intToChar(iLetraCript);
		txtCript.append(letraCript);
//		System.out.println("letraC: " + letraCript + " | " + iLetraCript);
	
	}
//	System.out.println("------------------FIM DeCriptCongruencia--------------------------");
	return txtCript.toString().toLowerCase();
	}

	public String Sobre() {

	return this.sobre;
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

	private char intToChar(int iLetra) {
	int aux = 64 + iLetra;
	return (char) aux;
	}

	
}
