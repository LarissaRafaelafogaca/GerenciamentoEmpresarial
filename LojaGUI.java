package Loja;

import javax.swing.*;
import java.math.BigInteger;

public class LojaGUI {
    private Loja loja = new Loja();

    public LojaGUI() {
        menu();
    }

    private void menu() {
        String[] opcoes = {
            "1 - Cadastrar cliente",
            "2 - Cadastrar produto",
            "3 - Iniciar venda",
            "4 - Adicionar produto ao carrinho",
            "5 - Exibir conteúdo do carrinho",
            "6 - Fechar venda",
            "0 - Sair"
        };

        while (true) {
            String escolha = (String) JOptionPane.showInputDialog(
                null, "Escolha uma opção:", "Entrada",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
            );

            if (escolha == null || escolha.startsWith("0")) break;

            switch (escolha.charAt(0)) {
                case '1' -> cadastrarCliente();
                case '2' -> cadastrarProduto();
                case '3' -> iniciarVenda();
                case '4' -> adicionarProduto();
                case '5' -> exibirCarrinho();
                case '6' -> fecharVenda();
            }
        }
    }

    private void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        String cpf = JOptionPane.showInputDialog("CPF:");
        loja.cadastrarCliente(new Cliente(nome, new BigInteger(cpf)));
    }

    private void cadastrarProduto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto:"));
        loja.cadastrarProduto(new Produto(codigo, valor));
    }

    private void iniciarVenda() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        if (!loja.iniciarVenda(nome)) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }

    private void adicionarProduto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
        double desconto = Double.parseDouble(JOptionPane.showInputDialog("Desconto (%):"));
        loja.adicionarProduto(codigo, quantidade, desconto);
    }

    private void exibirCarrinho() {
        JOptionPane.showMessageDialog(null, loja.getVendaEmAndamento().toString());
    }

    private void fecharVenda() {
        JOptionPane.showMessageDialog(null, "Total da venda: R$" + loja.fecharVenda());
    }
}