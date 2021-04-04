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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;    
    
    @Column(name = "departureDateTime", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @NotEmpty
    private Date departureDateTime;
    
    public Integer getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }
    
    public Date getDepartureDateTime() {
        return departureDateTime;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("route", this.getRoute())
                .append("departure_time", this.getDepartureDateTime())
                .toString();
    }
}
