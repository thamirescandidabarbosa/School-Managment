package tech.school.view;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.school.domain.dto.exception.NotFoundException;
import tech.school.domain.dto.v1.ProfessorDto;
import tech.school.service.IProfessorService;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final IProfessorService servico;

    @Autowired
    public ProfessorController(IProfessorService servico) {
        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> lerProfessores() {
        return ResponseEntity.ok(servico.listarProfessores());
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> criarProfessor(
        @RequestBody @Valid ProfessorDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarProfessor(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDto> atualizarProfessor(
        @PathVariable("id") int id,
        @RequestBody ProfessorDto pedido
    ) throws Throwable {
        final ProfessorDto p = servico.atualizarProfessor(id, pedido);

        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> buscarProfessor(
        @PathVariable("id") int id
    ) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarProfessor(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProfessor(
        @PathVariable("id") int id
    ) throws NotFoundException {
        servico.removerProfessor(id);
        return ResponseEntity.noContent().build();
    }

}
