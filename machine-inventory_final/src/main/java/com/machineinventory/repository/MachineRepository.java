package com.machineinventory.repository;

import com.machineinventory.model.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MachineRepository extends JpaRepository<Machine, Long> {
    Optional<Machine> findByHostname(String hostname);
    List<Machine> findAllByInstalledOSContainingIgnoreCase(String os);
    List<Machine> findAllByAccessibilityStatus(Machine.AccessibilityStatus status);
}
