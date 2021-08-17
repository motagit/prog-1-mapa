package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Principal {
	public static ArrayList<Produto> produtos = new ArrayList<Produto>();
	//Produto prod = new Produto();
	
	public static void main(String[] args) {
		produtos.add(new Produto("Macaco", 200, 1, 2));
		produtos.add(new Produto("Golfinho", 3, 2, 5));
		produtos.add(new Produto("Le�o", 300, 4, 7));
		int opcao = 1;
		Scanner sc = new Scanner(System.in);
		Principal pr = new Principal();
		while (opcao != 0) {
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\r\n"
					+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
					+ "MENU PRINCIPAL\r\n"
					+ "");
			System.out.println("1 - CADASTRO DE PRODUTOS\r\n"
					+ "2 - MOVIMENTA��O\r\n"
					+ "3 - REAJUSTE DE PRE�OS\r\n"
					+ "4 - RELAT�RIOS\r\n"
					+ "0 - FINALIZAR"
					+ "");
			System.out.print("OP��O: ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				pr.cadastro();
				break;
			case 2:
//				pr.move();
				break;
			case 3:
//				pr.reajuste();
				break;
			case 4:
				pr.relatorio();
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
			
		}

	}
	public void cadastro () {
		Scanner sc = new Scanner(System.in);
		int opc = 1;
		
		while (opc != 0) {
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\r\n"
					+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
					+ "CADASTRO DE PRODUTOS\r\n"
					+ "");
			System.out.println("1 - INCLUS�O\r\n"
					+ "2 - ALTERA��O\r\n"
					+ "3 - CONSULTA\r\n"
					+ "4 - EXCLUS�O\r\n"
					+ "0 - RETORNAR");
			System.out.print("OP��O: ");
			opc = sc.nextInt();
			sc.nextLine();
			
			switch (opc) {
			// INCLUSAO
			case 1:
				char op = 0;
				while (Character.toUpperCase(op) != 'N') {
					System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\r\n"
							+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
							+ "INCLUS�O DE PRODUTO\r\n"
							+ "");
					System.out.print("NOME: ");
					String nome = sc.nextLine();
					for (Produto search : produtos) {
						while (search.getNome().contains(nome)) {
							System.out.println("\nPRODUTO J� CONSTA NO ESTOQUE.");
							System.out.println("");
							System.out.print("NOME: ");
							nome = sc.nextLine();
					    }
					}
					System.out.print("PRE�O: R$");
					double preco = sc.nextDouble();
					while (preco <= 0) {
						System.out.println("\nDIGITE UM VALOR V�LIDO!");
						System.out.println();
						System.out.print("PRE�O: R$");
						preco = sc.nextDouble();
					}
					System.out.print("UNIDADE: ");
					int unidade = sc.nextInt();
					sc.nextLine();
					System.out.print("QUANTIDADE: ");
					int quantidade = sc.nextInt();
					sc.nextLine();
					System.out.print("CONFIRMA INCLUSAO (S/N)? ");
					char confirmar = sc.next().charAt(0);
					sc.nextLine();
					if (Character.toUpperCase(confirmar) == 'S') {
						produtos.add(new Produto(nome, preco, unidade, quantidade));	
					} 
					System.out.print("REPETIR OPERA��O (S/N)? ");
					op = sc.next().charAt(0);
					sc.nextLine();
				}
				break;
			// ALTERA��O
			case 2:
				System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\r\n"
						+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
						+ "ALTERA��O DE PRODUTO\r\n"
						+ "");
				System.out.print("NOME: ");
				String nome = sc.nextLine();
				for (Produto search : produtos) {
						if (search.getNome().contains(nome)) {
							System.out.println("CONTEM");
							break;
						} else {
							System.out.println("\nPRODUTO N�O CONSTA NO ESTOQUE.");
							System.out.println("");
							System.out.print("NOME: ");
							nome = sc.nextLine();
						}
				    	
				    }
				}
			}
		}
		
	
	public void move() {
		return;
	}
	
	public void reajuste() {
		return;
	}
	
	public void relatorio() {
		int n = 1;
		if (produtos.isEmpty()) {
			System.out.println("Lista vazia!");
		} else {
			
			for (Produto produtos : produtos) {
				System.out.println("-=-=-=-=-=-=-= PRODUTO " + n + " -=-=-=-=-=-=-=");
	            System.out.println("Nome: " + produtos.getNome());
	            System.out.println("Pre�o Unit�rio: R$" + produtos.getPreco_unit());
	            System.out.println("Unidade: " + produtos.getUnidade());
	            System.out.println("Quantidade em estoque: " + produtos.getQnt_estoque());
	            n++;
	        }
		}

		return;
	}

}
