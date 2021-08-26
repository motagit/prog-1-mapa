package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;

public class Principal {
	public static ArrayList<Produto> produtos = new ArrayList<>();
	//Produto prod = new Produto();
	
	public static void main(String[] args) {
		produtos.add(new Produto("Viga", 200, "m", 15));
		produtos.add(new Produto("Caixa", 4, "kg", 32));
		produtos.add(new Produto("Porta", 800, "cm", 7));
		produtos.add(new Produto("Parafuso", 2, "g", 240));
		produtos.add(new Produto("Madeira", 100, "cm", 120));
		int opcao = 1;
		Scanner sc = new Scanner(System.in);
		Principal pr = new Principal();
		while (opcao != 0) {
			pr.tituloMenu();
			System.out.println("MENU PRINCIPAL\n");
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
			case 0:
				break;
			case 1:
				pr.menuCadastroProduto();
				break;
			case 2:
				pr.menuMovimentacao();
				break;
			case 3:
				pr.reajuste();
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
			tituloMenu();
			System.out.println("CADASTRO DE PRODUTOS\n");
			System.out.println("1 - INCLUSÃO\r\n"
					+ "2 - ALTERAÇÃO\r\n"
					+ "3 - CONSULTA\r\n"
					+ "4 - EXCLUSÃO\r\n"
					+ "0 - RETORNAR");
			System.out.print("OPÇÃO: ");
			opc = sc.nextInt();
			sc.nextLine();
			
			switch (opc) {
				case 0:
					break;
				// INCLUSAO
				case 1:
					incluirProduto();
					break;
				// ALTERAÇAO
				case 2:
					alterarProduto();
					break;
				// CONSULTA
				case 3:
					consultarProduto();
					break;
				// EXCLUSAO
				case 4:
					excluirProduto();
					break;
				default:
					System.out.println("Opção invalida!");
					break;
			}
		}
	}

	private void menuMovimentacao() {
		Scanner sc = new Scanner(System.in);
		int opc = 1;

		while (opc != 0) {
			tituloMenu();
			System.out.println("MOVIMENTAÇÃO\n");
			System.out.println("1 - ENTRADA\n" +
					"2 - SAÍDA\n" +
					"0 - RETORNAR\n");
			System.out.print("OPÇÃO: ");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
				case 0:
					break;
				// ENTRADA
				case 1:
					entradaProduto();
					break;
				// SAIDA
				case 2:
					saidaProduto();
					break;
				default:
					System.out.println("Opção invalida!");
					break;
			}
		}
	}

	private void entradaProduto() {
        Scanner sc = new Scanner(System.in);
        char opc = 0;

        while (Character.toUpperCase(opc) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
			System.out.println("MOVIMENTAÇÃO - ENTRADA DE PRODUTO\n");
            System.out.print("PRODUTO: ");
            String nome = sc.nextLine();
            for (int i=0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;
                    //
                    //
					System.out.println("-=-=-=- PRODUTO " + i + " -=-=-=-");
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                    //
                    //
                    System.out.print("QUANTIDADE DE ENTRADA: ");
                    int quantidade = sc.nextInt();
                    while (quantidade <= 0) {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("QUANTIDADE DE ENTRADA: ");
                        quantidade = sc.nextInt();
                    }
					System.out.println("QUANTIDADE FINAL: " + (produtos.get(i).getQnt_estoque() + quantidade));
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
                        produtos.get(i).setAddQuant(quantidade);
                        break;
                    }
                }
            }
            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            opc = sc.next().charAt(0);
            sc.nextLine();

        }
		//
	}

	private void saidaProduto() {
        Scanner sc = new Scanner(System.in);
        char opc = 0;

        while (Character.toUpperCase(opc) != 'N') {
			boolean produto_encontrado = false;
			tituloMenu();
			System.out.println("MOVIMENTAÇÃO - SAIDA DE PRODUTO\n");
			System.out.print("PRODUTO: ");
			String nome = sc.nextLine();
			for (int i=0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO ENCONTRADO!");
					produto_encontrado = true;
					//
					//
					System.out.println("-=-=-=- PRODUTO " + i + " -=-=-=-");
					System.out.println("Nome: " + produtos.get(i).getNome());
					System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
					//
					//
					System.out.print("QUANTIDADE DE SAIDA: ");
					int quantidade = sc.nextInt();
					while (quantidade <= 0) {
						System.out.println("\nDIGITE UM VALOR VÁLIDO!");
						System.out.println();
						System.out.print("QUANTIDADE DE SAIDA: ");
						quantidade = sc.nextInt();
					}
					System.out.println("QUANTIDADE FINAL: " + (produtos.get(i).getQnt_estoque() - quantidade));
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
						produtos.get(i).setRemoveQuant(quantidade);
						break;
					}
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

	private void incluirProduto() {
		Scanner sc = new Scanner(System.in);
		char opc = 0;
		while (Character.toUpperCase(opc) != 'N') {
			tituloMenu();
			System.out.println("INCLUSÃO DE PRODUTO\n");
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
		int opc = 1;
		while (Character.toUpperCase(opc) != 'N') {
			boolean produto_encontrado = false;
			tituloMenu();
			System.out.println("ALTERAÇÃO DE PRODUTO\n");
			System.out.print("INFORME O NOME DO PRODUTO: ");
			String nome = sc.nextLine();
			for (int i=0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO ENCONTRADO!");
					produto_encontrado = true;
					//
					//
					System.out.println("-=-=-=- PRODUTO " + i + " -=-=-=-");
					System.out.println("Nome: " + produtos.get(i).getNome());
					System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
					System.out.println("Unidade: " + produtos.get(i).getUnidade());
					System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
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
						System.out.print("QUANTIDADE A SER ALTERADA:");
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
						break;
					}
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

	private void consultarProduto() {
		Scanner sc = new Scanner(System.in);

		int opc = 1;
		while (Character.toUpperCase(opc) != 'N') {
			boolean produto_encontrado = false;
			tituloMenu();
			System.out.println("CONSULTA DE PRODUTO\n");
			System.out.print("INFORME O NOME DO PRODUTO: ");
			String nome = sc.nextLine();
			for (int i = 0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO ENCONTRADO!");
					produto_encontrado = true;
					//
					//
					System.out.println("-=-=-=- PRODUTO " + i + " -=-=-=-");
					System.out.println("Nome: " + produtos.get(i).getNome());
					System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
					System.out.println("Unidade: " + produtos.get(i).getUnidade());
					System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
					//
					//
				}
			}
			if (!produto_encontrado) {
				System.out.println("PRODUTO NÃO ENCONTRADO!");
			}
			System.out.print("\nREPETIR OPERAÇÃO (S/N)? ");
			opc = sc.next().charAt(0);
			sc.nextLine();
		}
	}

	private void excluirProduto() {
		Scanner sc = new Scanner(System.in);
		int opc = 1;
		while (Character.toUpperCase(opc) != 'N') {
			boolean produto_encontrado = false;
			tituloMenu();
			System.out.println("EXCLUSÃO DE PRODUTO\n");
			System.out.print("INFORME O NOME DO PRODUTO: ");
			String nome = sc.nextLine();
			for (int i = 0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO ENCONTRADO!");
					produto_encontrado = true;
					//
					//
					System.out.println("-=-=-=- PRODUTO " + i + " -=-=-=-");
					System.out.println("Nome: " + produtos.get(i).getNome());
					System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
					System.out.println("Unidade: " + produtos.get(i).getUnidade());
					System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
					//
					//
					System.out.print("DESEJA MESMO EXCLUIR O PRODUTO (S/N)? ");
					char confirmar_exclusao = sc.next().charAt(0);
					while (Character.toUpperCase(confirmar_exclusao) != 'S'
							&& Character.toUpperCase(confirmar_exclusao) != 'N') {
						System.out.println("\nDIGITE UM VALOR VÁLIDO!");
						System.out.println();
						System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
						confirmar_exclusao = sc.next().charAt(0);
					}
					if (Character.toUpperCase(confirmar_exclusao) == 'S') {
						produtos.remove(i);
						break;
					}
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

	private void reajuste() {
		Scanner sc = new Scanner(System.in);
		char opc = 0;

		while (Character.toUpperCase(opc) != 'N') {
			boolean produto_encontrado = false;
			tituloMenu();
			System.out.println("REAJUSTE DE PREÇOS\n");
			System.out.print("PRODUTO: ");
			String nome = sc.nextLine();
			for (int i=0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
					System.out.println("PRODUTO ENCONTRADO!");
					produto_encontrado = true;
					//
					//
					System.out.println("-=-=-=- PRODUTO " + i + " -=-=-=-");
					System.out.println("Nome: " + produtos.get(i).getNome());
					System.out.println("Valor: R$" + produtos.get(i).getPreco_unit());
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
					//
					//
					System.out.print("PERCENTUAL DE REAJUSTE (%): ");
					double percentual = sc.nextDouble();
					while (percentual < 0) {
						System.out.println("\nDIGITE UM VALOR VÁLIDO!");
						System.out.println();
						System.out.print("PERCENTUAL DE REAJUSTE (%): ");
						percentual = sc.nextDouble();
					}
					double percentualSoma = produtos.get(i).getPreco_unit() * (1 + percentual / 100);
					System.out.println("NOVO VALOR UNITARIO DO PRODUTO: R$" + (percentualSoma));
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
						produtos.get(i).setPreco_unit(percentualSoma);
						break;
					}
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

	private void relatorio() {
		int n = 0;
		tituloMenu();
		System.out.println("RELATÓRIO LISTA DE PREÇOS\n");
		if (produtos.isEmpty()) {
			System.out.println("NÃO HÁ PRODUTOS!");
		} else {
			for (Produto produtos : produtos) {
				System.out.println("-=-=-=- PRODUTO " + n + " -=-=-=-");
	            System.out.println("Nome: " + produtos.getNome());
	            System.out.println("Preço Unitario: R$" + produtos.getPreco_unit());
	            System.out.println("Unidade: " + produtos.getUnidade());
	            System.out.println("Quantidade em estoque: " + produtos.getQnt_estoque());
				System.out.println();
	            n++;
	        }
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("\n              FIM DO RELATÓRIO               ");
		}
	}

	private void tituloMenu() {
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\r\n"
							+ "SISTEMA DE CONTROLE DE ESTOQUE");
	}
}


