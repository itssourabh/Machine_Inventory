package com.machineinventory.service.impl;

import com.machineinventory.dto.MachineDTO;
import com.machineinventory.model.Machine;
import com.machineinventory.repository.MachineRepository;
import com.machineinventory.service.MachineService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository repository;

    @Override
    public Machine createMachine(MachineDTO dto) {
        Machine machine = fromDTO(dto);
        return repository.save(machine);
    }

    @Override
    public Machine getMachine(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Machine not found"));
    }

    @Override
    public List<Machine> getAllMachines(String os, String status) {
        if (!os.isEmpty()) {
            return repository.findAllByInstalledOSContainingIgnoreCase(os);
        } else if (!status.isEmpty()) {
            Machine.AccessibilityStatus enumStatus = Machine.AccessibilityStatus.valueOf(status.toUpperCase());
            return repository.findAllByAccessibilityStatus(enumStatus);
        }
        return repository.findAll();
    }

    @Override
    public Machine updateMachine(Long id, MachineDTO dto) {
        Machine existing = getMachine(id);
        Machine updated = fromDTO(dto);
        updated.setId(existing.getId());
        return repository.save(updated);
    }

    @Override
    public void deactivateMachine(Long id) {
        Machine machine = getMachine(id);
        machine.setAccessibilityStatus(Machine.AccessibilityStatus.DECOMMISSIONED);
        repository.save(machine);
    }

    private Machine fromDTO(MachineDTO dto) {
        Machine machine = new Machine();
        machine.setHostname(dto.hostname);
        machine.setUsername(dto.username);
        machine.setInstalledOS(dto.installedOS);
        machine.setCpuDetails(dto.cpuDetails);
        machine.setRamDetails(dto.ramDetails);
        machine.setPrivateIpAddress(dto.privateIpAddress);
        machine.setPublicIpAddress(dto.publicIpAddress);
        machine.setCloudProviderUrl(dto.cloudProviderUrl);
        machine.setVncPort(dto.vncPort);
        machine.setAccessibilityStatus(Machine.AccessibilityStatus.valueOf(dto.accessibilityStatus.toUpperCase()));
        machine.setRemarks(dto.remarks);
        return machine;
    }
}
