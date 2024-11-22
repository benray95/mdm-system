package com.mdm.service;

import com.mdm.model.Device;
import com.mdm.model.EnrollmentRequest;
import com.mdm.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    private Map<String, LocalDateTime> enrollmentCodes = new ConcurrentHashMap<>();

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(Device device) {
        device.setLastCheckin(LocalDateTime.now());
        return deviceRepository.save(device);
    }

    public Device updateDevice(Long id, Device deviceDetails) {
        Device device = deviceRepository.findById(id).orElse(null);
        if (device != null) {
            device.setImei(deviceDetails.getImei());
            device.setBrand(deviceDetails.getBrand());
            device.setModel(deviceDetails.getModel());
            device.setOsVersion(deviceDetails.getOsVersion());
            device.setLastCheckin(LocalDateTime.now());
            device.setStatus(deviceDetails.getStatus());
            return deviceRepository.save(device);
        }
        return null;
    }

    public boolean deleteDevice(Long id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void storeEnrollmentCode(String code) {
        enrollmentCodes.put(code, LocalDateTime.now().plusHours(1)); // Code valide pour 1 heure
    }

    public boolean isValidEnrollmentCode(String code) {
        LocalDateTime expirationTime = enrollmentCodes.get(code);
        return expirationTime != null && expirationTime.isAfter(LocalDateTime.now());
    }

    public Device createDeviceFromEnrollment(EnrollmentRequest request) {
        Device device = new Device();
        device.setImei(request.getImei());
        device.setBrand(request.getBrand());
        device.setModel(request.getModel());
        device.setOsVersion(request.getOsVersion());
        device.setLastCheckin(LocalDateTime.now());
        device.setStatus(Device.DeviceStatus.ACTIVE);
        return deviceRepository.save(device);
    }

    public void invalidateEnrollmentCode(String code) {
        enrollmentCodes.remove(code);
    }
}