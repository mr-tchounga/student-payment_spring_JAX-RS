package com.jdn.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
public class Student {

    @Id
    String id;
    String firstname;
    String lastname;
    @Column(unique = true)
    String code;
    String programId;
    String photo;
}
