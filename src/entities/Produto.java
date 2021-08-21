package entities;

public class Produto {

	private String nome;
	private double preco_unit;
	private String unidade;
	private int qnt_estoque;
	
	public Produto(String nome, double preco_unit, String unidade, int qnt_estoque) {
		this.nome = nome;
		this.preco_unit = preco_unit;
		this.unidade = unidade;
		this.qnt_estoque = qnt_estoque;
	}

	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public double getPreco_unit() {
		return preco_unit;
	}

	public String getUnidade() {
		return unidade;
	}

	public int getQnt_estoque() {
		return qnt_estoque;
	}

	public boolean equals(Object obj) {
		//se nao forem objetos da mesma classe sao objetos diferentes
		if(!(obj instanceof Produto)) return false;
		//se forem o mesmo objeto, retorna true
		if(obj == this) return true;
		// aqui o cast é seguro por causa do teste feito acima
		Produto produto = (Produto) obj;
		//aqui você compara a seu gosto, o ideal é comparar atributo por atributo
		return this.nome.equals(produto.getNome());
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
