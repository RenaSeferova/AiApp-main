package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "behavior_patterns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BehaviorPatternEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String patternType; //"ActiveAtNight","FrequentInteractions","EmotinalPosts" ve s
    private String patternValue; // "true","high","medium","low", ve ya spesifik netice

    private Long analyzedAt;

    @PrePersist
    protected void onCreate() {
        this.analyzedAt=System.currentTimeMillis();
    }
}

