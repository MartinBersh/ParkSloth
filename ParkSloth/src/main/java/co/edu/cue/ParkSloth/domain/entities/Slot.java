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
@Table(name = "slots", schema = "public")
public class Slot {

    // Identificador único del slot, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSlot;

    // Número del slot.
    private int slotNumber;

    // Relación muchos-a-uno con la entidad ParkingLot, clave foránea (id_parking_lot).
    @ManyToOne
    @JoinColumn(name = "id_parking_lot")
    private ParkingLot parkingLot;

    // Relación muchos-a-uno con la entidad VehicleType, clave foránea (id_vehicle_type).
    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleType vehicleType;

    // Estado del slot (activo/inactivo), representado por un carácter.
    private Character status;
}
