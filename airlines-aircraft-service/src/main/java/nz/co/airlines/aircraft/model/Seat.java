package nz.co.airlines.aircraft.model;

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
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "boarding_pass_id")
    @NotEmpty
    private Integer boardingPassId;
    
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    @JsonIgnore
    private Aircraft aircraft;
    
    @Column(name = "number")
    @NotEmpty
    private String number;

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Integer getBoardingPassId() {
        return boardingPassId;
    }
    
    public Aircraft getAircraft() {
        return aircraft;
    }
}
