package tech.school.service;

import java.util.List;

import tech.school.domain.dto.exception.NotFoundException;
import tech.school.domain.dto.v1.AlunoDto;

public interface IAlunoService {

    AlunoDto criarAluno(AlunoDto pedido);

    List<AlunoDto> listarAlunos();

    AlunoDto buscarAluno(int id) throws NotFoundException;

    AlunoDto atualizarAluno(int id, AlunoDto pedido);

    void removerAluno(int id) throws NotFoundException;

}
