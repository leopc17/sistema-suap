package entities;

import utils.GeradorEmail;

import java.util.Random;

public class Aluno extends Pessoa {
    private final int TAM = 5;

    private String matricula;
    private String emailInstitucional;
    private Turma[] turmas;
    private int qtdTurmas;

    public Aluno(String nome, int idade, String email) {
        super(nome, idade, email);
        this.matricula = gerarMatricula();
        this.emailInstitucional = GeradorEmail.gerarEmailInstitucional(this);
        this.turmas = new Turma[TAM];
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

    public boolean matricular(Turma t) {
        if (turmaExiste(t)) {
            return false;
        }

        if (t == null) {
            return false;
        }

        if (qtdTurmas < turmas.length) {
            turmas[qtdTurmas] = t;
            qtdTurmas++;
            return true;
        }

        return false;
    }

    public boolean desmatricular(Turma t) {
        if (t == null) {
            return false;
        }

        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i].getId() == t.getId()) {
                turmas[i] = null;
                qtdTurmas--;
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
        String nomeTurmas = "[";

        for (int i = 0; i < qtdTurmas; i++) {
            nomeTurmas += turmas[i].getDisciplina();
            if (i < qtdTurmas - 1) {
                nomeTurmas += ", ";
            }
        }

        nomeTurmas += "]";

        return  "+--------------------------------------------+\n" +
                "|               Dados do(a) Aluno(a)         |\n" +
                "+--------------------------------------------+\n" +
                " Nome: " + getNome() + "\n" +
                " Idade: " + getIdade() + "\n" +
                " Matrícula: " + getMatricula() + "\n" +
                " Turmas matriculadas: " + nomeTurmas + "\n" +
                "+--------------------------------------------+\n";
    }
}