package entities;

import java.util.Scanner;

public class Pessoa {
    public static final Scanner sc = new Scanner(System.in);
    public static final Scanner scString = new Scanner(System.in);

    private String nome;
    private int idade;
    private String email;

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Pessoa lerNovaPessoa() {
        System.out.print("Nome: ");
        String nome = scString.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Email pessoal: ");
        String email = scString.nextLine();

        return new Pessoa(nome, idade, email);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }
}
