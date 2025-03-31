package Loja;

public class Produto {
    private int codigo;
    private double valor;

    public Produto(int codigo, double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public double obterValorComDesconto(double percentual) {
        return valor - (valor * percentual / 100);
    }
}