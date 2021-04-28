package nz.co.airlines.aircraft.model;

import java.util.ArrayList;
import java.util.Collections;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "flight_id")
    @NotEmpty
    private Integer flightId;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aircraft")
    private Set<Seat> seats;
    
    @Column(name = "registration_number")
    @NotEmpty
    private String registrationNumber;
    
    @Column(name = "aircraft_type")
    @NotEmpty
    private String aircraftType;
    
    @Column(name = "description")
    @NotEmpty
    private String description;
    
    public Integer getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getDescription() {
        return description;
    }
    
    public List<Seat> getSeats() {
        final List<Seat> sortedSeats = new ArrayList<>(getSeatsInternal());
        PropertyComparator.sort(sortedSeats, new MutableSortDefinition("number", true, true));
        return Collections.unmodifiableList(sortedSeats);
    }
    
    protected Set<Seat> getSeatsInternal() {
        if (this.seats == null) {
            this.seats = new HashSet<>();
        }
        return this.seats;
    }
}


