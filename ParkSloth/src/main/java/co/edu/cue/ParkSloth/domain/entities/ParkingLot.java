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
@Table(name = "parking_lots", schema = "public")
public class ParkingLot {

    // Identificador único del parqueadero, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParkingLot;

    // Nombre del parqueadero.
    private String name;

    // Dirección del parqueadero.
    private String address;

    // Número de teléfono de contacto del parqueadero.
    private String phoneNumber;

    // Número de identificación tributaria del parqueadero.
    private String nit;

    // Coordenada X de la ubicación del parqueadero.
    private String coordX;

    // Coordenada Y de la ubicación del parqueadero.
    private String coordY;

    // Relación muchos-a-uno con la entidad User, clave foránea (id_user).
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // Estado del parqueadero (activo/inactivo), representado por un carácter.
    private Character status;
}
