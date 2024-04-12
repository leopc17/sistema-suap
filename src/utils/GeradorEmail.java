package utils;

import entities.Aluno;
import entities.Professor;

public class GeradorEmail {
    private static String dominioAluno = "@aluno.uepb.edu.br";
    private static String dominioServidor = "@servidor.uepb.edu.br";

    public static String gerarEmailInstitucional(Aluno a) {
        return a.getNome().toLowerCase().replace(" ", ".") + dominioAluno;
    }

    public static String gerarEmailInstitucional(Professor p) {
        return p.getNome().toLowerCase().replace(" ", ".") + dominioServidor;
    }
}
