package nz.co.airlines.ticket.model;

import org.springframework.data.jpa.repository.JpaRepository; 

public interface PassengerRespository extends JpaRepository <Passenger, Integer> {

}
