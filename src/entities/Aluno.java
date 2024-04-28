package entities;

import utils.GeradorEmail;

import java.util.Random;

public class Aluno extends Pessoa {
    private String matricula;
    private String emailInstitucional;
    private Prova[] provas;

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

    public Prova[] getProvas() {
        return provas;
    }

    public void addProva(Prova p) {
        for (int i = 0; i < provas.length; i++) {
            if (provas[i] == null) {
                provas[i] = p;
            }
        }
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

    public static Aluno lerNovoAluno() {
        System.out.println("Digite os dados do aluno:");
        Pessoa p = lerNovaPessoa();

        return new Aluno(p.getNome(), p.getIdade(), p.getEmail());
    }

    @Override
    public String toString() {
        return  "+--------------------------------------------+\n" +
                "|               Dados do(a) Aluno(a)         |\n" +
                "+--------------------------------------------+\n" +
                " Nome: " + getNome() + "\n" +
                " Idade: " + getIdade() + "\n" +
                " Matrícula: " + matricula + "\n" +
                " Email Institucional: " + emailInstitucional + "\n" +
                "+--------------------------------------------+\n";
    }
}