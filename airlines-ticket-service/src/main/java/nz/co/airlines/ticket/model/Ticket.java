package nz.co.airlines.ticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "title")
    @NotEmpty
    private String title;
    
    @Column(name = "surname")
    @NotEmpty
    private String surname;
    
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
