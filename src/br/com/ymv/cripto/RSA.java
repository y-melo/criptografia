package br.com.ymv.cripto;

import java.math.BigInteger;
import java.util.ArrayList;

import br.com.ymv.tools.Primes;
import br.com.ymv.tools.StringAdapter;

public class RSA {

	private int n=-1;
	private int d=-1;
	private int e=-1;
	private int z=-1;
	private int p=-10;
	private int q=-10;
	

	public int encontraZ(int p, int q){
		//FORMULA Z = (P-1) * (Q-1)
		int z=0;
		if(q == -10 || p == -10 ){
			return -1;			
		}
		z = (p-1) * (q-1);
		this.z = z;
		return z;
	}
	public int encontraPQ(int z, int p, int q, int n){
		// se n for informado ele executa faz o calculo com base
		// na formula N = P * Q
		if(n != -1){
			// se o P for informado entao ele quer descobrir o Q
			if(p != -10){
				q = n/p; // Calcula o valor de q
				this.q = q;
				return q;
			}else
			// se o Q for informado entao ele quer descobrir o P
			if(q != -10){
				p = n/q; // Calcula o P
				this.p =p;
				return p;
			}
				// SE P e Q valem -1 nao é possivel fazer a conta
				// com a formula N = p*q
		}else
			// Formula Z = (P-1) * (Q-1)
			if(z != -1){
				// se o P for informado entao ele quer descobrir o Q
				// z = (p-1)*( q-1);
				// z = (p-1)*q - (p-1);
				// (p-1)*q = z+(p-1);
				// q = z+(p-1)/(p-1)
				if(p != -10){
//					System.out.println(q+ "=" + (z+(p-1))/(p-1));
					q = (z+(p-1))/(p-1);
//					System.out.println(q);
					
					this.q = q;
					return q;
				}else
				// se o Q for informado entao ele quer descobrir o P
					// z = (p-1)*( q-1);
					// z = (q-1)*p - (q-1);
					// (q-1)*p = z+(q-1);
					// p = z+(q-1)/(q-1)
					if(p != -10){
						p = (z+(q-1))/(q-1); //calcula o P
					this.p = p;
					return p;
				}
					// SE P e Q valem -1 nao é possivel fazer a conta
					// com a formula Z = (P-1)*(Q-1)
			}
		
		
		return -1;		
	}
	public int encontraN(int p, int q){
		// FORMULA N = P*Q
		int n= -1;
		//se p ou q forem -10 nao é possivel fazer conta
		if(p == -10 || q == -10)
			return -1;
		
		n = p*q;
//		System.out.println(n +" |" +p+ " |"+ q);
		this.n = n;
		
		return n;
	}
	public int encontraED(int e, int d, int z){
		//TENTA CALCULAR Z caso seja 0
		if(z == -1){
			this.z= encontraZ(this.p, this.q);
		}
		//FORMULA E*D = 1 [Z]
		int x=1;
		//Calcula E
		if(d != -1){
			while( ((1+x*z)%d) != 0 ){
				x++;
//				System.out.println("98 | x: "+x);
			}//fim while
			if(((1+x*z)%d) == 0 ){
				e = ((1+x*z)/d);
				this.e = e;
				return e;
			}// fim if
		} // fim if
		
		if(e != -1){
			
			while( ((1+x*z)%e) != 0 ){
				x++;
//				System.out.println( "d = 1 + "+ x +" * "+z+"/"+e+" = "+ ((1+x*z)/e) );
//				System.out.println("110 | x: "+x);
			}//fim while
			if(((1+x*z)%e) == 0 ){
				d = ((1+x*z)/e);
				this.d = d;
				return d;
			}// fim if
		} // fim if
		
		return -1;
	}
	public int encontraTc(int c, int d, int n){
		BigInteger btc = new BigInteger(""+c);
		BigInteger bn = new BigInteger(""+n);
		btc = btc.pow(d);
		btc = btc.mod(bn);
		return btc.intValue();
	}
	public String encontraTc(ArrayList<Integer> listC, int d, int n, boolean letra){
		
		if(listC.isEmpty()){
			return "Lista vazia";
		}
		StringBuffer resposta = new StringBuffer();
		for(int c: listC){
			int ic = encontraTc(c, d, n);
			if(letra)
				resposta.append(intToChar(ic));
			else
				resposta.append(ic + ";");
		}
		return resposta.toString();
	}
	
	public String encontraTc(String listC, int d, int n,boolean letra){
		listC = StringAdapter.stringRemover(listC);
		ArrayList<Integer> arrListaC = new ArrayList<>();
		if(listC.isEmpty()){
			return "Preencha com o array.\n ex.: 1;2;3;4;5";
		}
		if(d == -1 || n == -1){
			return "Verifique os parametros D e N";
		}
		for(String l : listC.split(";")){
//			System.out.println(l);
			try{
			arrListaC.add(Integer.parseInt(l));
			}catch(NumberFormatException e){
				return "Preencha o array apenas com numeros. \n Ex: 1;2;3;4";
			}
			}
		return encontraTc(arrListaC, d, n, letra);
	}
	
	public String encontraC(int tc, int e, int n){
		BigInteger bc = new BigInteger(""+tc);
		BigInteger bn = new BigInteger(""+n);
		bc = bc.pow(e);
		bc = bc.mod(bn);
		return ""+bc;	
	}
public String encontraC(ArrayList<Integer> listTc, int e, int n){
		
		StringBuffer resposta = new StringBuffer();
		for(int c: listTc){
			BigInteger btc = new BigInteger(""+c);
			BigInteger bn = new BigInteger(""+n);
			btc = btc.pow(e);
			btc = btc.mod(bn);
			resposta.append(btc + ";");
		}
		return resposta.toString();
	}
public String encontraC(String textoClaro, int e, int n){
		textoClaro = StringAdapter.stringRemover(textoClaro);
	if(e == -1 || n == -1){
		return "Verifique os parametros E e N";
	}
	if(textoClaro.equals("") || textoClaro == null){
		return "Texto em branco.";
	}
	StringBuffer resposta = new StringBuffer();
	ArrayList<Integer> listTc = new ArrayList<>();
	for(char c : textoClaro.toCharArray()){
		listTc.add(charToInt(c));
	}
	for(int c: listTc){
		BigInteger btc = new BigInteger(""+c);
		BigInteger bn = new BigInteger(""+n);
		btc = btc.pow(e);
		btc = btc.mod(bn);
		resposta.append(btc + ";");
	}
	return resposta.toString();
}
	/**
	 * Encontra o maximo de informações que conseguir
	 */
	private void encontra(){
		
		if(this.p == -10){
			this.p = encontraPQ(z, p, q, n);
			
		}
		if(this.q == -10){
			this.q = encontraPQ(z, p, q, n);
			
		}
		if(this.n == -1){
			this.n = encontraN(p, q);
			
		}
		if(this.z == -1){
			this.z = encontraZ(p, q);
			
		}
		if( this.e == -1){
			this.e = encontraED(e, d, z);
			
		}
		if(this.d == -1){
			this.d = encontraED(e, d, z);
			
		}
	}
	
	/**
	 *  encontra k1: tenta buscar K1 com informações fornecidas com get.
	 *  caso nao consiga retorna null e é necessario informar mais parametros
	 *  via SET
	 * @return String [ E ; N ];
	 */
	public String encontraK1(){
		//K1 = [ e ; n]
		encontra();		
		if( e == -1 || n == -1){
			return "Algo deu errado verifique os valores informados via SET \n"
					+ "e = "+ this.e +"\n"
					+ "n = "+ this.n +"\n"
					+ "z = "+ this.z;
		}
		return "[ " + this.e + " ; " + this.n + " ]";
	}
	
	/**
	 *  encontrak2 tenta buscar k2 com informações fornecidas com get.
	 *  caso nao consiga retorna null e é necessario informar mais parametros
	 *  via SET
	 * @return String [ D ; N ]
	 */
	public String encontraK2(){
		//K2 = [d ; n]
		encontra();		
		if( d == -1 || n == -1){
			return "Algo deu errado verifique os valores informados via SET \n"
					+ "d = "+ this.e +"\n"
					+ "n = "+ this.n +"\n"
					+ "z = "+ this.z;
		}
		return "[ " + this.d + " ; " + this.n + " ]";
	}
	
	/**
	 * 
	 * @return String K1 = [ E ; N] e K1 [ D ; N ]
	 * 	Retorna chaves K1 e K2 com informações passadas via get.
	 */
	public String encontraK1K2(){
		return encontraK1() +"\n"+ encontraK2();
	}
	
	/**
	 * 
	 * @param 1 ou 2
	 * 					 
	 * @return
	 * 		  tipo 1 = 	k1 = [ e ; n] 
	 * 				   	k2 = [ d ; n ] 
	 * 	      tipo 2 = 	e = valor
	 * 					d = valor
	 * 					n = valor
	 * 					z = valor
	 */
	public String encontraK1K2(int tipo){
		switch(tipo){
		case 1 : 
				return "K1 = "+encontraK1() +"\nK2 = "+ encontraK2(); 
		case 2 : 
				encontra();
				return "E = "+ this.e + "\n"
					  + "D = "+ this.d + "\n"
			 		  + "N = "+ this.n + "\n"
			 		  + "Z = "+ this.z + "\n"
			 		  + "p = "+ this.p + "\n"
			 		  + "q = "+ this.q + "\n" ;
		default :
				return encontraK1K2();
		}
	
		
		
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
	 /**
	  * CALCULA PRIMO
	  * @return LISTA DE PRIMOS ENTRE VALORES INFORMADOS
	  */
	 	public ArrayList<Integer> calculaPrimo(int inicio, int fim){
 		 ArrayList<Integer> numerosPrimos = new ArrayList<>();
	 		for (int numero = inicio, primos = inicio; primos < fim; numero++) {
             if (Primes.isPrime(numero)) {
                 primos++;
                 numerosPrimos.add(numero);
             }
	 		}
	 		return numerosPrimos;
 		}
	 	//59 61 67 71 73 79 83 89 97 
	
	 
	/*
	 *  GETTERS AND SETTERS
	 */
	

	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}


}

