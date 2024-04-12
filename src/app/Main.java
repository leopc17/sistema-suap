package app;

import entities.Aluno;
import entities.Pessoa;
import entities.Professor;
import entities.Turma;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        Turma[] turmas = new Turma[3];
        turmas[0] = Turma.lerNovaTurma(sc, scString);

        Professor p1 = Professor.lerNovoProfessor(sc, scString);
        turmas[0].setProfessor(p1);

        System.out.println(turmas[0].getProfessor());

        for (Turma t : p1.getTurmas()) {
            if (t != null) {
                System.out.println(t);
            }
        }

        sc.close();
        scString.close();
    }
}