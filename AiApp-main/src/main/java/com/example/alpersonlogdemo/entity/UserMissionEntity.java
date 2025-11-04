package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user_missionEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMissionEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
private UserEntity user;
    private String title; //"Gundelik Mentiq oyunlari,"Dusunce Analizi Et" ve s

@Lob
private String description;
private boolean completed;
private Long assignedAt;

@PrePersist
protected void onCreate(){
this.assignedAt=System.currentTimeMillis();
}
}






