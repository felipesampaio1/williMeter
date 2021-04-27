
package br.com.willi.williMeter.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "PRODUCT")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Product{

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;

     @Column(name = "NAME")
     private String name;

     @Column(name = "PRICE")
     private BigDecimal price;

     @Column(name = "QUANTITY")
     private Long quantity;
     
     @Column(name = "CREATED_AT")
     private LocalDateTime createdAt;     
     
     @Column(name = "UPDATED_AT")
     private LocalDateTime updatedAt;  

}
