package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.SlotDto;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import co.edu.cue.ParkSloth.services.SlotServices;
import co.edu.cue.ParkSloth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de Slots (espacios o bloques de tiempo).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de los slots.
 */

@RestController
@RequestMapping("/Slot")
public class SlotController {
    @Autowired
    private SlotServices slotServices;

    /**
     * Crea un nuevo slot.
     * @param slotDto Objeto DTO que contiene los datos del slot a crear.
     * @return Un ResponseEntity con el slot creado y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<SlotDto> createSlot(@RequestBody SlotDto slotDto) {
        return ResponseEntity.ok(slotServices.save(slotDto));
    }

    /**
     * Actualiza un slot existente.
     * @param slotDto Objeto DTO que contiene los datos actualizados del slot.
     * @return Un ResponseEntity con el slot actualizado y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<SlotDto> updateSlot(@RequestBody SlotDto slotDto) {
        return ResponseEntity.ok(slotServices.update(slotDto));
    }

    /**
     * Recupera una lista de todos los slots registrados.
     * @return Un ResponseEntity con la lista de slots y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<SlotDto>> getSlot() {
        return ResponseEntity.ok(slotServices.list());
    }

    /**
     * Actualiza el estado de un slot (activo/inactivo) por su ID.
     * @param id El ID del slot a actualizar.
     * @param newStatus El nuevo estado del slot.
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra el slot.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            slotServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("Slot status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Slot not found");
        }
    }
}
