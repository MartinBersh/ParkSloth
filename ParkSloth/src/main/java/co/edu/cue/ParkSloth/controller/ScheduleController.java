package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.FeeDto;
import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDto;
import co.edu.cue.ParkSloth.services.FeeServices;
import co.edu.cue.ParkSloth.services.ScheduleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de programaciones (Schedules).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de las programaciones.
 */

@RestController
@RequestMapping("/Schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServices scheduleServices;

    /**
     * Crea una nueva programación
     * @param scheduleDto Objeto DTO que contiene los datos de la programación a crear.
     * @return Un ResponseEntity con la programación creada y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        return ResponseEntity.ok(scheduleServices.save(scheduleDto));
    }

    /**
     * Actualiza una programación existente.
     * @param scheduleDto Objeto DTO que contiene los datos actualizados de la programación.
     * @return Un ResponseEntity con la programación actualizada y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<ScheduleDto> updateSchedule(@RequestBody ScheduleDto scheduleDto) {
        return ResponseEntity.ok(scheduleServices.update(scheduleDto));
    }

    /**
     * Recupera una lista de todas las programaciones registradas.
     * @return Un ResponseEntity con la lista de programaciones y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<ScheduleDto>> getSchedule() {
        return ResponseEntity.ok(scheduleServices.list());
    }

    /**
     * Actualiza el estado de una programación (activo/inactivo) por su ID.
     * @param id El ID de la programación a actualizar.
     * @param newStatus El nuevo estado de la programación ('A' para activo, 'I' para inactivo).
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra la programación.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            scheduleServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("Schedule status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Schedule not found");
        }
    }

}
