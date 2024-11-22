package co.edu.cue.ParkSloth.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicle_types", schema = "public")
public class VehicleType {

    // Identificador único del tipo de vehículo, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehicleType;

    // Nombre del tipo de vehículo (ej: carro, moto).
    private String name;

    // Estado del tipo de vehículo (activo/inactivo), representado por un carácter.
    private Character status;
}
