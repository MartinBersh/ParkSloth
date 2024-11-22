package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.ReservationDto;

import java.util.List;

/**
 * Interfaz para gestionar las reservas.
 */
public interface ReservationServices {

    /**
     * Lista todas las reservas registradas.
     * @return Una lista de ReservationDto.
     */
    List<ReservationDto> list();

    /**
     * Obtiene una reserva por su ID.
     * @param id El ID de la reserva.
     * @return El DTO de la reserva correspondiente.
     */
    ReservationDto getReservationById(int id);

    /**
     * Guarda una nueva reserva.
     * @param reservation El objeto DTO con la información de la reserva a guardar.
     * @return El DTO de la reserva guardada.
     */
    ReservationDto save(ReservationDto reservation);

    /**
     * Actualiza una reserva existente.
     * @param reservation El objeto DTO con la información actualizada.
     * @return El DTO de la reserva actualizada.
     */
    ReservationDto update(ReservationDto reservation);

    /**
     * Elimina una reserva por su ID.
     * @param id El ID de la reserva.
     */
    void delete(int id);

    /**
     * Actualiza el estado de una reserva.
     * @param id El ID de la reserva.
     * @param status El nuevo estado ('A' para activa, 'I' para inactiva).
     */
    void updateStatus(int id, Character status);
}
