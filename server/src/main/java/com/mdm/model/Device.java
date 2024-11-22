package com.mdm.model;

import java.time.LocalDateTime;

public class Device {
    private String imei;
    private String brand;
    private String model;
    private String osVersion;
    private LocalDateTime lastCheckin;
    private DeviceStatus status;

    // Getters et Setters
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

    // Enum pour le statut de l'appareil
    public enum DeviceStatus {
        ACTIVE,
        INACTIVE,
        LOST
    }
}