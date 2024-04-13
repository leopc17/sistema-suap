package entities;

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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        professor.adicionarTurma(this);
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

    public static Turma lerNovaTurma() {
        System.out.print("Digite o código da turma (id): ");
        int id = Pessoa.sc.nextInt();

        System.out.print("Digite o ano letivo da turma no formato (ano/semestre): ");
        String ano = Pessoa.scString.nextLine();

        System.out.print("Digite o nome da disciplina: ");
        String disciplina = Pessoa.scString.nextLine();

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
