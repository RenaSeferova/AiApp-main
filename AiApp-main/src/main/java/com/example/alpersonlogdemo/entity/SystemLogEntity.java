package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "system_logs")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemLogEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String level; //INFO,WARN,ERROR
    private  String source; //hansi servis, modul veya funksiya

    @Column(columnDefinition = "TEXT")
    private String message;
    private Long timestamp;

    @PrePersist
    protected void onCreate() {
        this.timestamp = System.currentTimeMillis();
    }
}

