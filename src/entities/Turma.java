package entities;

import java.util.Scanner;

public class Turma {
    private int id;
    private String ano; // AnoLetivo
    private String disciplina;
    private Professor professor;

    public Turma(int id, String ano, String disciplina) {
        this.id = id;
        this.ano = ano;
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        professor.adicionarTurma(this);
    }

    public static Turma lerNovaTurma(Scanner sc, Scanner scString) {
        System.out.print("Digite o código da turma (id): ");
        int id = sc.nextInt();

        System.out.print("Digite o ano letivo da turma no formato (ano/semestre): ");
        String ano = scString.nextLine();

        System.out.print("Digite o nome da disciplina: ");
        String disciplina = scString.nextLine();

        return new Turma(id, ano, disciplina);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
