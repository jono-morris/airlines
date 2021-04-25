package nz.co.airlines.ticket.model;

import java.math.BigDecimal;
import java.util.Currency;
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

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "date_of_issue", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @NotEmpty
    private Date dateOfIssue;
    
    @Column(name = "currency")
    @NotEmpty
    private Currency currency;
    
    @Column(name = "fare")
    @NotEmpty
    private BigDecimal fare;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;    
    
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getFare() {
        return fare;
    }
    
    
}
