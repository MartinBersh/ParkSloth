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
@Table(name = "schedule_days", schema = "public")
public class ScheduleDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleDayId;
    @ManyToOne
    @JoinColumn(name = "id_schedule")
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "id_weekday")
    private WeekDay weekDay;
    @ManyToOne
    @JoinColumn(name = "id_parking_lot")
    private ParkingLot parkingLot;
    private Character status;
}
