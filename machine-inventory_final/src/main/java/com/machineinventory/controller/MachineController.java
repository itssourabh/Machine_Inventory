package com.machineinventory.controller;

import com.machineinventory.dto.MachineDTO;
import com.machineinventory.model.Machine;
import com.machineinventory.service.MachineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @PostMapping("/create")
    public ResponseEntity<Machine> create(@RequestBody MachineDTO dto) {
        return ResponseEntity.ok(machineService.createMachine(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> getById(@PathVariable Long id) {
        return ResponseEntity.ok(machineService.getMachine(id));
    }

    @GetMapping
    public ResponseEntity<List<Machine>> getAll(
            @RequestParam(defaultValue = "") String os,
            @RequestParam(defaultValue = "") String status) {
        return ResponseEntity.ok(machineService.getAllMachines(os, status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> update(@PathVariable Long id, @RequestBody MachineDTO dto) {
        return ResponseEntity.ok(machineService.updateMachine(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        machineService.deactivateMachine(id);
        return ResponseEntity.noContent().build();
    }
}
