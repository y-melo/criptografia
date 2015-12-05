package br.com.ymv.view;

public class Principal {

	public static void main(String[] args) {
		Imenu menu = new MenuOC();		
//		menu.menuPrincipal();
		MenuG menuG = new MenuG();
		MenuG.main(args);
		System.out.println("Fim");
	}

}
