
package br.com.willi.williMeter.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.willi.williMeter.repository.dto.ClientRequestPaymentType;
import br.com.willi.williMeter.repository.dto.ClientRequestStatus;
import br.com.willi.williMeter.util.InsufficientFundsException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name ="CLIENT_REQUEST")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class ClientRequest implements Serializable{

     private static final long serialVersionUID = 3043817694523246476L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;

     @ManyToMany
     @JoinTable(name = "CLIENT_REQUEST_PRODUCTS", joinColumns = { @JoinColumn(name = "ID_CLIENT_REQUEST") }, inverseJoinColumns = { @JoinColumn(name = "ID_PRODUCTS") })
     @Transient
     private List<Product> products;

     @DateTimeFormat(pattern = "dd-MM-yyyy")
     @Column(name = "DATA")
     private LocalDateTime data;

     @ManyToOne
     @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
     private Client client;

     @Column(name = "AMOUNT")
     private BigDecimal amount;

     @Column(name = "TABELA")
     private Integer tabela;

     @Column(name = "TYPE_PAYMENT")
     private ClientRequestPaymentType paymentType;

     @Column(name = "STATUS")
     private ClientRequestStatus status;

     @Column(name = "CREATED_AT")
     private LocalDateTime createdAt;     
     
     @Column(name = "UPDATED_AT")
     private LocalDateTime updatedAt;     

     public ClientRequest(Client client, Product product, ClientRequestPaymentType paymentType){

          this.status = ClientRequestStatus.OPEN;
          this.products.add(product);
          this.data = LocalDateTime.now();
          this.client = client;
          this.paymentType = paymentType;
          CalculateOrderValue(product);
     }

     private void CalculateOrderValue(Product product) {

          if (paymentType == ClientRequestPaymentType.POSTPAID) {
               
               this.amount = BigDecimal.ZERO;
               
               if(Objects.nonNull(products)) {
                    
                    products.forEach(p -> {
                         amount.add(p.getPrice());
                    });
                    
               }
               
          } else {
               
               try {
                    
                    getClient().debitBalance(product.getPrice());
                    setStatus(ClientRequestStatus.CLOSED);
                    
               } catch (InsufficientFundsException e) {
                    // Em caso de falta de fundos remove o produto.
                    products.remove(product);
                    // arrumar uma forma de enviar a exception para a view!
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
