package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.AddOnServiceDto;
import co.edu.cue.ParkSloth.services.AddOnServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de servicios adicionales (Add-On Services).
 * Proporciona endpoints para crear, actualizar, listar y modificar el estado de los servicios adicionales.
 */
@RestController
@RequestMapping("/AddOnServices")
public class AddOnServicesController {

    @Autowired
    private AddOnServiceServices addOnServiceServices;

    /**
     * Crea un nuevo servicio adicional.
     * @param addOnServiceDto Objeto DTO que contiene los datos del servicio adicional a crear.
     * @return Un ResponseEntity con el servicio adicional creado y el estado HTTP 200 OK.
     */
    @PostMapping("/create")
    public ResponseEntity<AddOnServiceDto> createAddOnServices(@RequestBody AddOnServiceDto addOnServiceDto) {
        return ResponseEntity.ok(addOnServiceServices.save(addOnServiceDto));
    }

    /**
     * Actualiza un servicio adicional existente.
     * @param addOnServiceDto Objeto DTO que contiene los datos actualizados del servicio adicional.
     * @return Un ResponseEntity con el servicio adicional actualizado y el estado HTTP 200 OK.
     */
    @PutMapping("/update")
    public ResponseEntity<AddOnServiceDto> updateAddOnServices(@RequestBody AddOnServiceDto addOnServiceDto) {
        return ResponseEntity.ok(addOnServiceServices.update(addOnServiceDto));
    }

    /**
     * Recupera una lista de todos los servicios adicionales registrados.
     * @return Un ResponseEntity con la lista de servicios adicionales y el estado HTTP 200 OK.
     */
    @GetMapping("/get")
    public ResponseEntity<List<AddOnServiceDto>> getAddOnServices() {
        return ResponseEntity.ok(addOnServiceServices.list());
    }

    /**
     * Actualiza el estado de un servicio adicional (activo/inactivo) por su ID.
     * @param id El ID del servicio adicional a actualizar.
     * @param newStatus El nuevo estado del servicio adicional ('A' para activo, 'I' para inactivo).
     * @return Un ResponseEntity con un mensaje de éxito o un mensaje de error si no se encuentra el servicio adicional.
     */
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            addOnServiceServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("AddOnServices status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AddOnServices not found");
        }
    }
}
