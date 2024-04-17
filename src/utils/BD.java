package utils;

import entities.*;

import static utils.Menu.*;

public class BD {
    public static void iniciar() {
        turmas[0] = new Turma(1, "2024/1", "TCS");
        turmas[1] = new Turma(2, "2024/1", "Prog. II");
        turmas[2] = new Turma(3, "2024/1", "Física");
        qtdTurmas += 3;

        alunos[0] = new Aluno("a", 0, "");
        alunos[1] = new Aluno("b", 0, "");
        alunos[2] = new Aluno("c", 0, "");
        alunos[3] = new Aluno("d", 0, "");
        alunos[4] = new Aluno("e", 0, "");
        qtdAlunos += 5;

        professores[0] = new Professor("f", 0, "", "Doutor");
        professores[1] = new Professor("g", 0, "", "Doutor");
        professores[2] = new Professor("h", 0, "", "Doutor");
        qtdProfessores += 3;
    }
}
