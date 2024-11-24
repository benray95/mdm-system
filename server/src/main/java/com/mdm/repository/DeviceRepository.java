package com.mdm.repository;

import com.mdm.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    // Recherche d'un appareil par son ID (device_id)
    Optional<Device> findByDeviceId(String deviceId);

    // Recherche d'un appareil par son IMEI
    Optional<Device> findByImei(String imei);
}
