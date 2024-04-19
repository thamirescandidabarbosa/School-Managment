package tech.school.domain.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDto {
    private Long id;
    private Long idAluno;
    private String disciplina;
    private Double valor;
    // Outros campos necessários
}
