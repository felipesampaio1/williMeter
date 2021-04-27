package br.com.willi.williMeter.models;

import br.com.willi.williMeter.util.InsufficientFundsException;
import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy = "client")
	private List<ClientRequest> clientRequests;
	@NotNull
	@NotBlank
	private String name;
	private String address;
	@NotNull
	@Column(unique = true)
	private String CPF;
	@NotNull
	@Email(message = "Insira um e-mail válido.")
	private String email;
	private String phoneNumber;
	private String tagID;
	private float balance;

	public void debitBalance(float productPrice) throws InsufficientFundsException {
		if (balance - productPrice < 0)
			throw new InsufficientFundsException();
		this.balance -= productPrice;

	}

	
}
