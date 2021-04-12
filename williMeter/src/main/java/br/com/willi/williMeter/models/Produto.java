package br.com.willi.williMeter.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	private static int codigo;
	private String nome;
	private float preco;
	private int estoque;
		
	
	public Produto(String nome){
		this.preco = 0;
		this.estoque = 0;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	
	
	

}
