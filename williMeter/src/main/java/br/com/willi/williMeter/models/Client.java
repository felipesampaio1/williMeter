package br.com.willi.williMeter.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Client implements Serializable {
	
	//private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy = "client")
	private List<UserOrder> userOrders;
	private String name;
	private String address;
	@Id
	private String CPF;
	private String email;
	private String phoneNumber;
	private String tagID;
	private float balance;

	
}
