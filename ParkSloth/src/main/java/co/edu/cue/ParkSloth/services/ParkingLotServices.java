package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.ParkingLotDto;

import java.util.List;

/**
 * Interfaz para gestionar los estacionamientos.
 */
public interface ParkingLotServices {

    /**
     * Lista todos los estacionamientos registrados.
     * @return Una lista de ParkingLotDto.
     */
    List<ParkingLotDto> list();

    /**
     * Obtiene un estacionamiento por su ID.
     * @param id El ID del estacionamiento.
     * @return El DTO del estacionamiento correspondiente.
     */
    ParkingLotDto getParkingLotById(int id);

    /**
     * Guarda un nuevo estacionamiento.
     * @param parkingLot El objeto DTO con la información del estacionamiento a guardar.
     * @return El DTO del estacionamiento guardado.
     */
    ParkingLotDto save(ParkingLotDto parkingLot);

    /**
     * Actualiza un estacionamiento existente.
     * @param parkingLot El objeto DTO con la información actualizada.
     * @return El DTO del estacionamiento actualizado.
     */
    ParkingLotDto update(ParkingLotDto parkingLot);

    /**
     * Elimina un estacionamiento por su ID.
     * @param id El ID del estacionamiento.
     */
    void delete(int id);

    /**
     * Actualiza el estado de un estacionamiento.
     * @param id El ID del estacionamiento.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
}
