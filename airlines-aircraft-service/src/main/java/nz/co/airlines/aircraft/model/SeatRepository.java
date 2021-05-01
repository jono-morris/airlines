package nz.co.airlines.aircraft.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository  extends JpaRepository<Seat, Integer> {

    Optional<Seat> findByBoardingPassId(Integer boardingPassId);
}
