package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "personality_analysis_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalityAnalysisResultEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String personalityType; // məsələn: INTJ, ENFP, “Lider”, “Analitik”

    @Lob
    private String detailedAnalysis; // AI tərəfindən yaradılmış uzun izah

    private String traitsSummary; // əsas xüsusiyyətlərin xülasəsi (məsələn: “introvert, strateji, analitik”)

    private Double consistencyScore; // cavabların sabitlik səviyyəsi (%)

    private Long createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = System.currentTimeMillis();
    }
}
