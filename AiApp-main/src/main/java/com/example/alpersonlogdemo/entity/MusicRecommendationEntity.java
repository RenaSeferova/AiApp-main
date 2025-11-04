package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "music_recommendations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicRecommendationEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

    private String mood; // mes: "xosbext","kederli",enerjili"
    private String genre; //mes : "Tech House". "Jazz","Pop"
    private String artist;
    private String songTitle;

    private String recommendationReason; //AI hansi sebeble ve mahnini tovsiye edib?

    private String  externalUrl; //Spotify,YouTube linki ve s.
     @Column(updatable = false)
    private  Long createdAt;

     @PrePersist
    protected void onCreate() {
         this.createdAt = System.currentTimeMillis();
     }

}

