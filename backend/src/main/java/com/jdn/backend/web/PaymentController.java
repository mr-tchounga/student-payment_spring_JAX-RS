package com.jdn.backend.web;

import com.jdn.backend.entity.Payment;
import com.jdn.backend.entity.PaymentStatus;
import com.jdn.backend.entity.PaymentType;
import com.jdn.backend.entity.Student;
import com.jdn.backend.repository.PaymentRepository;
import com.jdn.backend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PaymentController {

    PaymentRepository paymentRepository;

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        Payment newPayment = paymentRepository.save(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPayment);
    }
    @GetMapping("/payments")
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }
    @GetMapping("/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
    @GetMapping("/payments/student/{code}")
    public List<Payment> getPaymentByStudent(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }
    @GetMapping("/payments/status")
    public List<Payment> getPaymentByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping("/payments/type")
    public List<Payment> getPaymentByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }
    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment){
        Optional<Payment> oldPayment = paymentRepository.findById(id);
        if (oldPayment.isPresent()){
            payment.setId(id);
            Payment updatedPayment = paymentRepository.save(payment);

            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/payments/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable Long id){
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()){
            paymentRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
