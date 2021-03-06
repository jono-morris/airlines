package nz.co.airlines.flights.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(max = 12)
    @Column(name = "flight_number")
    @NotEmpty
    private String flightNumber;
    
    @Column(name = "scheduled_departure_time")
    @Temporal(TemporalType.TIME)
    @NotEmpty
    private Date scheduledDepartureTime;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "route")
    @JsonIgnore
    private Set<Flight> flights;
    
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline operator;
    
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport origin;
    
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;
    
    public Integer getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getScheduledDepartureTime() {
        return scheduledDepartureTime;
    }

    public Airline getOperator() {
        return operator;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }
    
    protected Set<Flight> getFlightsInternal() {
        if (this.flights == null) {
            this.flights = new HashSet<>();
        }
        return this.flights;
    }
    
    public List<Flight> getFlights() {
        final List<Flight> sortedFlights = new ArrayList<>(getFlightsInternal());
        PropertyComparator.sort(sortedFlights, new MutableSortDefinition("departureDate", true, true));
        return Collections.unmodifiableList(sortedFlights);
    }
    
    public void addFlight(Flight flight) {
        getFlightsInternal().add(flight);
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("flight_number", this.getFlightNumber())
                .append("departure_time", this.getScheduledDepartureTime())
                .append("operator", this.getOperator())
                .append("origin", this.getOrigin())
                .append("destination", this.getDestination())
                .toString();
    }
}
