package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "ai_recommendarions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AiRecommendationEntity {
@Id
@GeneratedValue
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id",nullable = false)
private UserEntity user;

private String category;//"Logic","Social","MentalHealth" ve s
    @Lob
    private String recommendationText;

    private String source; //"AI","Expert","System Rule"
    private Long createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt=System.currentTimeMillis();
    }

}



