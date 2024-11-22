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
@Table(name = "users", schema = "public")
public class User {

    // Identificador único del usuario, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    // Nombre de usuario.
    private String username;

    // Contraseña del usuario.
    private String password;

    // Nombre completo del usuario.
    private String name;

    // Número de teléfono del usuario.
    private String phoneNumber;

    // Número de identificación del usuario.
    private String identification;

    // Correo electrónico del usuario.
    private String email;

    // Relación muchos-a-uno con la entidad Role, clave foránea (id_role).
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    // Estado del usuario (activo/inactivo), representado por un carácter.
    private Character status;
}
