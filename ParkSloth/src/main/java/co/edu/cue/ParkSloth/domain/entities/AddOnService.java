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
@Table(name = "add_on_services", schema = "public")
public class AddOnService {

    // Identificador único de los servicios adicionales, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAddOnService;

    // Nombre del servicio adicional.
    private String name;

    // Precio del servicio adicional.
    private int price;

    // Relación muchos-a-uno con la entidad ParkingLot, utilizando una clave foránea (id_parking_lot).
    @ManyToOne
    @JoinColumn(name = "id_parking_lot")
    private ParkingLot parkingLot;

    // Estado del servicio adicional (activo/inactivo), representado por un carácter.
    private Character status;
}
