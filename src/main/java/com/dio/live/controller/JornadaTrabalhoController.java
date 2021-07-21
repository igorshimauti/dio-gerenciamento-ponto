package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping()
    public JornadaTrabalho create(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaTrabalhoService.save(jornadaTrabalho);
    }

    @GetMapping()
    public List<JornadaTrabalho> read() {
        return jornadaTrabalhoService.findAll();
    }

    @GetMapping(value = "/{jornadaId}")
    public ResponseEntity<JornadaTrabalho> readById(@PathVariable Long jornadaId) {
        return jornadaTrabalhoService.findById(jornadaId)
                .map(jornadaTrabalho -> ResponseEntity.ok(jornadaTrabalho))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{jornadaId}")
    public ResponseEntity<JornadaTrabalho> update(@PathVariable Long jornadaId, @RequestBody JornadaTrabalho jornadaTrabalho) {
        jornadaTrabalho.setId(jornadaId);
        return ResponseEntity.ok(jornadaTrabalhoService.save(jornadaTrabalho));
    }

    @DeleteMapping(value = "/{jornadaId}")
    public ResponseEntity<Void> delete(@PathVariable Long jornadaId) {
        jornadaTrabalhoService.delete(jornadaId);
        return ResponseEntity.noContent().build();
    }
}