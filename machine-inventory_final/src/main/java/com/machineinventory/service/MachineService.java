
package com.machineinventory.service;

import com.machineinventory.dto.MachineDTO;
import com.machineinventory.model.Machine;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MachineService {
    Machine createMachine(MachineDTO dto);
    Machine getMachine(Long id);
    List<Machine> getAllMachines(String os, String status);
    Machine updateMachine(Long id, MachineDTO dto);
    void deactivateMachine(Long id);
}
