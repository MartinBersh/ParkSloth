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
@Table(name = "schedules", schema = "public")
public class Schedule {

    // Identificador único del horario, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;

    // Hora de inicio del horario (formato 24 horas).
    private int startSchedule;

    // Hora de fin del horario (formato 24 horas).
    private int endSchedule;

    // Estado del horario (activo/inactivo), representado por un carácter.
    private Character status;
}
