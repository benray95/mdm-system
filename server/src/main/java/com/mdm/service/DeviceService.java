package com.mdm.service;

import com.mdm.model.Device;
import com.mdm.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    // Enregistrer un appareil
    public Device enrollDevice(Device device) {
        return deviceRepository.save(device);
    }

    // Obtenir tous les appareils
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    // Obtenir un appareil par son id
    public Device getDeviceById(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        return device.orElseThrow(() -> new RuntimeException("Device not found"));
    }

    // Supprimer un appareil par son id
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
