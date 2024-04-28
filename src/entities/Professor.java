package entities;

import utils.GeradorEmail;

import static app.Main.scString;

public class Professor extends Pessoa {
    private String emailInstitucional;
    private String titulacao;

    public Professor(String nome, int idade, String email, String titulacao) {
        super(nome, idade, email);
        this.titulacao = titulacao;
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
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

    public static Professor lerNovoProfessor() {
        System.out.println("Digite os dados do professor:");
        Pessoa p = lerNovaPessoa();

        System.out.print("Titulação: ");
        String titulacao = scString.nextLine();

        return new Professor(p.getNome(), p.getIdade(), p.getEmail(), titulacao);
    }

    @Override
    public String toString() {
        return  "+------------------------------------------------------+\n" +
                "|               Dados do(a) Professor(a)               |\n" +
                "+------------------------------------------------------+\n" +
                " Nome: " + getNome() + "\n" +
                " Idade: " + getIdade() + "\n" +
                " Titulação: " + titulacao + "\n" +
                "+------------------------------------------------------+\n";
    }
}
