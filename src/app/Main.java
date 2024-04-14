package app;

import entities.*;

import java.util.Scanner;

public class Main {
    public static final int TAM = 50;
    public static final Scanner sc = new Scanner(System.in);
    public static final Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        int escolha;

        Turma[] turmas = new Turma[TAM];
        Aluno[] alunos = new Aluno[TAM];
        Professor[] professores = new Professor[TAM];

        int qtdTurmas = 0, qtdAlunos = 0, qtdProfessores = 0;

        do {
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Criar Turma");
            System.out.println("2 - Criar Aluno");
            System.out.println("3 - Criar Professor");



            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    turmas[qtdTurmas] = Turma.lerNovaTurma();
                    System.out.println(turmas[qtdTurmas]);
                    qtdTurmas++;
                    break;
                case 2:
                    alunos[qtdAlunos] = Aluno.lerNovoAluno();
                    System.out.println(alunos[qtdAlunos]);
                    qtdAlunos++;
                    break;
                case 3:
                    professores[qtdProfessores] = Professor.lerNovoProfessor();
                    System.out.println(professores[qtdProfessores]);
                    qtdProfessores++;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 10);
    }
}