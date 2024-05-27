package entities;

import utils.GeradorEmail;

import java.util.Random;

import static app.Main.sc;
import static app.Main.scString;

public class Professor extends Pessoa implements MembroAcademico {
    private String matricula;
    private String emailInstitucional;
    private String titulacao;

    public Professor(String nome, int idade, String email, String titulacao) {
        super(nome, idade, email);
        this.matricula = gerarMatricula();
        this.titulacao = titulacao;
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String gerarMatricula() {
        Random random = new Random();

        String str = "";

        for (int i = 0; i < 5; i++) {
            int n = random.nextInt(10);
            str += String.valueOf(n); // transformar int em String
        }

        return str;
    }

    public static Professor lerNovoProfessor() {
        System.out.println("Digite os dados do professor:");
        System.out.print("Nome: ");
        String nome = scString.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Email pessoal: ");
        String email = scString.nextLine();

        System.out.print("Titulação: ");
        String titulacao = scString.nextLine();

        return new Professor(nome, idade, email, titulacao);
    }

    @Override
    public String toString() {
        return  super.toString() +
                " Matrícula: " + matricula + "\n" +
                " Email Institucional: " + emailInstitucional + "\n" +
                " Titulação: " + titulacao + "\n" +
                "+------------------------------------------------------+\n";
    }
}
