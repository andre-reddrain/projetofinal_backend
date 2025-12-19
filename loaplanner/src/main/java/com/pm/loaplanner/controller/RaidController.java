package com.pm.loaplanner.controller;

import com.pm.loaplanner.dto.RaidResponseDTO;
import com.pm.loaplanner.service.RaidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/raids")   // http://localhost:8080/raids
public class RaidController {
    private final RaidService raidService;

    public RaidController(RaidService raidService) {
        this.raidService = raidService;
    }

    @GetMapping
    public ResponseEntity<List<RaidResponseDTO>> getAllRaids() {
        // O Get Request não chega a entrar aqui. Talvez seja por causa do MySQL?
        // A ligação á base de dados funciona, mas não recolhe nada
        // Acho que o problema é o Spring Security. Interceta qualquer request e da redirect para /login.
        // Deve ser por isso que o GET não recolhe nada!
        List<RaidResponseDTO> raids = raidService.getAllRaids();
        return ResponseEntity.ok().body(raids);

        //TODO Refazer isto para os Gates! Ver como fazer nest! Talvez Raid-Gates?
    }
}
