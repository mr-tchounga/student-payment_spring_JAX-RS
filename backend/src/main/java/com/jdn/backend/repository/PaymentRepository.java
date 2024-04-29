package com.jdn.backend.repository;

import com.jdn.backend.entity.Payment;
import com.jdn.backend.entity.PaymentStatus;
import com.jdn.backend.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);

}
