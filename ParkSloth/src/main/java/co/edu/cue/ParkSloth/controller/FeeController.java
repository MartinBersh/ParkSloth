package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.FeeDto;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import co.edu.cue.ParkSloth.services.FeeServices;
import co.edu.cue.ParkSloth.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de tarifas (Fees).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de las tarifas.
 */
@RestController
@RequestMapping("/Fee")
public class FeeController {
    @Autowired
    private FeeServices feeServices;

    /**
     * Crea una nueva tarifa.
     * @param feeDto Objeto DTO que contiene los datos de la tarifa a crear.
     * @return Un ResponseEntity con la tarifa creada y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<FeeDto> createFee(@RequestBody FeeDto feeDto) {
        return ResponseEntity.ok(feeServices.save(feeDto));
    }

    /**
     * Actualiza una tarifa existente.
     * @param feeDto Objeto DTO que contiene los datos actualizados de la tarifa.
     * @return Un ResponseEntity con la tarifa actualizada y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<FeeDto> updateFee(@RequestBody FeeDto feeDto) {
        return ResponseEntity.ok(feeServices.update(feeDto));
    }


    /**
     * Recupera una lista de todas las tarifas registradas.
     * @return Un ResponseEntity con la lista de tarifas y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<FeeDto>> getFee() {
        return ResponseEntity.ok(feeServices.list());
    }

    /**
     * Actualiza el estado de una tarifa (activo/inactivo) por su ID.
     * @param id El ID de la tarifa a actualizar.
     * @param newStatus El nuevo estado de la tarifa ('A' para activa, 'I' para inactiva).
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra la tarifa.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            feeServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("Fee status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fee not found");
        }
    }
}
