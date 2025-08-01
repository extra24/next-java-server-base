package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "business_aram")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String businessNumber;

    @Column
    private String companyName;

    @Column
    private String representativeName;

    @Column
    private String contactEmail;

    @Column
    private String contactPhone;

    @Column
    private String address;

    @Column(name = "registered_at")
    private java.time.LocalDateTime registeredAt;

    @PrePersist
    protected void onCreate() {
        registeredAt = java.time.LocalDateTime.now();
    }


}
