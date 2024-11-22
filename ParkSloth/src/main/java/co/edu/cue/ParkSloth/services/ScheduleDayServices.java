package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDayDto;

import java.util.List;

/**
 * Interfaz para gestionar los días de horario.
 */
public interface ScheduleDayServices {

    /**
     * Lista todos los días de horario registrados.
     * @return Una lista de ScheduleDayDto.
     */
    List<ScheduleDayDto> list();
    /**
     * Guarda un nuevo día de horario.
     * @param scheduleDay El objeto DTO con la información del día de horario a guardar.
     * @return El DTO del día de horario guardado.
     */
    ScheduleDayDto save(ScheduleDayDto scheduleDay);

    /**
     * Actualiza un día de horario existente.
     * @param scheduleDay El objeto DTO con la información actualizada.
     * @return El DTO del día de horario actualizado.
     */
    ScheduleDayDto update(ScheduleDayDto scheduleDay);

    /**
     * Elimina un día de horario por su ID.
     * @param id El ID del día de horario.
     */
    void delete(int id);

    /**
     * Actualiza el estado de un día de horario.
     * @param id El ID del día de horario.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
}
