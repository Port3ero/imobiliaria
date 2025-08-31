package com.diogo;

import com.diogo.dao.ClienteDAO;
import com.diogo.dao.ImovelDAO;
import com.diogo.dao.ContratoDAO;
import com.diogo.model.Cliente;
import com.diogo.model.Imovel;
import com.diogo.model.Contrato;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ImovelDAO imovelDAO = new ImovelDAO();
        ContratoDAO contratoDAO = new ContratoDAO();

        while (true) {
            System.out.println("\n===== MENU IMOBILIÁRIA =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Imóvel");
            System.out.println("4 - Listar Imóveis Disponíveis");
            System.out.println("5 - Cadastrar Contrato");
            System.out.println("6 - Listar Contratos Ativos");
            System.out.println("7 - Listar Contratos Expirando em 30 dias");
            System.out.println("8 - Clientes com mais contratos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (opcao == 1) { // Cadastrar Cliente
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF (somente números): ");
                String cpf = sc.nextLine();
                System.out.print("Telefone: ");
                String telefone = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();

                Cliente cliente = new Cliente(nome, cpf, telefone, email);
                clienteDAO.salvar(cliente);

            } else if (opcao == 2) { // Listar Clientes
                List<Cliente> clientes = clienteDAO.listar();
                System.out.println("\n=== Lista de Clientes ===");
                for (Cliente c : clientes) {
                    System.out.println(c);
                }

            } else if (opcao == 3) { // Cadastrar Imóvel
                System.out.print("Tipo: ");
                String tipo = sc.nextLine();
                System.out.print("Endereço: ");
                String endereco = sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();
                System.out.print("Estado (UF): ");
                String estado = sc.nextLine();
                System.out.print("CEP: ");
                String cep = sc.nextLine();
                System.out.print("Quartos: ");
                int quartos = sc.nextInt();
                System.out.print("Banheiros: ");
                int banheiros = sc.nextInt();
                System.out.print("Área (m²): ");
                double area = sc.nextDouble();
                System.out.print("Valor do Aluguel: ");
                double valor = sc.nextDouble();
                sc.nextLine(); // limpar buffer

                Imovel imovel = new Imovel(tipo, endereco, cidade, estado, cep, quartos, banheiros, area, valor);
                imovelDAO.salvar(imovel);

            } else if (opcao == 4) { // Listar Imóveis Disponíveis
                List<Imovel> imoveis = imovelDAO.listarDisponiveis();
                System.out.println("\n=== Imóveis Disponíveis ===");
                for (Imovel i : imoveis) {
                    System.out.println(i);
                }

            } else if (opcao == 5) { // Cadastrar Contrato
                System.out.print("ID do Imóvel: ");
                int idImovel = sc.nextInt();
                System.out.print("ID do Cliente: ");
                int idCliente = sc.nextInt();
                System.out.print("Valor Mensal: ");
                double valor = sc.nextDouble();
                System.out.print("Data Início (YYYY-MM-DD): ");
                String inicio = sc.next();
                System.out.print("Data Fim (YYYY-MM-DD): ");
                String fim = sc.next();
                sc.nextLine(); // limpar buffer

                Contrato contrato = new Contrato(idImovel, idCliente, valor,
                        java.time.LocalDate.parse(inicio),
                        java.time.LocalDate.parse(fim));
                contratoDAO.salvar(contrato);

            } else if (opcao == 6) { // Listar Contratos Ativos
                List<Contrato> ativos = contratoDAO.listarAtivos();
                System.out.println("\n=== Contratos Ativos ===");
                for (Contrato c : ativos) {
                    System.out.println(c);
                }

            } else if (opcao == 7) { // Contratos Expirando em 30 dias
                List<Contrato> expirando = contratoDAO.listarExpirando30Dias();
                System.out.println("\n=== Contratos Expirando em 30 dias ===");
                for (Contrato c : expirando) {
                    System.out.println(c);
                }

            } else if (opcao == 8) { // Clientes com mais contratos
                List<String> ranking = clienteDAO.clientesComMaisContratos();
                System.out.println("\n=== Clientes com mais contratos ===");
                for (String s : ranking) {
                    System.out.println(s);
                }

            } else if (opcao == 0) { // Sair
                System.out.println("Encerrando...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}