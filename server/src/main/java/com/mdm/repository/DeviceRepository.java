package com.mdm.repository;

import com.mdm.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    // Méthode pour rechercher un appareil par son ID unique (device_id)
    Device findByDeviceId(String deviceId);

    // Méthode pour rechercher un appareil par son IMEI
    Device findByImei(String imei);
}
