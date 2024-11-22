package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.domain.entities.Slot;
import co.edu.cue.ParkSloth.mapping.dtos.SlotDto;

import java.util.List;

/**
 * Interfaz para gestionar los espacios de parqueo.
 */
public interface SlotServices {

    /**
     * Lista todos los espacios de parqueo registrados.
     * @return Una lista de SlotDto.
     */
    List<SlotDto> list();

    /**
     * Obtiene un espacio de parqueo por su ID.
     * @param id El ID del espacio de parqueo.
     * @return El DTO del espacio de parqueo correspondiente.
     */
    SlotDto getSlotById(int id);

    /**
     * Guarda un nuevo espacio de parqueo.
     * @param slot El objeto DTO con la información del espacio de parqueo a guardar.
     * @return El DTO del espacio de parqueo guardado.
     */
    SlotDto save(SlotDto slot);

    /**
     * Actualiza un espacio de parqueo existente.
     * @param slot El objeto DTO con la información actualizada.
     * @return El DTO del espacio de parqueo actualizado.
     */
    SlotDto update(SlotDto slot);

    /**
     * Elimina un espacio de parqueo por su ID.
     * @param id El ID del espacio de parqueo.
     */
    void delete(int id);

    /**
     * Actualiza el estado de un espacio de parqueo.
     * @param id El ID del espacio de parqueo.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
}
