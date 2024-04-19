package tech.school.service;

import org.springframework.stereotype.Service;
import tech.school.domain.dto.v1.NotaDto;

import java.util.List;
@Service
public interface NotaService {
    NotaDto registrarNota(NotaDto notaDto);
    List<NotaDto> listarNotas();
    NotaDto buscarNota(Long id);
    NotaDto atualizarNota(Long id, NotaDto notaDto); // Correção aqui
    void excluirNota(Long id);

    // Outros métodos relacionados a notas
}

