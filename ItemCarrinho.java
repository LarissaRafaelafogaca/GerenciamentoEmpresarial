package Loja;

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;
    private double desconto;

    public ItemCarrinho(Produto produto, int quantidade, double desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public double obterCusto() {
        return (produto.obterValorComDesconto(desconto)) * quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getCodigo() +
               ", Quantidade: " + quantidade +
               ", Desconto: " + desconto + "%" +
               ", Custo: R$" + obterCusto();
    }
}