package com.mdm.api;

import com.mdm.model.Device;
import com.mdm.model.EnrollmentRequest;
import com.mdm.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        if (device != null) {
            return ResponseEntity.ok(device);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device createdDevice = deviceService.createDevice(device);
        return ResponseEntity.ok(createdDevice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
        Device updatedDevice = deviceService.updateDevice(id, deviceDetails);
        if (updatedDevice != null) {
            return ResponseEntity.ok(updatedDevice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        boolean deleted = deviceService.deleteDevice(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/enroll/generate")
    public ResponseEntity<String> generateEnrollmentCode() {
        String enrollmentCode = UUID.randomUUID().toString();
        // Stocker ce code dans la base de données ou en mémoire avec une durée de validité
        deviceService.storeEnrollmentCode(enrollmentCode);
        return ResponseEntity.ok(enrollmentCode);
    }

    @PostMapping("/enroll")
    public ResponseEntity<Device> enrollDevice(@RequestBody EnrollmentRequest request) {
        // Vérifier la validité du code d'enrôlement
        if (!deviceService.isValidEnrollmentCode(request.getEnrollmentCode())) {
            return ResponseEntity.badRequest().build();
        }
        
        // Si valide, créer un nouvel appareil
        Device newDevice = deviceService.createDeviceFromEnrollment(request);
        
        // Invalider le code d'enrôlement après utilisation
        deviceService.invalidateEnrollmentCode(request.getEnrollmentCode());
        
        return ResponseEntity.ok(newDevice);
    }
}