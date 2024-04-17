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

    private String removerAcentos (String texto){
        texto = texto.replaceAll("[ÂÀÁÄÃ]","A");
        texto = texto.replaceAll("[âãàáä]","a");
        texto = texto.replaceAll("[ÊÈÉË]","E");
        texto = texto.replaceAll("[êèéë]","e");
        texto = texto.replaceAll("ÎÍÌÏ","I");
        texto = texto.replaceAll("îíìï","i");
        texto = texto.replaceAll("[ÔÕÒÓÖ]","O");
        texto = texto.replaceAll("[ôõòóö]","o");
        texto = texto.replaceAll("[ÛÙÚÜ]","U");
        texto = texto.replaceAll("[ûúùü]","u");
        texto = texto.replaceAll("Ç","C");
        texto = texto.replaceAll("ç","c");
        texto = texto.replaceAll("[ýÿ]","y");
        texto = texto.replaceAll("Ý","Y");
        texto = texto.replaceAll("ñ","n");
        texto = texto.replaceAll("Ñ","N");
        return texto;
    }
}
