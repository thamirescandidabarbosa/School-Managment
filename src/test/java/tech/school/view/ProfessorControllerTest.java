package tech.school.view;

import org.junit.jupiter.api.Test;
import tech.school.mocks.ProfessorServiceMock;
import tech.school.service.IProfessorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfessorControllerTest {


    @Test
    public void testListarProfessores() {
        ProfessorController underTest = new ProfessorController((IProfessorService) new ProfessorServiceMock());
        assertEquals(1, underTest.lerProfessores().getBody().size(), "Tamanho tem de ser 1");
    }
}