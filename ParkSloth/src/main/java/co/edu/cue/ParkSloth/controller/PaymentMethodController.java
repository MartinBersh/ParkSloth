package co.edu.cue.ParkSloth.controller;

import co.edu.cue.ParkSloth.mapping.dtos.PaymentMethodDto;
import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDayDto;
import co.edu.cue.ParkSloth.services.PaymentMethodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PaymentMethod")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodServices paymentMethodServices;
    @PostMapping("/create")
    public ResponseEntity<PaymentMethodDto> createScheduleDay(@RequestBody PaymentMethodDto paymentMethodDto) {
        return ResponseEntity.ok(paymentMethodServices.save(paymentMethodDto));
    }
    @PutMapping("/update")
    public ResponseEntity<PaymentMethodDto> updateScheduleDay(@RequestBody PaymentMethodDto paymentMethodDto) {
        return ResponseEntity.ok(paymentMethodServices.update(paymentMethodDto));
    }
    @GetMapping("/get")
    public ResponseEntity<List<PaymentMethodDto>> getScheduleDay() {
        return ResponseEntity.ok(paymentMethodServices.list());
    }
    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestBody Character newStatus) {
        try {
            paymentMethodServices.updateStatus(id, newStatus);
            return ResponseEntity.ok("PaymentMethod status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PaymentMethod not found");
        }
    }
}
