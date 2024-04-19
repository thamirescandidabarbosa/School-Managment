package tech.school.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.school.domain.dto.v1.NotaDto;
import tech.school.service.NotaService;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    @Autowired
    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public ResponseEntity<NotaDto> registrarNota(@RequestBody NotaDto notaDto) {
        NotaDto novaNota = notaService.registrarNota(notaDto);
        return new ResponseEntity<>(novaNota, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NotaDto>> listarNotas() {
        List<NotaDto> notas = notaService.listarNotas();
        return new ResponseEntity<>(notas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDto> buscarNota(@PathVariable Long id) {
        NotaDto nota = notaService.buscarNota(id);
        if (nota != null) {
            return new ResponseEntity<>(nota, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaDto> atualizarNota(@PathVariable Long id, @RequestBody NotaDto notaDto) {
        NotaDto notaAtualizada = notaService.atualizarNota(id,
                notaDto);
        if (notaAtualizada != null) {
            return new ResponseEntity<>(notaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNota(@PathVariable Long id) {
        notaService.excluirNota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
