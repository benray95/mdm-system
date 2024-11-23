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

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public LocalDateTime getLastCheckin() {
        return lastCheckin;
    }

    public void setLastCheckin(LocalDateTime lastCheckin) {
        this.lastCheckin = lastCheckin;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public enum DeviceStatus {
        ACTIVE,
        INACTIVE,
        LOST
    }
}