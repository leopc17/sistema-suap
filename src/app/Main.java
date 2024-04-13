package app;

import entities.Aluno;
import entities.Pessoa;
import entities.Professor;
import entities.Turma;
import entities.Prova;

public class Main {
    public static void main(String[] args) {
        Turma t1 = Turma.lerNovaTurma();
        Aluno a1 = Aluno.lerNovoAluno();
        Aluno a2 = Aluno.lerNovoAluno();
        Professor p1 = Professor.lerNovoProfessor();

        t1.addProfessor(p1);
        a1.matricular(t1);
        a2.matricular(t1);

        t1.aplicarProva();

        for (Prova p : a1.getProvas()) {
            if (p != null) {
                System.out.println(p);
            }
        }

        for (Prova p : a2.getProvas()) {
            if (p != null) {
                System.out.println(p);
            }
        }

        Pessoa.sc.close();
        Pessoa.scString.close();
    }
}