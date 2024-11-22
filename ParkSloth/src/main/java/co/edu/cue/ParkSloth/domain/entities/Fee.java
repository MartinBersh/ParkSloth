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
@Table(name = "fees", schema = "public")
public class Fee {

    // Identificador único de la tarifa, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFee;

    // Nombre de la tarifa.
    private String name;

    // Precio asociado a la tarifa.
    private int price;

    // Relación muchos-a-uno con la entidad ParkingLot, clave foránea (id_parking_lot).
    @ManyToOne
    @JoinColumn(name = "id_parking_lot")
    private ParkingLot parkingLot;

    // Relación muchos-a-uno con la entidad VehicleType, clave foránea (id_vehicle_type).
    @ManyToOne
    @JoinColumn(name = "id_vehicle_type")
    private VehicleType vehicleType;

    // Estado de la tarifa (activo/inactivo), representado por un carácter.
    private Character status;
}
