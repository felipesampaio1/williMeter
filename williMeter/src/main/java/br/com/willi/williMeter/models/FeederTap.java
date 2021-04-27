package br.com.willi.williMeter.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class FeederTap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date feedDate, endDate;
    @OneToOne
    @JoinColumn(name = "draftBeer_id", referencedColumnName = "id")
    private DraftBeer draftBeer;
    @OneToOne
    @JoinColumn(name = "tap_id", referencedColumnName = "id")
    private Tap tap;


}
