package nz.co.airlines.ticket.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
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

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ticket")
    private Set<BoardingPass> boardingPass;
    
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

    public Integer getId() {
        return id;
    }
    
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getFare() {
        return fare;
    }
    
    protected Set<BoardingPass> getBoardingPassesInternal() {
        if (this.boardingPass == null) {
            this.boardingPass = new HashSet<>();
        }
        return this.boardingPass;
    }
    
    public List<BoardingPass> getBoardingPasses() {
        final List<BoardingPass> sortedBoardingPass = new ArrayList<>(getBoardingPassesInternal());
        return Collections.unmodifiableList(sortedBoardingPass);
    }
    
    public void addBoardingPass(BoardingPass flight) {
        getBoardingPasses().add(flight);
    }
}
