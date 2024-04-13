package app;

import entities.Pessoa;
import entities.Professor;
import entities.Turma;

public class Main {
    public static void main(String[] args) {
        Turma[] turmas = new Turma[3];
        turmas[0] = Turma.lerNovaTurma();

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