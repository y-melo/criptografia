package br.com.ymv.tools;


/**
 * 
 * @author yuri.melo
 * String adapter possui classes que alter�o a String de alguma forma
 */
public class StringAdapter {

	/** 
	 *  Recebe uma String qualquer e remove os espa�os
	 * 
	 * @param string
	 * 	
	 * @return
	 * 		String sem espa�o
	 */
	public static String stringRemover(String string){
		return string.replace(" ", "");
	}
}
