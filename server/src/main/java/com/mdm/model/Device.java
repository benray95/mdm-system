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
    private String deviceId; // Correspond au champ device_id dans SQL

    @Column(unique = true, nullable = false)
    private String imei;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(name = "os_version", nullable = false)
    private String osVersion;

    @Column(name = "last_checkin", nullable = false)
    private LocalDateTime lastCheckin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;

    public enum DeviceStatus {
        ACTIVE,
        INACTIVE,
        LOST
    }

    // Getters et Setters
}