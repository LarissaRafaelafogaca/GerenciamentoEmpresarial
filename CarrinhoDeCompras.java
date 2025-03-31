package Loja;

import java.util.ArrayList;

public class CarrinhoDeCompras {
    private ArrayList<ItemCarrinho> itens = new ArrayList<>();
    private Cliente cliente;

    public CarrinhoDeCompras(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean adicionarProduto(Produto produto, int quantidade, double desconto) {
        itens.add(new ItemCarrinho(produto, quantidade, desconto));
        return true;
    }

    public double obterValorTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.obterCusto();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        for (ItemCarrinho item : itens) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total: R$").append(obterValorTotal());
        return sb.toString();
    }
}