package br.com.willi.williMeter.models;

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
	
	//private static final long serialVersionUID = 1L;

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

	
}
