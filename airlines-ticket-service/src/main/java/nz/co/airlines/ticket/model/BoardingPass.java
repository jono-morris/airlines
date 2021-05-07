package nz.co.airlines.ticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "boarding_pass")
public class BoardingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @JsonIgnore
    private Ticket ticket;

    @Column(name = "flight_id")
    @NotEmpty
    private Integer flightId;

    @Column(name = "seat_id")
    @NotEmpty
    private Integer seatId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotEmpty
    private Status status;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "seat_class")
    @NotEmpty
    private SeatClass seatClass;
    
    public Integer getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }
    
    public Integer getFlightId() {
        return flightId;
    }

    public Status getStatus() {
        return status;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }
}

enum Status {
    CHECKED_IN,
    BOARDED,
    BOOKED;
}

enum SeatClass {
    ECONOMY,
    BUSINESS,
    FIRST;
}