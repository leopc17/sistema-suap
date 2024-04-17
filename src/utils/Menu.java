package utils;

import entities.*;

import static app.Main.sc;
import static app.Main.scString;

public class Menu {
    private static final int TAM = 50;
    private static Turma[] turmas = new Turma[TAM];
    private static Aluno[] alunos = new Aluno[TAM];
    private static Professor[] professores = new Professor[TAM];
    private static int qtdTurmas = 0, qtdAlunos = 0, qtdProfessores = 0;

    public static void exibir() {
        int escolha;

        do {
            System.out.println("Escolha uma das opções:");
            System.out.println("01 - Criar Turma");
            System.out.println("02 - Criar Aluno");
            System.out.println("03 - Criar Professor");
            System.out.println("04 - Exibir Dados da Turma");
            System.out.println("05 - Exibir Dados do Aluno");
            System.out.println("06 - Exibir Dados do Professor");
            System.out.println("07 - Exibir Todas as Turmas");
            System.out.println("08 - Exibir Todos os Alunos");
            System.out.println("09 - Exibir Todos os Professores");
            System.out.println("10 - Matricular Aluno");
            System.out.println("11 - Desmatricular Aluno");
            System.out.println("12 - Adicionar Professor na Turma");
            System.out.println("13 - Aplicar Prova");
            System.out.println("14 - Exibir todas as notas do Aluno");
            System.out.println("15 - Encerrar");

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
                case 4:
                    System.out.print("Digite o id da turma: ");
                    int id1 = sc.nextInt();

                    Turma t1 = acharTurma(id1);

                    if (t1 == null) {
                        System.out.print("Turma não encontrada");
                        break;
                    }

                    System.out.print(t1);

                    break;
                case 5:
                    System.out.print("Digite a matricula do aluno: ");
                    String m1 = scString.nextLine();

                    Aluno a1 = acharAluno(m1);

                    if (a1 == null) {
                        System.out.println("Aluno não encontrado");
                        break;
                    }

                    System.out.println(a1);
                    break;
                case 6:
                    System.out.print("Digite o nome do professor: ");
                    String m2 = scString.nextLine();

                    Professor p1 = acharProfessor(m2);

                    if (p1 == null) {
                        System.out.println("Professor não encontrado");
                        break;
                    }

                    System.out.println(p1);
                    break;
                case 7:
                    System.out.println("Todas as Turmas: ");
                    for (int i = 0; i < qtdTurmas; i++) {
                        System.out.println(turmas[i].getDisciplina() + "(" + turmas[i].getId() + ")" );
                    }
                    break;
                case 8:
                    System.out.println("Todos os Alunos: ");
                    for (int i = 0; i < qtdAlunos; i++) {
                        System.out.println(alunos[i].getNome() + "(" + alunos[i].getMatricula() + ")" );
                    }
                    break;
                case 9:
                    System.out.println("Todos os Professores: ");
                    for (int i = 0; i < qtdProfessores; i++) {
                        System.out.println(professores[i].getNome() + "(" + professores[i].getTitulacao() + ")" );
                    }
                    break;
                case 10:
                    System.out.print("Digite a matricula do aluno: ");
                    String m3 = scString.nextLine();
                    System.out.print("Digite o id da turma: ");
                    int id2 = sc.nextInt();
                    Aluno a2 = acharAluno(m3);
                    Turma t2 = acharTurma(id2);

                    if (t2 == null) {
                        System.out.println("Turma não encontrada");
                        break;
                    }

                    if (a2 == null) {
                        System.out.println("Aluno não encontrado");
                        break;
                    }

                    a2.matricular(t2);
                    System.out.println("Aluno matriculado com sucesso!");
                    break;
                case 11:
                    System.out.print("Digite a matricula do aluno: ");
                    String m4 = scString.nextLine();
                    System.out.print("Digite o id da turma: ");
                    int id3 = sc.nextInt();
                    Aluno a3 = acharAluno(m4);
                    Turma t3 = acharTurma(id3);

                    if (t3 == null) {
                        System.out.println("Turma não encontrada");
                        break;
                    }

                    if (a3 == null) {
                        System.out.println("Aluno não encontrado");
                        break;
                    }

                    a3.desmatricular(t3);
                    System.out.println("O aluno foi desmatriculado com sucesso!");
                    break;
                case 12:
                    System.out.print("Digite o nome do professor: ");
                    String n1 = scString.nextLine();
                    System.out.print("Digite o id da turma: ");
                    int id4 = sc.nextInt();

                    Professor p2 = acharProfessor(n1);
                    Turma t4 = acharTurma(id4);

                    if (t4 == null) {
                        System.out.println("Turma não encontrada");
                        break;
                    }

                    if (p2 == null) {
                        System.out.println("Professor não encontrado");
                        break;
                    }

                    System.out.println("Professor adicionado!");
                    t4.addProfessor(p2);
                    break;
                case 13:
                    System.out.print("Digite o id da turma: ");
                    int id5 = sc.nextInt();

                    Turma t5 = acharTurma(id5);

                    if (t5 == null) {
                        System.out.println("Turma não encontrada");
                        break;
                    }

                    t5.aplicarProva();
                    break;
                case 14:
                    System.out.print("Digite a matricula do aluno: ");
                    String m5 = scString.nextLine();
                    Aluno a4 = acharAluno(m5);

                    if (a4 == null) {
                        System.out.println("Aluno não encontrado");
                        break;
                    }

                    for (Prova p : a4.getProvas()) {
                        if (p != null) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 15:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 15);
    }

    private static Aluno acharAluno(String matricula) {
        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                return alunos[i];
            }
        }
        return null;
    }

    private static Turma acharTurma(int id) {
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    private static Professor acharProfessor(String nome) {
        for (int i = 0; i < qtdProfessores; i++) {
            if (professores[i].getNome().equals(nome)) {
                return professores[i];
            }
        }
        return null;
    }
}
