package br.com.willi.williMeter.models;

import br.com.willi.williMeter.util.InsufficientFundsException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ClientRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToMany
	@JoinTable(name = "order_products",
			joinColumns = @JoinColumn(name="userOrder_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;
	@DateTimeFormat(pattern	= "dd-MM-yyyy")
	private Date data;
	@ManyToOne
	private Client client;
	private float value;
	private int table;
	@Setter(AccessLevel.PRIVATE)
	private Payment typePayment;
	private Status status;

	private enum Status{
		OPEN, CLOSED
	}

	private enum Payment{
		PREPAID, POSTPAID
	}

	public ClientRequest(Client client, Product product, Payment payment) {
		this.status = Status.OPEN;
		this.products.add(product);
		this.data = new Date();
		this.client = client;
		this.typePayment = payment;
		CalculateOrderValue(product);
	}

	private void CalculateOrderValue(Product product) {
		if (typePayment == Payment.POSTPAID) {
			this.value = 0;
			for (int i = 0; i < products.size(); i++)
				value += ((Product) products).getPrice();
		}
		else {
			try {
				getClient().debitBalance(product.getPrice());
				setStatus(Status.CLOSED);
			} catch (InsufficientFundsException e){
				//Em caso de falta de fundos remove o produto.
				products.remove(product);
				//arrumar uma forma de enviar a exception para a view!
			}
		}
	}
	
	public void addProduct(Product product) {
		products.add(product);
		CalculateOrderValue(product);
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
		CalculateOrderValue(product);
	}
}
