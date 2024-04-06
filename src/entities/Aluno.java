package entities;

import utils.GeradorEmail;

import java.util.Random;

public class Aluno extends Pessoa {
    private final String matricula;
    private final String emailInstitucional;
    private Turma[] turmas;

    public Aluno(String nome, int idade) {
        super(nome, idade);
        this.matricula = gerarMatricula();
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
    }

    public Aluno(String nome, int idade, String email) {
        super(nome, idade, email);
        this.matricula = gerarMatricula();
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public Turma[] getTurmas() {
        return turmas;
    }

    public void setTurmas(Turma[] turmas) {
        this.turmas = turmas;
    }

    private String gerarMatricula() {
        Random random = new Random();

        String str = "";

        for (int i = 0; i < 9; i++) {
            int n = random.nextInt(10);
            str += String.valueOf(n);
        }

        return str;
    }

    @Override
    public String toString() {
        String nomeTurmas = "[";

        for (int i = 0; i < turmas.length; i++) {
            nomeTurmas += turmas[i].getDisciplina();
            if (i < turmas.length - 1) {
                nomeTurmas += ", ";
            }
        }

        nomeTurmas += "]";

        return  "+----------------------------------+\n" +
                "|          Ficha do Aluno          |\n" +
                "+----------------------------------+\n" +
                "| Nome: " + getNome() + "    |\n" +
                "| Idade: " + getIdade() + "      |\n" +
                "| Matrícula: " + getMatricula() + "    |\n" +
                "| Turmas matriculadas: " + nomeTurmas + " |\n" +
                "+----------------------------------+\n";
    }
}
