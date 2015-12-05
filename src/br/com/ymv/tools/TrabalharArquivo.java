package br.com.ymv.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class TrabalharArquivo {
	
	public void abrir(){
		JFileChooser file = new JFileChooser(); 
		file.setFileSelectionMode(JFileChooser.FILES_ONLY); 
		int i= file.showSaveDialog(null); 
		
	}
	
	public String ler(){	

		
		
	    File arq = new File("textoClaro.txt");

	    try {
	        //Indicamos o arquivo que será lido
	        FileReader fileReader = new FileReader(arq);

	        //Criamos o objeto bufferReader que nos
	        // oferece o método de leitura readLine()
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        //String que irá receber cada linha do arquivo
	        String linha = "";

	        //Fazemos um loop linha a linha no arquivo,
	        // enquanto ele seja diferente de null.
	        //O método readLine() devolve a linha na
	        // posicao do loop para a variavel linha.
	        while ( ( linha = bufferedReader.readLine() ) != null) {
	        //Aqui imprimimos a linha
	        System.out.println(linha);
	    }
			//liberamos o fluxo dos objetos ou fechamos o arquivo
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
		return null;
	}
	
	public String escreve(){
		
		return null;
	}
}
