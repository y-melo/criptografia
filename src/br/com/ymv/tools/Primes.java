package br.com.ymv.tools;

import java.util.ArrayList;

/**
 * Classe utilit&aacute;ria para verifica&ccedil;&atilde;o de n&uacute;meros primos.
 * 
 * @author Ricardo Artur Staroski
 * 
 *	
 */
public final class Primes {

    /**
     * Verifica se o n&uacute;mero informado &eacute; primo
     * 
     * @param number O n&uacute;mero a ser verificado
     * 
     * @return <tt>true</tt> se o n&uacute;mero informado for primo e <tt>false</tt> caso contr&aacute;rio
     */
    public static boolean isPrime(long number) {
        number = Math.abs(number);
        // se o número é par, não pode ser primo
        if (number % 2 == 0) {
            return false;
        }
        // verificar se este número ímpar é primo
        for (long i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
	  * CALCULA PRIMO
	  * @author yuri.melo
	  * @return LISTA DE PRIMOS ENTRE VALORES INFORMADOS
	  */
	 	public static ArrayList<Integer> calculaPrimo(int inicio, int fim){
		 ArrayList<Integer> numerosPrimos = new ArrayList<>();
	 		for (int numero = inicio; numero < fim; numero++) {
            if (Primes.isPrime(numero)) {
                numerosPrimos.add(numero);
            }
	 		}
	 		return numerosPrimos;
		}
    
    // não faz sentido instanciar esta classe
    private Primes() {}
}