package br.com.willi.williMeter.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id
	private int numero;
	@ManyToMany
	private List<Produto> produtos;
	private Date data;
	@ManyToOne
	private Cliente cliente;
	private float total;
	
	public Pedido(Cliente cliente, List<Produto> produtos) {
		this.produtos = produtos;
		this.data = new Date();
		this.cliente = cliente;
		calculaTotal();
	}

	
	private void calculaTotal() {
		for (int i=0; i < produtos.size(); i++)
			total += ((Produto) produtos).getPreco();	
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
		calculaTotal();
	}
	
	public void removeProduto(Produto produto) {
		produtos.remove(produto);
		calculaTotal();
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
