package entities;

public class Prova {
    private Aluno aluno;
    private Turma turma;
    private float nota;

    public Prova(Aluno aluno, Turma turma, float nota) {
        this.aluno = aluno;
        this.turma = turma;
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Nota do aluno " + aluno.getNome() + " na disciplina de " + turma.getDisciplina()+ ": " + String.format("%.2f", nota);
    }
}
