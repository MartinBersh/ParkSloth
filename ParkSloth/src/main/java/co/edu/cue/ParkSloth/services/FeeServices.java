package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.FeeDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para gestionar las tarifas.
 */
public interface FeeServices {

    /**
     * Lista todas las tarifas registradas.
     * @return Una lista de FeeDto.
     */
    List<FeeDto> list();

    /**
     * Obtiene una tarifa por su ID.
     * @param id El ID de la tarifa.
     * @return Un Optional que contiene la tarifa si existe.
     */
    Optional<FeeDto> getFeeById(int id);

    /**
     * Guarda una nueva tarifa.
     * @param fee El objeto DTO con la información de la tarifa a guardar.
     * @return El DTO de la tarifa guardada.
     */
    FeeDto save(FeeDto fee);

    /**
     * Actualiza una tarifa existente.
     * @param fee El objeto DTO con la información actualizada.
     * @return El DTO de la tarifa actualizada.
     */
    FeeDto update(FeeDto fee);

    /**
     * Elimina una tarifa por su ID.
     * @param id El ID de la tarifa.
     */
    void delete(int id);

    /**
     * Actualiza el estado de una tarifa.
     * @param id El ID de la tarifa.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
}
