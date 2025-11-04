package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "chat_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(columnDefinition = "TEXT")
    private String messageContent;
    private String sender; //"user" veya "ai"
    private Long sentAt;

    @PrePersist
    protected void onCreate() {
        this.sentAt=System.currentTimeMillis();
    }
}

