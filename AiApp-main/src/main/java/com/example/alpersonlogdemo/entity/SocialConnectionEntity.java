package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "social_connections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialConnectionEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; //elaqeni yaradan

@ManyToOne
@JoinColumn(name = "connected_user_id")
private UserEntity connectedUser; //elaqede olan diger sexs
private String connectionType; //"friend","follower","block" ve s

private Long connectedAt;

@PrePersist
protected void onCreate() {
this.connectedAt = System.currentTimeMillis();
}
}


