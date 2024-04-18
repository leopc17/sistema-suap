package utils;

import entities.*;

public class BD {
    private static final int TAM = 50;

    protected static Turma[] turmas = new Turma[TAM];
    protected static Aluno[] alunos = new Aluno[TAM];
    protected static Professor[] professores = new Professor[TAM];
    protected static int qtdTurmas = 0, qtdAlunos = 0, qtdProfessores = 0;

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

    public static Aluno acharAluno(String matricula) {
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                return alunos[i];
            }
        }
        return null;
    }

    public static Turma acharTurma(int id) {
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    public static Professor acharProfessor(String nome) {
        for (int i = 0; i < qtdProfessores; i++) {
            if (professores[i].getNome().equals(nome)) {
                return professores[i];
            }
        }
        return null;
    }
}
