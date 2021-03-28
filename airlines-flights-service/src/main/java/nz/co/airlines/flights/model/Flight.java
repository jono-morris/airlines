package nz.co.airlines.flights.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonIgnore
    private Route route;    
    
    @Column(name = "code")
    @NotEmpty
    private Date departureDate;

    public Integer getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public Date getDepartureDate() {
        return departureDate;
    }
    
}
