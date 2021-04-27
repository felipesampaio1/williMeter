
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
@Table(name = "TAPS")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Tap implements Serializable{

     private static final long serialVersionUID = 2370228010046107597L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;

     @OneToOne(mappedBy = "tap")
     private FeederTap feederTap;
     
     @Column(name = "CREATED_AT")
     private LocalDateTime createdAt;     
     
     @Column(name = "UPDATED_AT")
     private LocalDateTime updatedAt;  

}
