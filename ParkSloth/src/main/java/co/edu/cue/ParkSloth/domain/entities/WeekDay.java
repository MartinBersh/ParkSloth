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
@Table(name = "week_days", schema = "public")
public class WeekDay {

    // Identificador único del día de la semana, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWeekDay;

    // Número correspondiente al día de la semana (ej: 1 para lunes, 7 para domingo).
    private int dayNumber;

    // Nombre del día de la semana.
    private String dayName;

    // Estado del día de la semana (activo/inactivo), representado por un carácter.
    private Character status;
}
