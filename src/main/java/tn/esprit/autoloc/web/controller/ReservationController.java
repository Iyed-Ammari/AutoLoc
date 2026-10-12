package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService service;

    @PostMapping public Reservation addReservation(@RequestBody Reservation reservation) { return service.addReservation(reservation); }
    @GetMapping public List<Reservation> getAllReservations() { return service.getAllReservations(); }
    @GetMapping("/{id}") public Reservation getReservationById(@PathVariable Long id) { return service.getReservationById(id); }
    @PutMapping("/{id}") public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) { return service.updateReservation(id, reservation); }
    @DeleteMapping("/{id}") public void deleteReservation(@PathVariable Long id) { service.deleteReservation(id); }
}