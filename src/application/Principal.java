package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Principal {
	public static ArrayList<Produto> produtos = new ArrayList<>();
	//Produto prod = new Produto();
	
	public static void main(String[] args) {
		produtos.add(new Produto("Viga", 200, "m", 2));
		produtos.add(new Produto("Caixa", 3, "kg", 5));
		produtos.add(new Produto("Porta", 300, "cm", 7));
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
				pr.menuCadastroProduto();
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
				System.out.println("Opção invalida!");
				break;
			}
			
		}

	}

	private void menuCadastroProduto () {
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
			// INCLUSAO
			case 1:
				incluirProduto();
				break;
			// ALTERAÇÃO
			case 2:
				alterarProduto();
				break;
			}
		}
	}

	private void incluirProduto() {
		Scanner sc = new Scanner(System.in);
		char opc = 0;
		while (Character.toUpperCase(opc) != 'N') {
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\r\n"
					+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
					+ "INCLUSÃO DE PRODUTO\r\n"
					+ "");
			System.out.print("NOME: ");
			String nome = sc.nextLine();
			for (int i=0; i < produtos.size(); i++) {
				while (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO JÁ CADASTRADO!");
					System.out.print("\nNOME: ");
					nome = sc.nextLine();
					i=0;
				}
			}
			System.out.print("PREÇO: R$");
			double preco = sc.nextDouble();
			sc.nextLine();
			while (preco < 0) {
				System.out.println("\nDIGITE UM VALOR VÁLIDO!");
				System.out.println();
				System.out.print("PREÇO: R$");
				preco = sc.nextDouble();
			}

			System.out.print("UNIDADE: ");
			String unidade = sc.nextLine();

			System.out.print("QUANTIDADE: ");
			int quantidade = sc.nextInt();
			while (quantidade <= 0) {
				System.out.println("\nDIGITE UM VALOR VÁLIDO!");
				System.out.println();
				System.out.print("PREÇO: R$");
				quantidade = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("CONFIRMA INCLUSAO (S/N)? ");
			char confirmar = sc.next().charAt(0);
			while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
				System.out.println("\nDIGITE UM VALOR VÁLIDO!");
				System.out.println();
				System.out.print("CONFIRMA INCLUSAO (S/N)? ");
				confirmar = sc.next().charAt(0);
			}
			sc.nextLine();
			if (Character.toUpperCase(confirmar) == 'S') {
				produtos.add(new Produto(nome, preco, unidade, quantidade));
			}
			System.out.print("REPETIR OPERAÇÃO (S/N)? ");
			opc = sc.next().charAt(0);
			sc.nextLine();
		}
	}

	private void alterarProduto() {
		Scanner sc = new Scanner(System.in);
		boolean produto_encontrado = false;
		int opc = 1;
		while (Character.toUpperCase(opc) != 'N') {
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\r\n"
					+ "SISTEMA DE CONTROLE DE ESTOQUE\r\n"
					+ "ALTERAÇÃO DE PRODUTO\r\n"
					+ "");
			System.out.print("INFORME O NOME DO PRODUTO: ");
			String nome = sc.nextLine();
			for (int i=0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO ENCONTRADO!");
					produto_encontrado = true;
					//
					//
					System.out.println("-=-=-=-=-=-=-= PRODUTO " + i + " -=-=-=-=-=-=-=");
					System.out.println("Nome: " + produtos.get(i).getNome());
					System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
					System.out.println("Unidade: " + produtos.get(i).getUnidade());
					System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
					//
					//
					System.out.print("\nPREÇO A SER ALTERADO: R$");
					double preco = sc.nextDouble();
					sc.nextLine();
					while (preco < 0) {
						System.out.println("\nDIGITE UM VALOR VÁLIDO!");
						System.out.println();
						System.out.print("PREÇO: R$");
						preco = sc.nextDouble();
					}
					System.out.print("UNIDADE A SER ALTERADA: ");
					String unidade = sc.nextLine();
					System.out.print("QUANTIDADE A SER ALTERADA: ");
					int quantidade = sc.nextInt();
					while (quantidade <= 0) {
						System.out.println("\nDIGITE UM VALOR VÁLIDO!");
						System.out.println();
						System.out.print("PREÇO A SER ALTERADO: R$");
						quantidade = sc.nextInt();
					}
					sc.nextLine();
					System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
					char confirmar = sc.next().charAt(0);
					while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
						System.out.println("\nDIGITE UM VALOR VÁLIDO!");
						System.out.println();
						System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
						confirmar = sc.next().charAt(0);
					}
					if (Character.toUpperCase(confirmar) == 'S') {
						produtos.set(i, new Produto(nome, preco, unidade, quantidade));
					}
					//System.out.print("REPETIR OPERAÇÃO (S/N)? ");
					//opc = sc.next().charAt(0);
				}
			}
			if (!produto_encontrado) {
				System.out.println("PRODUTO NÃO ENCONTRADO!");
			}
			System.out.print("REPETIR OPERAÇÃO (S/N)? ");
			opc = sc.next().charAt(0);
			sc.nextLine();
		}
	}

	private void move() {
	}

	private void reajuste() {
	}

	private void relatorio() {
		int n = 0;
		if (produtos.isEmpty()) {
			System.out.println("Lista vazia!");
		} else {
			
			for (Produto produtos : produtos) {
				System.out.println("-=-=-=-=-=-=-= PRODUTO " + n + " -=-=-=-=-=-=-=");
	            System.out.println("Nome: " + produtos.getNome());
	            System.out.println("Preço Unitario: R$" + produtos.getPreco_unit());
	            System.out.println("Unidade: " + produtos.getUnidade());
	            System.out.println("Quantidade em estoque: " + produtos.getQnt_estoque());
	            n++;
	        }
		}
	}

}
