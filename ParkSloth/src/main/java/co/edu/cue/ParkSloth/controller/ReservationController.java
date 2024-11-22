package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.ReservationDto;
import co.edu.cue.ParkSloth.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de reservas (Reservations).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de las reservas.
 */

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
    @Autowired
    private ReservationServices reservationServices;

    /**
     * Crea una nueva reserva.
     * @param reservationDto Objeto DTO que contiene los datos de la reserva a crear.
     * @return Un ResponseEntity con la reserva creada y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationServices.save(reservationDto));
    }

    /**
     * Actualiza una reserva existente.
     * @param reservationDto Objeto DTO que contiene los datos actualizados de la reserva.
     * @return Un ResponseEntity con la reserva actualizada y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<ReservationDto> updateReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationServices.update(reservationDto));
    }

    /**
     * Recupera una lista de todas las reservas registradas.
     * @return Un ResponseEntity con la lista de reservas y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<ReservationDto>> getReservation() {
        return ResponseEntity.ok(reservationServices.list());
    }


    /**
     * Actualiza el estado de una reserva (activo/inactivo) por su ID.
     * @param id El ID de la reserva a actualizar.
     * @param newStatus El nuevo estado de la reserva ('A' para activa, 'I' para inactiva).
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra la reserva.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            reservationServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("Reservation status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
        }
    }
}
