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
public class StudentController {

    StudentRepository studentRepository;
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student newStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/students/{code}")
    public Student getStudentsByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }
    @GetMapping("/students/filter")
    public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }
    @PutMapping("/students/{code}")
    public ResponseEntity<Student> updateStudent(@PathVariable String code, @RequestBody Student student){
        Student oldStudent = studentRepository.findByCode(code);
        if (oldStudent != null){
            student.setCode(code);
            Student updatedStudent = studentRepository.save(student);

            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/students/{code}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String code){
        Student student = studentRepository.findByCode(code);
        if (student != null){
            studentRepository.delete(student);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
