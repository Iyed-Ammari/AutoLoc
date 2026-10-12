package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final ReservationRepository repository;

    @Override public Reservation addReservation(Reservation reservation) { return repository.save(reservation); }
    @Override public List<Reservation> getAllReservations() { return repository.findAll(); }
    @Override public Reservation getReservationById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        if(repository.existsById(id)) {
            reservation.setIdReservation(id);
            return repository.save(reservation);
        }
        return null;
    }

    @Override public void deleteReservation(Long id) { repository.deleteById(id); }
}