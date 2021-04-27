
package br.com.willi.williMeter.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "STOCKS")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Stock implements Serializable{

     private static final long serialVersionUID = 5678683537277444820L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;

     @Column(name = "DATA")
     private LocalDateTime date;

     @Column(name = "QUANTITY")
     private Long quantity;
     
     @OneToOne
     private Product product;
     
     @Column(name = "CREATED_AT")
     private LocalDateTime createdAt;     
     
     @Column(name = "UPDATED_AT")
     private LocalDateTime updatedAt;       

     public Stock(Long quantity, Product product){

          this.quantity = quantity;
          product.setQuantity(product.getQuantity() + quantity);
          this.date = LocalDateTime.now();
     }

}
