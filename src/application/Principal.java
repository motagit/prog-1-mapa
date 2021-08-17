package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Principal {
	ArrayList<Produto> produtos = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcao = 1;
		Scanner sc = new Scanner(System.in);
		Principal pr = new Principal();
		while (opcao != 0) {
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\r\n"
					+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
					+ "MENU PRINCIPAL\r\n"
					+ "");
			System.out.println("1 - CADASTRO DE PRODUTOS\r\n"
					+ "2 - MOVIMENTAÇÃO\r\n"
					+ "3 - REAJUSTE DE PREÇOS\r\n"
					+ "4 - RELATÓRIOS\r\n"
					+ "0 - FINALIZAR"
					+ "");
			System.out.print("OPÇÃO: ");
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
				System.out.println("Opção inválida!");
				break;
			}
			
		}

	}
	public void cadastro () {
		Scanner sc = new Scanner(System.in);
		int opc = 1;
		
		while (opc != 0) {
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\r\n"
					+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
					+ "CADASTRO DE PRODUTOS\r\n"
					+ "");
			System.out.println("1 - INCLUSÃO\r\n"
					+ "2 - ALTERAÇÃO\r\n"
					+ "3 - CONSULTA\r\n"
					+ "4 - EXCLUSÃO\r\n"
					+ "0 - RETORNAR");
			System.out.print("OPÇÃO: ");
			opc = sc.nextInt();
			sc.nextLine();
			
			switch (opc) {
			case 1:
				char op = 0;
				while (Character.toUpperCase(op) != 'N') {
					System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\r\n"
							+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
							+ "INCLUSÃO DE PRODUTO"
							+ "");
					System.out.println();
					System.out.print("NOME: ");
					String nome = sc.nextLine();
					System.out.print("PREÇO: ");
					double preco = sc.nextDouble();
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
					System.out.print("REPETIR OPERAÇÃO (S/N)? ");
					op = sc.next().charAt(0);
					sc.nextLine();
				}
				break;
				
				
			}
		}
		return;
		
	}
	
	public void move() {
		return;
	}
	
	public void reajuste() {
		return;
	}
	
	public void relatorio() {
		produtos.add(new Produto("Macaco", 200, 1, 2));
		produtos.add(new Produto("Golfinho", 3, 2, 5));
		produtos.add(new Produto("Leão", 300, 4, 7));
		int n = 1;
		if (produtos.isEmpty()) {
			System.out.println("Lista vazia!");
		} else {
			
			for (Produto produtos : produtos) {
				System.out.println("-=-=-=-=-=-=-= PRODUTO " + n + " -=-=-=-=-=-=-=");
	            System.out.println("Nome: " + produtos.getNome());
	            System.out.println("Preço Unitário: R$" + produtos.getPreco_unit());
	            System.out.println("Unidade: " + produtos.getUnidade());
	            System.out.println("Quantidade em estoque: " + produtos.getQnt_estoque());
	            n++;
	        }
		}

		return;
	}

}
