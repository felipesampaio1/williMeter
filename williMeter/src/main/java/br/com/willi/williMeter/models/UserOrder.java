package br.com.willi.williMeter.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToMany
	@JoinTable(name = "order_products",
			joinColumns = @JoinColumn(name="userOrder_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	private Date data;
	@ManyToOne
	private Client client;
	private float value;

	public UserOrder(Client client, List<Product> products) {
		this.products = products;
		this.data = new Date();
		this.client = client;
		CalculateOrderValue();
	}

	private void CalculateOrderValue() {
		for (int i = 0; i < products.size(); i++)
			value += ((Product) products).getPrice();
	}
	
	public void addProduct(Product product) {
		products.add(product);
		CalculateOrderValue();
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
		CalculateOrderValue();
	}
}
