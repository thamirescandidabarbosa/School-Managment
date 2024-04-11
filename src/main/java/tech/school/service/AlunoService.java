package tech.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tech.school.domain.dto.exception.NotFoundException;
import tech.school.domain.dto.v1.AlunoDto;

@Service
public class AlunoService implements IAlunoService {

    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public AlunoDto criarAluno(AlunoDto novoAluno) {
        final AlunoDto aluno = new AlunoDto(
                id++,
                novoAluno.getNome(),
                novoAluno.getCpf(),
                novoAluno.getEmail()
        );
        alunos.add(aluno);
        return aluno;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return alunos
                .stream()
                .filter(it -> it.getId()==id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(AlunoDto.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) {
        final AlunoDto aluno = alunos.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        if (aluno == null) {
            return null;
        }
        alunos.remove(aluno);
        final AlunoDto updatedAluno = new AlunoDto(aluno.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail());
        alunos.add(updatedAluno);
        return updatedAluno;
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {
        final AlunoDto aluno = buscarAluno(id);
        alunos.remove(aluno);
    }
}
