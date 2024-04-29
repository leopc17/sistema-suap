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
        turmas[1] = new Turma(2, "2024/1", "Prog. I");
        turmas[2] = new Turma(3, "2024/1", "Física");
        qtdTurmas += 3;

        alunos[0] = new Aluno("Ana", 20, "ana@gmail.com");
        alunos[1] = new Aluno("Bernardo", 38, "bernardo@gmail.com");
        alunos[2] = new Aluno("Cristiano", 27, "cris@gmail.com");
        alunos[3] = new Aluno("David", 17, "david@gmail.com");
        alunos[4] = new Aluno("Enzo", 15, "enzo@gmail.com");
        qtdAlunos += 5;

        professores[0] = new Professor("Janine", 40, "janine@gmail.com", "Doutora");
        professores[1] = new Professor("Érico", 40, "erico@gmail.com", "Doutor");
        professores[2] = new Professor("Ricardo", 42, "rick@gmail.com", "Doutor");
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
