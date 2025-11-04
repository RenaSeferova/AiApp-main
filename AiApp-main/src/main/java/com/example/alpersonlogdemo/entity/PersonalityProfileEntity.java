package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "personality_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PersonalityProfileEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity user;
    @Column(nullable = false)
    private String personalityType; //mes INTJ,ENEP  ve s

  private String cognitiveFunctions; //MBTI funks : Ni>Te> Fi>Se ve s
    private Double openness;
    private Double conscientiousness;
    private Double extraversion;
    private Double argeeableness;
    private Double neuroticism;

    private String summary ; //qisa tesvir
    @Column(updatable = false)
    private Long createdAt;
    private Long updatedAt;

    @PrePersist
    protected void onCreate() {
    this.createdAt=System.currentTimeMillis();
    this.updatedAt=this.createdAt;
}
@PreUpdate
protected void onUpdate() {
    this.updatedAt=System.currentTimeMillis();
    }
}

