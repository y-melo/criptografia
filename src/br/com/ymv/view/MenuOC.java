package br.com.ymv.view;

import java.util.Scanner;

import br.com.ymv.cripto.Cesar;
import br.com.ymv.cripto.Cifracao;
import br.com.ymv.cripto.Congruencia;
import br.com.ymv.cripto.Permutacao;
import br.com.ymv.cripto.RSA;
import br.com.ymv.cripto.Transposicao;

public  class MenuOC implements Imenu{
	
	
	static Scanner s = new java.util.Scanner(System.in);
@Override	
public  String menuPrincipal() {
		
		
		boolean executa = true;
		while(executa){
			int opcaoMenuPrincipal = 0 ; 
			System.out.println("    ****************\n"
							 + "    ***   MENU   ***\n"
							 + "    ****************");
			System.out.println("1 - Criptografia RSA");
			System.out.println("2 - Criptografia Congruencia");
			System.out.println("3 - Criptografia Cesar");
			System.out.println("4 - Criptografia Transposição");
			System.out.println("5 - Criptografia Cifração");
			System.out.println("6 - Criptografia Permutação");
			System.out.println("7 - Sair.");
			try {
				System.out.print("opção: ");
				 opcaoMenuPrincipal = s.nextInt();
			} catch (Exception e) {
				s.nextLine();
				System.err.println("Não foi identificado um número.\n Para sair digite 7");
			}
			
			switch(opcaoMenuPrincipal){
			case 1: // menuRSA
				System.out.println(menuRSA());
				executa =true;
				break;
			case 2: //Menu Congruencia
				System.out.println(menuCongruencia());
				break;
			case 3: // Menu Cesar
				System.out.println(menuCesar());
				break;
			case 4: //Menu Transposição
				System.out.println(menuTransposicao());
				break;				
			case 5: //Menu Cifração
				System.out.println(menuCifracao());
				break;
			case 6://Menu Permutação
				System.out.println(menuPermutacao());
				break;
			case 7: return "bye"; //Sair
				
			default: System.out.println("\n***** Digite umas das opções Abaixo *****\n");
			
			
			
			}// fim do switch
		}//fim do while TRUE
		return "tem algo muito errado no menu!!";
	}

	@Override
	public String menuRSA(){
		boolean executaRSA = true;
		while(executaRSA){
			int opcaoMenuRSA = 0;
			
			System.out.println("\n*** MENU RSA ***\n");
			System.out.println("1 - Encontrar Informações;");
			System.out.println("2 - Procurar numeros primos;");
			System.out.println("3 - Criptografar;");
			System.out.println("4 - Descriptografar;");
			System.out.println("5 - Voltar.");
			
			try{
				System.out.print("Opção: ");
				opcaoMenuRSA = s.nextInt();
			}catch (Exception e) {
				s.nextLine(); //contorna bug do scanner
				System.err.println("Não foi identificado um número.\n Para sair digite 7");
			}
			
			RSA rsa = new RSA();
			switch(opcaoMenuRSA){
			case 1: // Encontrar informações
				System.out.println("***\nDigite apenas as informações que voce possuir.\n "
								 + "caso nao possua o numero informe -1.\n***");
				
				//INFORMAR P
				boolean bP = true; //bP = boolean P
				s.nextLine();
				while(bP){
					System.out.print("Informe o valor de P: ");
					String sP = s.nextLine();
					try { //se usuario digitar letras ele nao quebra...
					 rsa.setP(Integer.parseInt(sP));
					 bP = false;
					} catch (Exception e) {
						bP = true;
					}
				}
			
				//INFORMAR Q
				boolean bQ = true; //bP = boolean Q
				while(bQ){
					System.out.print("Informe o valor de Q: ");
					String sQ = s.nextLine();
					try {
						rsa.setQ(Integer.parseInt(sQ));
					 bQ = false;
					} catch (Exception e) {
						bQ = true;
					}
				}
	
				
				//INFORMAR z
				boolean bZ= true; //bP = boolean Z
				while(bZ){
					System.out.print("Informe o valor de Z: ");
					String sZ = s.nextLine();
					try {
						rsa.setZ(Integer.parseInt(sZ));
					 bZ = false;
					} catch (Exception e) {
						bZ = true;
					}
				}
				
				
	
				//INFORMAR E
				boolean bE= true; //bP = boolean E
				while(bE){
					System.out.print("Informe o valor de E: ");
					String sE = s.nextLine();
					try {
						rsa.setE(Integer.parseInt(sE));
					 bE = false;
					} catch (Exception e) {
						bE = true;
					}
				}
				
				//INFORMAR D
				boolean bD= true; //bD = boolean D
				while(bD){
					System.out.print("Informe o valor de D: ");
					String sD = s.nextLine();
					try {
						rsa.setD(Integer.parseInt(sD));
					 bD = false;
					} catch (Exception e) {
						bD = true;
					} //Fim do catch
				}//Fim do while
				
				System.out.println("Os valores informados foram: \n"
								 + "P: "+rsa.getP()+"| Q: "+ rsa.getQ() +"| Z: "+ rsa.getZ()
								 + "| E: "+ rsa.getE()+"| D: "+ rsa.getD()+"| N: "+ rsa.getN());
				System.out.println("\n Respota: \n"+rsa.encontraK1K2(2).toString());
//				System.out.println(rsa.encontraK1K2().toString());
				System.out.println("Para Continuar aperte Enter....");
				s.nextLine();
				executaRSA = true;
				
				break;
			case 2: //Procurar números primos;
				
				int inicio = 1;
				int fim = 100;
				System.out.println("-----------------------\n"
								 + "Procurar numeros Primos\n"
								 + "-----------------------\n");
				s.nextLine(); //Corrigir bug
				System.out.print("\nInforme o menor numero do intervalo: ");
				String sInicio = s.nextLine();	
				
				try {
					inicio = Integer.parseInt(sInicio);
					
					if(inicio <=0)
						inicio =1;
					
				} catch (Exception e) {
					inicio = 1;
				} //Fim do catch
			
				
				System.out.print("Informe o maior numero do intervalo: ");
				String sFim = s.nextLine();	
				try {
					fim = Integer.parseInt(sFim);
				} catch (Exception e) {
					fim = 100;
				} //Fim do catch
				System.out.println(inicio+", "+ fim);
				System.out.println(rsa.calculaPrimo(inicio, fim).toString());
				executaRSA = true;
				System.out.println("Para Continuar aperte Enter....");
				s.nextLine();
				break;
			case 3://Criptografar
				
				System.out.println("-------------------\n"
								 + "- Critografia RSA -\n"
								 + "-------------------\n");
				s.nextLine();
				//Valor E
				boolean cBE = true; //criptografia Boolean E
				boolean cBCripto = true;
				int cE = -1;
				int cN = -1;
				String textoClaro = null;
				while(cBCripto){
					System.out.println("Para criptografa é necessario a chave K1[E,N]");
					while(cBE){
						System.out.print("Informe o valor E: ");
						String cSE = s.nextLine();
						try {
							cE = Integer.parseInt(cSE);
							cBE = false;
						} catch (Exception e) {
							System.err.println("\nInforme um valor valido, inteiro positivo");
							cBE = true;
						} //Fim do catch
					}//fim do while
					
					//Valor N
					boolean cBN = true; //criptografia Boolean N
					while(cBN){
						System.out.print("Informe o valor N: ");
						String cSN = s.nextLine();
						
						try {
							cN = Integer.parseInt(cSN);
							cBN = false;
						} catch (Exception e) {
							System.err.println("\nInforme um valor valido, inteiro positivo");
							cBN = true;
						} //Fim do catch
					}//fim do while N
					System.out.print("Digite o texto claro(sem espaço): ");
					textoClaro = s.nextLine();
					
					System.out.println("Informou algum valor errado e deseja informar novamente?\n "
									 + "E: "+cE+"| N: "+cN+ "| Texto Claro: "+ textoClaro +"\n"
									 + "1 - sim\n"
									 + "2 - NÃO");
					System.out.print("Opção: ");
					String sValorErrado = s.nextLine();
					
					try {
						int valorErrado = Integer.parseInt(sValorErrado);
						if(valorErrado == 1){
							cBCripto = true;
						}else{
							cBCripto = false;
						}
					} catch (Exception e) {
						System.err.println("\n Opção nao indentificada, programa vai prossegir...\n");
						cBCripto = false;
					}				
				}//fim do while	cBCripto	
				System.out.println("\n Texto Claro: "+ textoClaro);
				System.out.println("\n Texto Cripto: "+rsa.encontraC(textoClaro, cE, cN));
				executaRSA = true;
				System.out.println("Para Continuar aperte Enter....");
				s.nextLine();
				break;
			case 4://DESCRIPTOGRAFAR
				
				System.out.println("-------------------\n"
							 	 + "- Descritografar RSA -\n"
								 + "-------------------\n");
				s.nextLine();
				//Valor D
				boolean dBD = true; //criptografia Boolean E
				int dD = -1;
				int dN = -1;
				String textoCripto = null;
				System.out.println("Para Descriptografia é necessario a chave K2[D,N]");
				while(dBD){
					System.out.print("Informe o valor D: ");
					String dSD = s.nextLine();
					try {
						dD = Integer.parseInt(dSD);
						dBD = false;
					} catch (Exception e) {
						System.err.println("informe um valor valido, inteiro positivo");
						dBD = true;
					} //Fim do catch
				}//fim do while
		
				//Valor N
				boolean dBN = true; //criptografia Boolean N
				while(dBN){
					System.out.print("Informe o valor N: ");
					String dSN = s.nextLine();
		
					try {
						dN = Integer.parseInt(dSN);
						dBN = false;
					} catch (Exception e) {
						System.err.println("informe um valor valido, inteiro positivo");
						dBN = true;
					} //Fim do catch
			
					System.out.print("Digite o texto Cripto(Ex.: 1;2;3;4;): ");
					textoCripto= s.nextLine();
			
					System.out.println("Informou algum valor errado e deseja informar novamente?\n "
							 + "D: "+dD+"| N: "+dN+ "| Texto Criptografado: "+ textoCripto+"\n"
							 + "1 - sim\n"
							 + "2 - NÃO");
					System.out.print("Opção: ");
					String sValorErrado = s.nextLine();
			
					try {
						int valorErrado = Integer.parseInt(sValorErrado);
						if(valorErrado == 1){
							dBD = true;
						}else{
							dBD = false;
						}
					} catch (Exception e) {
						dBD = false;
					}
				}//fim do while
				System.out.println("\nTexto Cripto: "+ textoCripto);
				System.out.println("\n Texto Claro: "+ rsa.encontraTc(textoCripto, dD, dN, true));
				executaRSA = true;
				System.out.println("Para Continuar aperte Enter....");
				s.nextLine();
				break;
			case 5: 
				executaRSA = false;
				return " ** Volta Menu Principal **";
			default: break;
			
			}
		}//WHILE EXECUTA
		return null;
	
	}

	@Override
	public String menuCongruencia(){ //MENU OPÇÃO 2
		boolean executaCongruencia = true;
		int opcaoMenuCongruencia;
		while(executaCongruencia){
			opcaoMenuCongruencia = 0;
			
			System.out.println("\n*** MENU Congruencia ***\n");
			System.out.println("1 - Criptografar;");
			System.out.println("2 - Descriptografar;");
			System.out.println("3 - Voltar.");
			
			try{
				System.out.print("Opção: ");
				opcaoMenuCongruencia = s.nextInt();
			}catch (Exception e) {
				s.nextLine(); //contorna bug do scanner
				System.err.println("Não foi identificado um número.\n Para voltar digite 3");
			}
			Congruencia con;
		switch(opcaoMenuCongruencia){
		case 1://CRIPTOGRAFIA
			s.nextLine();
			System.out.println("\n*** Congruencia Criptografia***\n");
			System.out.println("Formua: F(x) = N1 *x + N2");
			
			
			int cn1 = 1;
			boolean cbn1 = true;
			while(cbn1){
				System.out.print("Informe o N1(Multiplo de X): ");
				String scN1 = s.nextLine();
				try {
					cn1 =  Integer.parseInt(scN1);
					cbn1 = false;
				} catch (Exception e) {
					
					System.err.print("\nDigite um valor válido, inteiro.\n");
//					s.nextLine(); //contorna bug do scanner
					cbn1 = true;
				}
			}//fim do while bn1
			
			System.out.print("Informe o N2(Somador de X) : ");
			String scN2 = s.nextLine();
			int cn2 = 1;
			boolean cbn2 = true;
			while(cbn2){
				try {
					cn2 =  Integer.parseInt(scN2);
					cbn2 = false;
				} catch (Exception e) {
					s.nextLine(); //contorna bug do scanner
					System.err.println("Digite um valor válido, inteiro.");
					cbn2 = true;
				}
			}//fim do while bn2
			
			System.out.println("Informe o Texto Claro: ");
			String conTextoClaro = s.nextLine();
			
			con = Congruencia.instancia(cn1, cn2);
			
			
			System.out.println("\nTexto Claro: "+ conTextoClaro);
			System.out.println("Texto Criptografado: "+ con.criptCongruencia(conTextoClaro));
			System.out.print("\nPressione enter para voltar ao menu.");
			s.nextLine();
			;break;
		
		case 2://DESCRIPTOGRAFIA
			s.nextLine();
			System.out.println("\n*** Congruencia Descriptografia***\n");
			System.out.println("Formua: F(x) = N1 *x + N2");
			
			System.out.print("Informe o N1(Mutiplo de X): ");
			String sdN1 = s.nextLine();
			int dn1 = 1;
			boolean dbn1 = true;
			while(dbn1){
				try {
					dn1 =  Integer.parseInt(sdN1);
					dbn1 = false;
				} catch (Exception e) {
//					e.printStackTrace();
					System.err.println("Digite um valor válido, inteiro.");
					s.nextLine(); //contorna bug do scanner
					dbn1 = true;
				}
			}//fim do while bn1
			
			System.out.print("Informe o N2(Somador de X): ");
			String sdN2 = s.nextLine();
			int dn2 = 1;
			boolean dbn2 = true;
			while(dbn2){
				try {
					dn2 =  Integer.parseInt(sdN2);
					dbn2 = false;
				} catch (Exception e) {
					s.nextLine(); //contorna bug do scanner
					System.err.println("Digite um valor válido, inteiro.");
					dbn2 = true;
				}
			}//fim do while bn2
			
			System.out.println("Informe o Texto Claro: ");
			String conTextoCripto = s.nextLine();
			
			con = Congruencia.instancia(dn1, dn2);
			
			
			System.out.println("\nTexto Cripto: "+ conTextoCripto);
			System.out.println("Texto Claro: "+ con.deCriptCongruencia(conTextoCripto));
			
			
			System.out.println("\nPressione ENTER para voltar ao menu...");
			s.nextLine();
			;break;
		
		case 3: 
			executaCongruencia = false;
			return " ** Volta Menu Principal **";
		default: break;
		}//Fim opção Menu Congruencia
		}//While opcaoMenuCongruencia
		
		return null;
	} //Menu congruencia

	@Override
	public String menuCesar() { // MENU OPÇÃO 3
		boolean executaCesar = true;
		int opcaoMenuCesar;
		while(executaCesar){
			opcaoMenuCesar = 0;
			
			System.out.println("\n*** MENU Criptografia de Cesar***\n");
			System.out.println("1 - Criptografar;");
			System.out.println("2 - Descriptografar;");
			System.out.println("3 - Voltar.");
			
			try{
				System.out.print("Opção: ");
				opcaoMenuCesar = s.nextInt();
			}catch (Exception e) {
				s.nextLine(); //contorna bug do scanner
				System.err.println("Não foi identificado um número.\n Para voltar digite 3");
			}
			s.nextLine();
			Cesar cesar = new Cesar();
			switch(opcaoMenuCesar){
			case 1: //Critografar Cesar
				System.out.print("Texto Claro: ");
				String cesarTextotClaro = s.nextLine();
				
				System.out.println("\nTexto Claro: "+cesarTextotClaro);
				System.out.println("Texto Criptografado: "+cesar.criptCS(cesarTextotClaro));
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();
				
				break;
			case 2:
				System.out.print("Texto Criptografado: ");
				String cesarTextotCripto= s.nextLine();
				
				System.out.println("\nTexto Claro: "+cesar.deCriptCS(cesarTextotCripto));
				System.out.println("Texto Criptografado: "+cesarTextotCripto);
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();
				
				break;
			case 3: return "Voltando para menu principal";
			default: System.out.println("Opção não identificada.");
			} //fim switch opção menu cesar
		
		}// fim while menu
	
		return null;
	}//Fim opção 3 - Cesar

	@Override
	public String menuTransposicao() { //menu opção 4

		boolean executaTransposicao= true;
		int opcaoMenuTransposicao;
		while(executaTransposicao){
			opcaoMenuTransposicao= 0;
			
			System.out.println("\n*** MENU Criptografia de Transposicao***\n");
			System.out.println("1 - Criptografar;");
			System.out.println("2 - Descriptografar;");
			System.out.println("3 - Voltar.");
			
			try{
				System.out.print("Opção: ");
				opcaoMenuTransposicao = s.nextInt();
			}catch (Exception e) {
				s.nextLine(); //contorna bug do scanner
				System.err.println("Não foi identificado um número.\n Para voltar digite 3");
			}
			s.nextLine();//Contorna bug do scanner
			Transposicao tp = new Transposicao();
			switch(opcaoMenuTransposicao){
			case 1: //Critografar Transposição
				System.out.print("Texto Claro: ");
				String tpTextotClaro = s.nextLine();
				
				int cchave=0;
				while(true){
					try{
					System.out.print("Informe a chave (Inteiro positivo): ");
					cchave = s.nextInt();
					break;
					}catch (Exception e) {
						//Repete a pergunta acima..
					}
				}
				
				System.out.println("\nTexto Claro: "+tpTextotClaro);
				System.out.println("Texto Criptografado: "+tp.criptTp(tpTextotClaro, cchave));
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();//Bug do scanner
				s.nextLine();
				
				break;
			case 2: // Descriptografia Tranposição
				System.out.print("Texto Criptografado: ");
				String tpTextoCripto= s.nextLine();
				
				int dchave=0;
				while(true){
					try{
					System.out.print("Informe a chave (Inteiro positivo): ");
					dchave = s.nextInt();
					break;
					}catch (Exception e) {
						//Repete a pergunta acima..
					}
				}
				
				System.out.println("\nTexto Claro: "+tp.deCriptTp(tpTextoCripto, dchave));
				System.out.println("Texto Criptografado: "+tpTextoCripto);
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();//Bug do scanner
				s.nextLine();
				
				break;
			case 3: return "Voltando para menu principal";
			default: System.out.println("Opção não identificada.");
			} //fim switch opção menu Transposição
		
		}// fim while menu
	
		return null;

	}//Fim opção 4 - Transposição

	@Override
	public String menuCifracao() { //Menu opção 5
		boolean executaCifracao= true;
		int opcaoMenuCifracao;
		while(executaCifracao){
			opcaoMenuCifracao= 0;
			
			System.out.println("\n*** MENU Criptografia de Cifração***\n");
			System.out.println("1 - Criptografar;");
			System.out.println("2 - Descriptografar;");
			System.out.println("3 - Voltar.");
			
			try{
				System.out.print("Opção: ");
				opcaoMenuCifracao= s.nextInt();
			}catch (Exception e) {
				s.nextLine(); //contorna bug do scanner
				System.err.println("Não foi identificado um número.\n Para voltar digite 3");
			}
			s.nextLine();//Contorna bug do scanner
			Cifracao cif = new Cifracao();
			
			switch(opcaoMenuCifracao){
			case 1: //Critografar Cifração
				System.out.print("Texto Claro: ");
				String cifTextotClaro = s.nextLine();
				
				String cchave= null;
				
				System.out.print("Informe a chave: ");
				cchave = s.nextLine();
				
				System.out.println("\nTexto Claro: "+cifTextotClaro);
				System.out.println("Texto Criptografado: "+cif.criptCifracao(cifTextotClaro, cchave));
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();
				
				break;
			case 2: // Descriptografia Cifracao
				System.out.print("Texto Criptografado: ");
				String cifTextoCripto= s.nextLine();
				
				String dchave= null;
				System.out.print("Informe a chave: ");
				dchave = s.nextLine();
				
				System.out.println("\nTexto Claro: "+cif.deCriptCifracao(cifTextoCripto, dchave));
				System.out.println("Texto Criptografado: "+cifTextoCripto);
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();
				
				break;
			case 3: return "Voltando para menu principal";
			default: System.out.println("Opção não identificada.");
			} //fim switch opção menu Transposição
		
		}// fim while menu
	
		return null;
	}//Fim opção 5 - Cifracao

	@Override
	public String menuPermutacao() { //Menu Opção 6
		
		boolean executaPermutacao= true;
		int opcaoMenuPermutacao;
		while(executaPermutacao){
			opcaoMenuPermutacao= 0;
			
			System.out.println("\n*** MENU Criptografia de Permutação***\n");
			System.out.println("1 - Criptografar;");
			System.out.println("2 - Descriptografar;");
			System.out.println("3 - Voltar.");
			
			try{
				System.out.print("Opção: ");
				opcaoMenuPermutacao= s.nextInt();
			}catch (Exception e) {
				s.nextLine(); //contorna bug do scanner
				System.err.println("Não foi identificado um número.\n Para voltar digite 3");
			}
			s.nextLine();//Contorna bug do scanner
			Permutacao permutacao = new Permutacao();
			switch(opcaoMenuPermutacao){
			case 1: //Critografar Permutação
				System.out.print("Texto Claro: ");
				String permutacaoTextotClaro = s.nextLine();
				
				String sChave = null; 
				while(true){
					try{
					System.out.print("Informe a chave (Inteiro positivo): ");
					sChave = s.nextLine();
					break;
					}catch (Exception e) {
//						e.printStackTrace();
						//Repete a pergunta acima..
					}
				}
				
				System.out.println("\nTexto Claro: "+permutacaoTextotClaro);
				System.out.println("Texto Criptografado: "+permutacao.criptPMT(permutacaoTextotClaro, sChave));
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();
				
				break;
			case 2: // Descriptografia Permutacao
				System.out.print("Texto Criptografado: ");
				String permutacaoTextoCripto= s.nextLine();
				
				String sdChave = null;
				while(true){
					try{
						System.out.print("Informe a chave (Inteiro positivo): ");
						sdChave = s.nextLine();
						break;
					}catch (Exception e) {						
						//Repete a pergunta acima..
					}
				}
				
				System.out.println("\nTexto Claro: "+permutacao.deCriptPMT(permutacaoTextoCripto, sdChave));
				System.out.println("Texto Criptografado: "+permutacaoTextoCripto);
				
				System.out.println("Pressione ENTER para continuar...");
				s.nextLine();
				
				break;
			case 3: return "Voltando para menu principal";
			default: System.out.println("Opção não identificada.");
			} //fim switch opção menu Transposição
		
		}// fim while menu
	
		return null;
	}//Fim opcao 6 - Permutacao



	
	

}
