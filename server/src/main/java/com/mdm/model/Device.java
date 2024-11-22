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
    private String deviceId;

    @Column(unique = true, nullable = false)
    private String imei;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String osVersion;

    @Column(nullable = false)
    private LocalDateTime lastCheckin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;

    // Getters and setters

    public enum DeviceStatus {
        active, inactive, lost
    }
}