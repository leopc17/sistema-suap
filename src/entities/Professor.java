package entities;

import utils.GeradorEmail;

public class Professor extends Pessoa{
    private final int TAM = 10;

    private String emailInstitucional;
    private String titulacao;
    private Turma[] turmas;
    private int qtdTurmas;

    public Professor(String nome, int idade, String email, String titulacao) {
        super(nome, idade, email);
        this.titulacao = titulacao;
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
        this.turmas = new Turma[TAM];
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

    public Turma[] getTurmas() {
        return turmas;
    }

    public int getQtdTurmas() {
        return qtdTurmas;
    }

    public boolean turmaExiste(Turma t) {
        for(int i = 0; i < qtdTurmas; i++) {
            if (turmas[i].getId() == t.getId()) {
                return true;
            }
        }

        return false;
    }

    public boolean addTurma(Turma t) {
        if (turmaExiste(t)) {
            return false;
        }

        if (t == null) {
            return false;
        }

        if (qtdTurmas < turmas.length) {
            turmas[qtdTurmas] = t;
            qtdTurmas++;
            t.addProfessor(this);
            return true;
        }

        return false;
    }

    public boolean removerTurma(Turma t) {
        if (t == null) {
            return false;
        }

        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i].getId() == t.getId()) {
                turmas[i] = null;
                qtdTurmas--;
                t.addProfessor(null);
                return true;
            }
        }

        return false;
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
        String nomeTurmas = "[";

        for (int i = 0; i < qtdTurmas; i++) {
            nomeTurmas += turmas[i].getDisciplina();
            if (i < qtdTurmas - 1) {
                nomeTurmas += ", ";
            }
        }

        nomeTurmas += "]";

        return  "+------------------------------------------------------+\n" +
                "|               Dados do(a) Professor(a)               |\n" +
                "+------------------------------------------------------+\n" +
                " Nome: " + getNome() + "\n" +
                " Idade: " + getIdade() + "\n" +
                " Titulação: " + titulacao + "\n" +
                " Turmas lecionadas: " + nomeTurmas + "\n" +
                "+------------------------------------------------------+\n";
    }
}
