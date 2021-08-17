package entities;

import java.util.ArrayList;

public class Produto {
	
	
	private String nome;
	private double preco_unit;
	private int unidade;
	private int qnt_estoque;
	
	public Produto(String nome, double preco_unit, int unidade, int qnt_estoque) {
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

	public int getUnidade() {
		return unidade;
	}

	public int getQnt_estoque() {
		return qnt_estoque;
	}

	
}
