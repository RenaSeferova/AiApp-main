

package com.example.alpersonlogdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
//@Table
@Table(name = "user_entity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // USER, ADMIN, vs.

    @Column(nullable = false)
    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = this.createdAt;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}



































//package com.example.alpersonlogdemo.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.UUID;
//
//    @Entity
//    @Table(name ="users" )
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
//
//    public class UserEntity {
//        @Id
//        @GeneratedValue
//        private UUID id;
//
//        @Column(nullable = false,unique = true)
//    private String username;
//
//        @Column(nullable = false,unique = true)
//    private String email;
//
//        @Column(nullable = false)
//
//    private String password;
//        private String gender;
//        private String country;
//        private String profilePicture;
//        private boolean isActive;
//       private boolean isVerified;
//       private String role;//user,admin ve s
//    private String preferredLanguage;
//    private String timezone;
//
//    @Column(updatable = false)
//    private Long createdAt;
//    private Long updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = System.currentTimeMillis();
//        this.updatedAt = this.createdAt;
//    }
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = System.currentTimeMillis();
//    }
//}

