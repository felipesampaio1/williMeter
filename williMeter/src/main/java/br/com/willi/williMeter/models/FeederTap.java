
package br.com.willi.williMeter.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "FEEDER_TAP")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class FeederTap implements Serializable{

     private static final long serialVersionUID = 1174186417893371556L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;

     @Column(name = "FEED_DATE")
     private LocalDateTime feedDate;
     
     @Column(name = "END_DATE")
     private LocalDateTime endDate;

     @OneToOne
     @JoinColumn(name = "draftBeer_id", referencedColumnName = "id")
     private DraftBeer draftBeer;

     @OneToOne
     @JoinColumn(name = "tap_id", referencedColumnName = "id")
     private Tap tap;

}
