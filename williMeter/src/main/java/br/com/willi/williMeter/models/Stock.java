package br.com.willi.williMeter.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Product product;
    private Date date;
    private float quantity;

    public Stock (float quantity, Product product){
        this.quantity = quantity;
        product.setQuantity(product.getQuantity() + quantity);
        this.date = new Date();
    }

}
