package tech.school.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import tech.school.domain.dto.exception.NotFoundException;
import tech.school.domain.dto.v1.AlunoDto;
import tech.school.service.IAlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final IAlunoService servico;

    @Autowired
    public AlunoController(IAlunoService servico) {
        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> lerAlunos() {
        return ResponseEntity.ok(servico.listarAlunos());
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(
            @RequestBody @Valid AlunoDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarAluno(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizarAluno(
            @PathVariable("id") int id,
            @RequestBody AlunoDto pedido
    ) {
        final AlunoDto aluno = servico.atualizarAluno(id, pedido);

        if (aluno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(
            @PathVariable("id") int id
    ) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarAluno(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(
            @PathVariable("id") int id
    ) throws NotFoundException {
        servico.removerAluno(id);
        return ResponseEntity.noContent().build();
    }

}
