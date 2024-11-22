package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDayDto;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import co.edu.cue.ParkSloth.services.ScheduleDayServices;
import co.edu.cue.ParkSloth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de días de programación (Schedule Days).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de los días de programación.
 */

@RestController
@RequestMapping("/ScheduleDay")
public class ScheduleDayController {
    @Autowired
    private ScheduleDayServices scheduleDayServices;

    /**
     * Crea un nuevo día de programación.
     * @param scheduleDayDto Objeto DTO que contiene los datos del día de programación a crear.
     * @return Un ResponseEntity con el día de programación creado y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<ScheduleDayDto> createScheduleDay(@RequestBody ScheduleDayDto scheduleDayDto) {
        return ResponseEntity.ok(scheduleDayServices.save(scheduleDayDto));
    }

    /**
     * Actualiza un día de programación existente.
     * @param scheduleDayDto Objeto DTO que contiene los datos actualizados del día de programación.
     * @return Un ResponseEntity con el día de programación actualizado y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<ScheduleDayDto> updateScheduleDay(@RequestBody ScheduleDayDto scheduleDayDto) {
        return ResponseEntity.ok(scheduleDayServices.update(scheduleDayDto));
    }

    /**
     * Recupera una lista de todos los días de programación registrados.
     * @return Un ResponseEntity con la lista de días de programación y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<ScheduleDayDto>> getScheduleDay() {
        return ResponseEntity.ok(scheduleDayServices.list());
    }

    /**
     * Actualiza el estado de un día de programación (activo/inactivo) por su ID.
     * @param id El ID del día de programación a actualizar.
     * @param newStatus El nuevo estado del día de programación ('A' para activo, 'I' para inactivo).
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra el día de programación.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            scheduleDayServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("ScheduleDay status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ScheduleDay not found");
        }
    }
}
