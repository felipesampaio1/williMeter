
package br.com.willi.williMeter.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.willi.williMeter.util.InsufficientFundsException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name ="CLIENT")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Client implements Serializable{

     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="ID")
     private long id;

     @OneToMany(mappedBy = "client")
     private List<ClientRequest> clientRequests;

     @NotNull
     @NotBlank
     @Column(name="NAME")
     private String name;

     @Column(name="ADDRESS")
     private String address;

     @NotNull
     @Column(name="CPF", unique = true)
     private String cpf;

     @NotNull
     @Email(message = "Insira um e-mail válido.")
     @Column(name="EMAIL")
     private String email;

     @Column(name="PHONE_NUMBER")
     private String phoneNumber;

     @Column(name="TAG_ID")
     private String tagID;

     @Column(name="BALANCE")
     private BigDecimal balance;
     
     @Column(name = "CREATED_AT")
     private LocalDateTime createdAt;     
     
     @Column(name = "UPDATED_AT")
     private LocalDateTime updatedAt;       

     public void debitBalance(BigDecimal productPrice) throws InsufficientFundsException {
          
          if(this.balance != null && balance.subtract(productPrice).intValue() < 0) {
               throw new InsufficientFundsException();
          }
          
          this.balance.subtract(productPrice);

     }

}
