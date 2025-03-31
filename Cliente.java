package Loja;

import java.math.BigInteger;

public class Cliente {
    private String nome;
    private BigInteger cpf;

    public Cliente(String nome, BigInteger cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }
}