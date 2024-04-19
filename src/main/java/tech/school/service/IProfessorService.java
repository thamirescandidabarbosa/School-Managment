package tech.school.service;

import tech.school.domain.dto.exception.NotFoundException;
import tech.school.domain.dto.v1.ProfessorDto;

import java.util.List;

public interface IProfessorService {

    ProfessorDto criarProfessor(ProfessorDto pedido);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) throws Throwable;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws Throwable;

    void removerProfessor(int id) throws Throwable;

    ProfessorDto buscarPorCpf(String cpf) throws NotFoundException, Throwable;

    void criar(ProfessorDto professor);
}
