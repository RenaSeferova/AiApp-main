package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "logic_test_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogicTestResultEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String testName; // məsələn: "Pattern Matching", "Sudoku", "Matrix Puzzle"

    private Integer score; // nəticə, məsələn: 85

    private Integer maxScore; // maksimum nəticə

    private Integer durationInSeconds; // testin müddəti

    @Lob
    private String resultDetails; // AI və ya sistem tərəfindən verilmiş təhlil

    private Long takenAt;

    @PrePersist
    protected void onCreate() {
        this.takenAt = System.currentTimeMillis();
    }
}

