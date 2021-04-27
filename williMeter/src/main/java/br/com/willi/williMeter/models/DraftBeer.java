
package br.com.willi.williMeter.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DRAFT_BEER")
public class DraftBeer extends Product implements Serializable{

     private static final long serialVersionUID = -4294392434848090289L;

     @Column(name = "IBU")
     private Long IBU;

     @Column(name = "DESCRIPTION")
     private String description;
     
}
