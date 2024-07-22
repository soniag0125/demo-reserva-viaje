package com.sguama.book_trip.infrastructure.adapters;

import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.domain.model.Flight;
import com.sguama.book_trip.infrastructure.entities.FlightEntity;
import com.sguama.book_trip.infrastructure.entities.mappers.FlightMapper;
import com.sguama.book_trip.infrastructure.respositories.FlightJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.sguama.book_trip.domain.common.Constants.ACTIVE_BOOKING;

@Repository
public class FlightRepositoryJpa implements IFlightRepository {

    @Autowired
    private FlightJpaRepository flightJpaRepository;

    @Override
    public Flight getFlightById(Long id) {
        FlightEntity flightEntity =
                flightJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("No found"));
        return FlightMapper.entityToDomain(flightEntity);
    }

    @Override
    public FlightEntity save(FlightEntity flightEntity) {
        return flightJpaRepository.save(flightEntity);
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        List<FlightEntity> flightEntities = flightJpaRepository.findAll();
        return flightEntities.stream()
                .filter(flight -> flight.getStatus().equals(ACTIVE_BOOKING)).collect(Collectors.toList());
    }
}
