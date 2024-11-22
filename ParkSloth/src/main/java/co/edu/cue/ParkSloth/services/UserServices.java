package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.UserDto;

import java.util.List;

/**
 * Interfaz para gestionar los usuarios.
 */
public interface UserServices {

    /**
     * Lista todos los usuarios registrados.
     * @return Una lista de UserDto.
     */
    List<UserDto> list();

    /**
     * Obtiene un usuario por su ID.
     * @param id El ID del usuario.
     * @return El DTO del usuario correspondiente.
     */
    UserDto getUserById(int id);

    /**
     * Guarda un nuevo usuario.
     * @param user El objeto DTO con la información del usuario a guardar.
     * @return El DTO del usuario guardado.
     */
    UserDto save(UserDto user);

    /**
     * Actualiza un usuario existente.
     * @param user El objeto DTO con la información actualizada.
     * @return El DTO del usuario actualizado.
     */
    UserDto update(UserDto user);

    /**
     * Elimina un usuario por su ID.
     * @param id El ID del usuario.
     */
    void delete(int id);

    /**
     * Actualiza el estado de un usuario.
     * @param id El ID del usuario.
     * @param status El nuevo estado ('A' para activo, 'I' para inactivo).
     */
    void updateStatus(int id, Character status);
    UserDto getUserByUsernameAndPassword(String username, String password);
}
