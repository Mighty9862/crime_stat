package org.example.controller;

import org.example.entity.CrimeRecord;
import org.example.service.CrimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crimes")
public class CrimeController {
    private final CrimeService service;
    public CrimeController(CrimeService service) { this.service = service; }

    @PostMapping("/load")
    public ResponseEntity<String> load() {
        service.reloadData();
        return ResponseEntity.ok("Данные загружены");
    }

    @GetMapping("/all")
    public List<CrimeRecord> all() { return service.getAll(); }
}
