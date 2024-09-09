package com.backend.gestion_eventos.services;

import com.backend.gestion_eventos.models.Program;
import com.backend.gestion_eventos.repositories.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    public Program saveProgram(Program program) {
      Program newProgram = Program.builder()
              .name(program.getName())
              .build();
        return programRepository.save(newProgram);
    }

    public Program getProgramById(Integer id) {
        return programRepository.findById(id).orElseThrow(() -> new RuntimeException("Program not found"));
    }

    public Program updateProgram(Integer id, Program program) {
        Program programToUpdate = getProgramById(id);
        programToUpdate.setName(program.getName());
        return programRepository.save(programToUpdate);
    }

    public void deleteProgram(Integer id) {
        programRepository.deleteById(id);
    }

    public List<Program> getPrograms() {
        return programRepository.findAll();
    }
}
