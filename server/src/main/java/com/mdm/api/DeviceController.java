package com.mdm.api;

import com.mdm.model.Device;
import com.mdm.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Endpoint pour enregistrer un appareil
    @PostMapping("/enroll")
    public ResponseEntity<Device> enrollDevice(@RequestBody Device device) {
        Device enrolledDevice = deviceService.enrollDevice(device);
        return ResponseEntity.ok(enrolledDevice);
    }

    // Endpoint pour obtenir tous les appareils
    @GetMapping("/")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    // Endpoint pour obtenir un appareil spécifique par son id
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    // Endpoint pour supprimer un appareil par son id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}
