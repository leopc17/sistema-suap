package app;

import entities.Aluno;
import entities.Turma;

public class Main {
    public static void main(String[] args) {
        Turma[] turmas = new Turma[3];
        turmas[0] = new Turma("Algoritmo");
        turmas[1] = new Turma("TCS");
        turmas[2] = new Turma("Fisica");

        Aluno a1 = new Aluno("Leonardo Vieira", 18);
        a1.setTurmas(turmas);
        System.out.println(a1);
    }
}