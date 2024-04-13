package app;

import entities.Aluno;
import entities.Pessoa;
import entities.Professor;
import entities.Turma;

public class Main {
    public static void main(String[] args) {
        Turma[] turmas = new Turma[3];
        turmas[0] = Turma.lerNovaTurma();
        Aluno a1 = Aluno.lerNovoAluno();
        turmas[0].addAluno(a1);

        for (Aluno a : turmas[0].getAlunos()) {
            if (a != null) {
                System.out.println(a);
            }
        }

        turmas[0].removerAluno(a1);

        Professor p1 = Professor.lerNovoProfessor();
        turmas[0].setProfessor(p1);

        System.out.println(turmas[0].getProfessor());

        for (Turma t : p1.getTurmas()) {
            if (t != null) {
                System.out.println(t);
            }
        }

        Pessoa.sc.close();
        Pessoa.scString.close();
    }
}