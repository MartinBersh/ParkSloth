package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDto;

import java.util.List;

/**
 * Interfaz para gestionar los horarios.
 */
public interface ScheduleServices {

    /**
     * Lista todos los horarios registrados.
     * @return Una lista de ScheduleDto.
     */
    List<ScheduleDto> list();

    /**
     * Obtiene un horario por su ID.
     * @param id El ID del horario.
     * @return El DTO del horario correspondiente.
     */
    ScheduleDto getScheduleById(int id);

    /**
     * Guarda un nuevo horario.
     * @param schedule El objeto DTO con la información del horario a guardar.
     * @return El DTO del horario guardado.
     */
    ScheduleDto save(ScheduleDto schedule);

    /**
     * Actualiza un horario existente.
     * @param schedule El objeto DTO con la información actualizada.
     * @return El DTO del horario actualizado.
     */
    ScheduleDto update(ScheduleDto schedule);

    /**
     * Elimina un horario por su ID.
     * @param id El ID del horario.
     */
    void delete(int id);

    /**
     * Actualiza el estado de un horario.
     * @param id El ID del horario.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
}
