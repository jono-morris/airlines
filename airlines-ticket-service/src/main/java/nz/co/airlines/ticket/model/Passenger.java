package nz.co.airlines.ticket.model;

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

import nz.co.airlines.flights.model.Flight;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "title")
    @NotEmpty
    private String title;
    
    @Column(name = "surname")
    @NotEmpty
    private String surname;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
    private Set<Ticket> tickets;
    
    @Column(name = "initial")
    @NotEmpty
    private char initial;

    public String getTitle() {
        return title;
    }

    public String getSurname() {
        return surname;
    }

    public char getInitial() {
        return initial;
    }
}
