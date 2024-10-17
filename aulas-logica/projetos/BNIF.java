/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bnif;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class BNIF {

    private static Map<String, Double> contas = new HashMap<>();

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        String[] opcoes = { "1. Criar conta", "2. Ver saldo", "3. Depositar", "4. Sacar", "5. Transferir", "6. Sair" };

        while (true) {
            String escolha = (String) JOptionPane.showInputDialog(null, " SEJA BEM VINDO AO BENIF ,Por favor selecione uma opção:", "BANCO BNIF",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha != null) {
                switch (escolha.charAt(0)) {
                    case '1':
                        criarConta();
                        break;
                    case '2':
                        verSaldo();
                        break;
                    case '3':
                        depositar();
                        break;
                    case '4':
                        sacar();
                        break;
                    case '5':
                        transferir();
                        break;
                    case '6':
                        JOptionPane.showMessageDialog(null, "O BNIF agradece a preferência :>");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void criarConta() {
        String nome = JOptionPane.showInputDialog(null, "Digite sua matrícula ou usuário no SIGAA e deposite algum valor para criar uma conta no BNIF", "Criar Conta",
                JOptionPane.QUESTION_MESSAGE);

        if (nome != null) {
            if (contas.containsKey(nome)) {
                JOptionPane.showMessageDialog(null, "Você já está cadastrado!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String saldoInicial = JOptionPane.showInputDialog(null, "Deposite um saldo para validar sua conta:", "Criar Conta",
                        JOptionPane.QUESTION_MESSAGE);

                if (saldoInicial != null) {
                    try {
                        double saldo = Double.parseDouble(saldoInicial);
                        if (saldo > 0) {
                            contas.put(nome, saldo);
                            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "Criar Conta",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "O saldo inicial deve ser um valor positivo!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void verSaldo() {
        String nome = JOptionPane.showInputDialog(null, "Digite seu usuário:", "Ver Saldo",
                JOptionPane.QUESTION_MESSAGE);

        if (nome != null) {
            if (contas.containsKey(nome)) {
                double saldo = contas.get(nome);

                JOptionPane.showMessageDialog(null, "Saldo da conta " + nome + ": R$ " + saldo, "Ver Saldo",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void depositar() {
        String nome = JOptionPane.showInputDialog(null, "Digite o usuário ou o número da matrícula", "Depositar",
                JOptionPane.QUESTION_MESSAGE);

        if (nome != null) {
            if (contas.containsKey(nome)) {
                String valor = JOptionPane.showInputDialog(null, "Digite o valor a ser depositado:", "Depositar",
                        JOptionPane.QUESTION_MESSAGE);

                if (valor != null) {
                    try {
                        double valorDeposito = Double.parseDouble(valor);
                        if (valorDeposito >= 0) {
                            double saldoAtual = contas.get(nome);
                            double novoSaldo = saldoAtual + valorDeposito;
                            contas.put(nome, novoSaldo);
                            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso! Novo saldo da conta " + nome + ": R$ " + novoSaldo,
                                    "Depositar", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "O valor a ser depositado deve ser um valor positivo!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não registrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void sacar() {
        String nome = JOptionPane.showInputDialog(null, "Digite seu usuário:", "Sacar",
                JOptionPane.QUESTION_MESSAGE);

        if (nome != null) {
            if (contas.containsKey(nome)) {
                String valor = JOptionPane.showInputDialog(null, "Digite o valor a ser sacado:", "Sacar",
                        JOptionPane.QUESTION_MESSAGE);

                if (valor != null) {
                    try {
                        double valorSaque = Double.parseDouble(valor);
                        if (valorSaque >= 0) {
                            double saldoAtual = contas.get(nome);
                            if (valorSaque <= saldoAtual) {
                                double novoSaldo = saldoAtual - valorSaque;
                                contas.put(nome, novoSaldo);
                                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Novo saldo da conta " + nome + ": R$ " + novoSaldo,
                                        "Sacar", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "O valor a ser sacado deve ser um valor positivo!", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void transferir() {
        String nomeOrigem = JOptionPane.showInputDialog(null, "Digite seu usuário ou número de matrícula:", "Transferir",
                JOptionPane.QUESTION_MESSAGE);

        if (nomeOrigem != null) {
            if (contas.containsKey(nomeOrigem)) {
                String nomeDestino = JOptionPane.showInputDialog(null, "Digite o usuário ou número da matrícula do destinatário:", "Transferir",
                        JOptionPane.QUESTION_MESSAGE);

                if (nomeDestino != null) {
                    if (contas.containsKey(nomeDestino) && !nomeOrigem.equals(nomeDestino)) {
                        String valor = JOptionPane.showInputDialog(null, "Digite o valor a ser transferido:", "Transferir",
                                JOptionPane.QUESTION_MESSAGE);

                        if (valor != null) {
                            try {
                                double valorTransferencia = Double.parseDouble(valor);
                                if (valorTransferencia >= 0) {
                                    double saldoOrigem = contas.get(nomeOrigem);
                                    if (valorTransferencia <= saldoOrigem) {
                                        double saldoDestino = contas.get(nomeDestino);
                                        double novoSaldoOrigem = saldoOrigem - valorTransferencia;
                                        double novoSaldoDestino = saldoDestino + valorTransferencia;
                                        contas.put(nomeOrigem, novoSaldoOrigem);
                                        contas.put(nomeDestino, novoSaldoDestino);
                                        JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso! Novo saldo da conta " + nomeOrigem + ": R$ " + novoSaldoOrigem
                                                , "Transferir",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "O valor a ser transferido deve ser um valor positivo!", "Erro",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "VOCÊ NÃO PODE TRANSFERIR PARA SI MESMO!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Conta de origem não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao digitar o usuário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
