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
    
    @Column(name = "aircraft_id")
    @NotEmpty
    private Integer aircraftId;
    
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    @NotEmpty
    private Date departureDate;

    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    
    public Integer getId() {
        return id;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }
    
    public Route getRoute() {
        return route;
    }
    
    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("route", this.getRoute())
                .append("departure_date", this.getDepartureDate())
                .append("departure_time", this.getDepartureTime())
                .toString();
    }
}
