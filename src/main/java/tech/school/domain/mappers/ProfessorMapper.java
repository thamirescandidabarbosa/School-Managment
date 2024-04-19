package tech.school.domain.mappers;

import tech.school.domain.dto.v1.ProfessorDto;
import tech.school.domain.entities.Professor;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorDto dto) {
        return Professor
            .builder()
            .nome(dto.getNome())
            .cpf(dto.getCpf())
            .eMail(dto.getEmail())
            .build();
    }

    public static ProfessorDto toDto(Professor entity, String activity) {
        return new ProfessorDto(
            entity.getId(),
            entity.getNome(),
            entity.getCpf(),
            entity.getEMail()
        );
    }

}
