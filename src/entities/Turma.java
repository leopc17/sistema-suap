package entities;

import static app.Main.sc;
import static app.Main.scString;

public class Turma {
    private final int TAM = 50;

    private int id;
    private String ano; // AnoLetivo
    private String disciplina;
    private Aluno[] alunos;
    private int qtdAlunos;
    private Professor professor;

    public Turma(int id, String ano, String disciplina) {
        this.id = id;
        this.ano = ano;
        this.disciplina = disciplina;
        this.alunos = new Aluno[TAM];
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

    public Aluno[] getAlunos() {
        return alunos;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void addProfessor(Professor p) {
        this.professor = p;
    }


    // esse método é só caso
    // a turma não tenha professor
    // o toString consiga imprimir o nome vazio

    private String getNomeProfessor() {
        if (professor == null) {
            return "";
        } else {
            return professor.getNome();
        }
    }

    public boolean alunoExiste(Aluno a) {
        for(int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].getMatricula().equals(a.getMatricula())) {
                return true;
            }
        }

        return false;
    }

    public boolean addAluno(Aluno a) {
        if (alunoExiste(a)) {
            return false;
        }

        if (a == null) {
            return false;
        }

        if (qtdAlunos < alunos.length) {
            alunos[qtdAlunos] = a;
            qtdAlunos++;
            return true;
        }

        return false;
    }

    public boolean removerAluno(Aluno a) {
        if (a == null) {
            return false;
        }

        for (int i = 0; i < qtdAlunos; i++) {
            if (alunos[i].getMatricula().equals(a.getMatricula())) {
                alunos[i] = null;
                qtdAlunos--;
                return true;
            }
        }

        return false;
    }

    public void aplicarProva() {
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.printf("Nota do aluno %s na disciplina de %s: ", alunos[i].getNome(), disciplina);
            float nota = sc.nextFloat();

            Prova p = new Prova(alunos[i], this, nota);
            alunos[i].addProva(p);
        }
    }

    public static Turma lerNovaTurma() {
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
         // certo = [florido, seneca]
         // errado = [florido, seneca, ]

        String nomeAlunos = "[";

        for (int i = 0; i < qtdAlunos; i++) {
            nomeAlunos += alunos[i].getNome();
            if (i < qtdAlunos - 1) {
                nomeAlunos += ", ";
            }
        }

        nomeAlunos += "]";

        return  "+--------------------------------------------+\n" +
                "|               Dados da Turma               |\n" +
                "+--------------------------------------------+\n" +
                " Id: " + id + "\n" +
                " Ano: " + ano + "\n" +
                " Disciplina: " + disciplina + "\n" +
                " Alunos: " + nomeAlunos + "\n" +
                " Professor: " + getNomeProfessor() + "\n" +
                "+--------------------------------------------+\n";
    }
}
