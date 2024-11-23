package com.mdm.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String imei;

    private String brand;
    private String model;
    private String osVersion;

    @Column(name = "last_checkin")
    private LocalDateTime lastCheckin;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    // Getters et Setters (inchangés)

    // Enum pour le statut de l'appareil (inchangé)
    public enum DeviceStatus {
        ACTIVE,
        INACTIVE,
        LOST
    }
}