package nz.co.airlines.aircraft.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository  extends JpaRepository<Seat, Integer> {

    Seat findByBoardingPassId(Integer boardingPassId);
}
