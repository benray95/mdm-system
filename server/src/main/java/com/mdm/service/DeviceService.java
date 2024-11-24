package com.mdm.service;

import com.mdm.model.Device;
import com.mdm.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    // Enrôler un appareil
    public Device enrollDevice(Device device) {
        return deviceRepository.save(device);
    }

    // Obtenir la liste des appareils
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}
