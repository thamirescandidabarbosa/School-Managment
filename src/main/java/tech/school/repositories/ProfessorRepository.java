package tech.school.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository<Professor> extends JpaRepository<Professor, Integer> {

    Optional<Professor> findByCpf(String cpf);

    boolean existsByCpf(@Param("cpf") String cpf);

    ScopedValue findById(int id);

    tech.school.domain.entities.Professor save(tech.school.domain.entities.Professor p);
}
