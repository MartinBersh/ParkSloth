package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.ParkingLotDto;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import co.edu.cue.ParkSloth.services.ParkingLotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de estacionamientos (Parking Lots).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de los estacionamientos.
 */
@RestController
@RequestMapping("/ParkingLot")
public class ParkingLotController {
    @Autowired
    private ParkingLotServices parkingLotServices;

    /**
     * Crea un nuevo estacionamiento.
     * @param parkingLotDto Objeto DTO que contiene los datos del estacionamiento a crear.
     * @return Un ResponseEntity con el estacionamiento creado y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<ParkingLotDto> createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        return ResponseEntity.ok(parkingLotServices.save(parkingLotDto));
    }

    /**
     * Actualiza un estacionamiento existente.
     * @param parkingLotDto Objeto DTO que contiene los datos actualizados del estacionamiento.
     * @return Un ResponseEntity con el estacionamiento actualizado y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<ParkingLotDto> updateParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        return ResponseEntity.ok(parkingLotServices.update(parkingLotDto));
    }

    /**
     * Recupera una lista de todos los estacionamientos registrados.
     * @return Un ResponseEntity con la lista de estacionamientos y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<ParkingLotDto>> getParkingLot() {
        return ResponseEntity.ok(parkingLotServices.list());
    }

    /**
     * Actualiza el estado de un estacionamiento (activo/inactivo) por su ID.
     * @param id El ID del estacionamiento a actualizar.
     * @param newStatus El nuevo estado del estacionamiento ('A' para activo, 'I' para inactivo).
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra el estacionamiento.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            parkingLotServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("ParkingLot status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ParkingLot not found");
        }
    }
}
