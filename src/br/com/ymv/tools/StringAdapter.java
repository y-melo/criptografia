package br.com.ymv.tools;


/**
 * 
 * @author yuri.melo
 * String adapter possui classes que alterão a String de alguma forma
 */
public class StringAdapter {

	/** 
	 *  Recebe uma String qualquer e remove os espaços
	 * 
	 * @param string
	 * 	
	 * @return
	 * 		String sem espaço
	 */
	public static String stringRemover(String string){
		return string.replace(" ", "");
	}
}
