package br.com.fiap;

import java.time.LocalDate;

//RM97857 Joao Pedro Oliveira Chambrone
//RM98565 Gabriel Oliveira Rodrigues
import java.time.Period;

public class Aluno {
    private int rm;
    private String nome;
    private LocalDate dataDeNascimento;

    // Construtor vazio
    public Aluno() {
    }

    // Construtor com parâmetros
    public Aluno(int rm, String nome, LocalDate dataDeNascimento) {
        this.rm = rm;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    // Getter e Setter para rm
    public int getRm() {
        return rm;
    }

    public void setRm(int rm) {
        // Verifica se o rm está dentro dos limites especificados
        if (rm >= 97001 && rm <= 551999) {
            this.rm = rm;
        } else {
            System.out.println("RM fora do intervalo permitido.");
        }
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para dataDeNascimento
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        // Verifica se a data de nascimento está dentro dos limites especificados
        LocalDate dataAtual = LocalDate.now();
        if (dataDeNascimento.getYear() >= 1900 && dataDeNascimento.isBefore(dataAtual)) {
            this.dataDeNascimento = dataDeNascimento;
        } else {
            System.out.println("Data de nascimento inválida.");
        }
    }

    // Método para calcular idade completa
    public String calculaIdadeCompleta(LocalDate dataAtual) {
        Period periodo = Period.between(dataDeNascimento, dataAtual);
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();
        return anos + " anos, " + meses + " meses e " + dias + " dias";
    }

    // Método para calcular idade completa usando a data atual do sistema
    public String calculaIdadeCompleta() {
        return calculaIdadeCompleta(LocalDate.now());
    }

}
