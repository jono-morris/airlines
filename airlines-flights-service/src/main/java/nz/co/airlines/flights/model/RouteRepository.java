package nz.co.airlines.flights.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Integer> { 
    
}

