package com.mdm.api;

import com.mdm.model.Device;
import com.mdm.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Endpoint pour l'enrôlement d'un appareil
    @PostMapping("/enroll")
    public Device enrollDevice(@RequestBody Device device) {
        return deviceService.enrollDevice(device);
    }

    // Endpoint pour obtenir la liste des appareils
    @GetMapping("/")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }
}
