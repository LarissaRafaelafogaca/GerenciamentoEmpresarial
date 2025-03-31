package Loja;

import java.util.ArrayList;

public class Loja {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Produto> estoque = new ArrayList<>();
    private ArrayList<CarrinhoDeCompras> vendasFinalizadas = new ArrayList<>();
    private CarrinhoDeCompras vendaEmAndamento;

    public void cadastrarCliente(Cliente novo) {
        clientes.add(novo);
    }

    public Cliente pesquisarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public void cadastrarProduto(Produto novo) {
        estoque.add(novo);
    }

    public Produto pesquisarProduto(int codigo) {
        for (Produto p : estoque) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public boolean iniciarVenda(String nomeCliente) {
        Cliente cliente = pesquisarCliente(nomeCliente);
        if (cliente != null) {
            vendaEmAndamento = new CarrinhoDeCompras(cliente);
            return true;
        }
        return false;
    }

    public boolean adicionarProduto(int codigo, int quantidade, double desconto) {
        if (vendaEmAndamento == null) return false;

        Produto produto = pesquisarProduto(codigo);
        if (produto != null) {
            return vendaEmAndamento.adicionarProduto(produto, quantidade, desconto);
        }
        return false;
    }

    public double fecharVenda() {
        if (vendaEmAndamento != null) {
            double total = vendaEmAndamento.obterValorTotal();
            vendasFinalizadas.add(vendaEmAndamento);
            vendaEmAndamento = null;
            return total;
        }
        return 0.0;
    }

    public CarrinhoDeCompras getVendaEmAndamento() {
        return vendaEmAndamento;
    }
}