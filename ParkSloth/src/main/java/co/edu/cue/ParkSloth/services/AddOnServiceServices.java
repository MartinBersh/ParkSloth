package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.AddOnServiceDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para gestionar los servicios adicionales.
 */
public interface AddOnServiceServices {

    /**
     * Lista todos los servicios adicionales registrados.
     * @return Una lista de AddOnServiceDto.
     */
    List<AddOnServiceDto>  list();

    /**
     * Obtiene un servicio adicional por su ID.
     * @param id El ID del servicio adicional.
     * @return Un Optional que contiene el servicio si existe.
     */
    Optional<AddOnServiceDto> getAddOnServiceById(int id);

    /**
     * Guarda un nuevo servicio adicional.
     * @param addOnService El objeto DTO con la información del servicio adicional a guardar.
     * @return El DTO del servicio adicional guardado.
     */
    AddOnServiceDto save(AddOnServiceDto addOnService);

    /**
     * Actualiza un servicio adicional existente.
     * @param addOnService El objeto DTO con la información actualizada.
     * @return El DTO del servicio adicional actualizado.
     */
    AddOnServiceDto update(AddOnServiceDto addOnService);

    /**
     * Elimina un servicio adicional por su ID.
     * @param id El ID del servicio adicional.
     */
    void delete(int id);

    /**
     * Actualiza el estado de un servicio adicional.
     * @param id El ID del servicio adicional.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
}
