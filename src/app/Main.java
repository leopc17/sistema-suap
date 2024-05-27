package app;

import entities.Aluno;
import utils.Menu;

import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static final Scanner scString = new Scanner(System.in);

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Leo", 18, "leo@gmail.com");

        System.out.println(a1);
    }
}