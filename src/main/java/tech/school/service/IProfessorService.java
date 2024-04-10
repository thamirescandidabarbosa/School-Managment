package tech.school.service;

import java.util.List;

import tech.school.domain.dto.exception.NotFoundException;
import tech.school.domain.dto.v1.ProfessorDto;

public interface IProfessorService {

    ProfessorDto criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) throws NotFoundException;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido);

    void removerProfessor(int id) throws NotFoundException;

}
