package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "message_analysis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MessageAnalysisEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne 
    @JoinColumn(name = "message_id")
    private ChatMessageEntity message;
    
    private String tone;//"pozitive","neutral".
    private String sentiment;//happy, sad. an
    private String category; // logic","personal nurdadir
    private Long analyzedAt;

    @PrePersist
    protected void onCreate() {
        this.analyzedAt=System .currentTimeMillis();
    }
}


