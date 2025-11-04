package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.UUID;

@Entity
@Table(name = "user_activityLogs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserActivityLogEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private String action; //mes: "LOGIN","PROFILE_UPDATE","TEST_COMPLETED"
    private String description;

    private Long timestamp;
    @PrePersist
    protected void onCreate() {
        this.timestamp=System.currentTimeMillis();

    }

}


