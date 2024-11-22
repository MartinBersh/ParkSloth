package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import co.edu.cue.ParkSloth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST el cual gestiona operaciones relacionadas con los usuarios.
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de los usuarios.
 */

@RestController
@RequestMapping("/User")
public class UserRestController {

    @Autowired
    private UserServices userServices;

    /**
     * Crea un nuevo usuario en el sistema
     * @param userDto, el objeto DTO que contiene los datos del usuario a crear.
     * @return un ResponseEntity con el usuario creado y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userServices.save(userDto));
    }

    /**
     * Actualiza un usuario existente en el sistema.
     * @param userDto El objeto DTO que contiene los datos actualizados del usuario.
     * @return Un ResponseEntity con el usuario actualizado y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userServices.update(userDto));
    }

    /**
     * Obtiene una lista de todos los usuarios registrados en el sistema.
     * @return Un ResponseEntity con la lista de usuarios y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userServices.list());
    }

    /**
     * Actualiza el esatdo de un usuario por su ID.
     * Este metodo permite cambiar el estado, ya sea activo o inactivo de un usuario.
     * @param id El ID del usuario al que se le actualizará el estado.
     * @param newStatus El nuevo estado del usuario.
     * @return Un ResponseEntity con un mensaje de éxito o error si el usuario no se encuentra.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            userServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("User status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
