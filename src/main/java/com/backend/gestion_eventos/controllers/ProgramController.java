package com.backend.gestion_eventos.controllers;

import com.backend.gestion_eventos.models.Program;
import com.backend.gestion_eventos.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/programs")
@RestController
public class ProgramController {

    private final ProgramService programService;

    @PostMapping
    public ResponseEntity<Program> saveProgram(@RequestBody Program program) {
        try {
            return ResponseEntity.ok(programService.saveProgram(program));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(programService.getProgramById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Integer id, @RequestBody Program program) {
        try {
            return ResponseEntity.ok(programService.updateProgram(id, program));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Integer id) {
        try {
            programService.deleteProgram(id);
            return ResponseEntity.ok().body("Program deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting program");
        }
    }

    @GetMapping
    public ResponseEntity<List<Program>> getPrograms() {
        try {
            return ResponseEntity.ok(programService.getPrograms());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
