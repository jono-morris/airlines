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
import javax.validation.constraints.Size;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "route")
@Builder(builderMethodName = "route")
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(max = 12)
    @Column(name = "flight_number")
    @NotEmpty
    private String flightNumber;
    
    @Builder.Default
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date departureTime = new Date();

    @ManyToOne
    @JoinColumn(name = "airline_id")
    @JsonIgnore
    private Airline operator;
    
    @ManyToOne
    @JoinColumn(name = "origin_id")
    @JsonIgnore
    private Airport origin;
    
    @ManyToOne
    @JoinColumn(name = "destination_id")
    @JsonIgnore
    private Airport destination;
    
    public Integer getId() {
        return id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
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
    
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("flight_number", this.getFlightNumber())
                .append("departure_time", this.getDepartureTime())
                .append("operator", this.getOperator())
                .append("origin", this.getOrigin())
                .append("destination", this.getDestination())
                .toString();
    }
    
}
