package br.com.fiap;

import java.time.LocalDate;

// RM97857 Joao Pedro Oliveira Chambrone
// RM98565 Gabriel Oliveira Rodrigues
import java.util.Scanner;

public class UsaAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciando objetos da classe Aluno
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno(97857, "Joao Pedro Oliveira Chambrone", LocalDate.of(2005, 01, 06));
        Aluno aluno4 = new Aluno(98565, "Gabriel Oliveira Rodrigues", LocalDate.of(2004, 4, 05));

        // Pedindo ao usuário para inserir os valores para os alunos 1 e 2
        System.out.println("Insira os dados dos alunos 1 e 2:");
        preencherAluno(scanner, aluno1, 1);
        preencherAluno(scanner, aluno2, 2);

        // Obtendo a data atual
        LocalDate dataAtual = LocalDate.now();

        // Exibindo informações dos alunos
        System.out.println("\nInformações dos alunos:");
        exibirInformacoesAluno(aluno1, dataAtual);
        exibirInformacoesAluno(aluno2, dataAtual);
        exibirInformacoesAluno(aluno3, dataAtual);
        exibirInformacoesAluno(aluno4, dataAtual);

        scanner.close();
    }

    // Método para preencher os dados de um aluno
    private static void preencherAluno(Scanner scanner, Aluno aluno, int numero) {
        System.out.println("\nAluno " + numero + ":");
        System.out.print("Insira o RM:(entre 97001 e 551999)");
        aluno.setRm(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Insira o nome: ");
        aluno.setNome(scanner.nextLine());
        System.out.println("Insira a data de nascimento (Formato: AAAA-MM-DD, Deve ser maior ou igual 1900, e menor e igual ao ano atual, deve incluir '-' entre as datas.");
        String dataStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataStr);
        aluno.setDataDeNascimento(dataNascimento);
    }

    // Método para exibir as informações de um aluno
    private static void exibirInformacoesAluno(Aluno aluno, LocalDate dataAtual) {
        System.out.println("\nRM: " + aluno.getRm());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade completa: " + aluno.calculaIdadeCompleta(dataAtual));
    }
}
