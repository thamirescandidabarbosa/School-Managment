package tech.school.service;

import org.springframework.stereotype.Service;
import tech.school.domain.dto.v1.NotaDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    private final List<NotaDto> notas = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public NotaDto registrarNota(NotaDto notaDto) {
        notaDto.setId(proximoId++);
        notas.add(notaDto);
        return notaDto;
    }

    @Override
    public List<NotaDto> listarNotas() {
        return notas;
    }

    @Override
    public NotaDto buscarNota(Long id) {
        return notas.stream()
                .filter(nota -> nota.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public NotaDto atualizarNota(Long id, NotaDto notaDto) {
        NotaDto notaExistente = buscarNota(id);
        if (notaExistente != null) {
            // Verifica se os campos do DTO não são nulos antes de atualizá-los
            if (notaDto.getDisciplina() != null) {
                notaExistente.setDisciplina(notaDto.getDisciplina());
            }
            if (notaDto.getValor() != null) {
                notaExistente.setValor(notaDto.getValor());
            }
            // Adicione aqui outras atualizações necessárias

            // Retorna a nota atualizada
            return notaExistente;
        }
        // Retorna null se a nota não existir
        return null;
    }


    @Override
    public void excluirNota(Long id) {
        notas.removeIf(nota -> nota.getId().equals(id));
    }

    // Outros métodos implementados conforme necessário
}
