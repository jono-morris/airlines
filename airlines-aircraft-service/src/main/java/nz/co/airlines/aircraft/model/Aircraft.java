package nz.co.airlines.aircraft.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "flight_id")
    @NotEmpty
    private Integer flightId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aircraft")
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
}


