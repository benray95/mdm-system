package com.mdm.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id", unique = true, nullable = false)
    private String deviceId;

    @Column(nullable = false)
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
    private DeviceStatus status = DeviceStatus.ACTIVE;  // Enum pour l'état de l'appareil

    // Constructeur par défaut
    public Device() {
        this.lastCheckin = LocalDateTime.now(); // Initialisation à la date actuelle
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    // Enum pour l'état de l'appareil
    public enum DeviceStatus {
        ACTIVE,
        INACTIVE,
        LOST
    }
}
