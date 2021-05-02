package nz.co.airlines.ticket.model;

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
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "passenger")
    private Set<Ticket> tickets;
    
    @Column(name = "title")
    @NotEmpty
    private String title;
    
    @Column(name = "surname")
    @NotEmpty
    private String surname;
    
    @Column(name = "initial")
    @NotEmpty
    private char initial;

    public Integer getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getSurname() {
        return surname;
    }

    public char getInitial() {
        return initial;
    }
    
    public List<Ticket> getTickets() {
        final List<Ticket> sortedTickets = new ArrayList<>(getTicketsInternal());
        PropertyComparator.sort(sortedTickets, new MutableSortDefinition("number", true, true));
        return Collections.unmodifiableList(sortedTickets);
    }
    
    protected Set<Ticket> getTicketsInternal() {
        if (this.tickets == null) {
            this.tickets = new HashSet<>();
        }
        return this.tickets;
    }
}
