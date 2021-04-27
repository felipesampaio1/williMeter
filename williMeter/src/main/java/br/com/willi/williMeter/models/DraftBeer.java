package br.com.willi.williMeter.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
public class DraftBeer extends Product{

    private float IBU;
    private String description;
}
