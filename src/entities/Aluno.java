package entities;

import utils.GeradorEmail;

import java.util.Random;

import static app.Main.sc;
import static app.Main.scString;

public class Aluno extends Pessoa {
    private final int TAM = 5;

    private String matricula;
    private String emailInstitucional;
    private Prova[] provas;

    public Aluno(String nome, int idade, String email) {
        super(nome, idade, email);
        this.matricula = gerarMatricula();
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
        this.provas = new Prova[TAM];
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

    public boolean addProva(Prova p) {
        for (int i = 0; i < provas.length; i++) {
            if (provas[i] == null) {
                provas[i] = p;
                return true;
            }
        }

        return false;
    }

    private String gerarMatricula() {
        Random random = new Random();

        String str = "";

        for (int i = 0; i < 9; i++) {
            int n = random.nextInt(10);
            str += String.valueOf(n); // transformar int em String
        }

        return str;
    }

    public static Aluno lerNovoAluno() {
        System.out.println("Digite os dados do aluno:");
        System.out.print("Nome: ");
        String nome = scString.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Email pessoal: ");
        String email = scString.nextLine();

        return new Aluno(nome, idade, email);
    }

    @Override
    public String toString() {
        return  super.toString() +
                " Matrícula: " + matricula + "\n" +
                " Email Institucional: " + emailInstitucional + "\n" +
                "+--------------------------------------------+\n";
    }
}