package com.lucas.dao;

import com.lucas.model.Contrato;
import com.lucas.util.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {

    public void salvar(Contrato contrato) {
        String sql = "INSERT INTO contrato (id_imovel, id_cliente, valor_mensal, data_inicio, data_fim, ativo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contrato.getIdImovel());
            stmt.setInt(2, contrato.getIdCliente());
            stmt.setDouble(3, contrato.getValorMensal());
            stmt.setDate(4, Date.valueOf(contrato.getDataInicio()));
            stmt.setDate(5, Date.valueOf(contrato.getDataFim()));
            stmt.setBoolean(6, contrato.isAtivo());

            stmt.executeUpdate();
            System.out.println("Contrato cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar contrato: " + e.getMessage());
        }
    }

    public List<Contrato> listarAtivos() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contrato WHERE ativo = TRUE";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato();
                c.setIdContrato(rs.getInt("id_contrato"));
                c.setIdImovel(rs.getInt("id_imovel"));
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setValorMensal(rs.getDouble("valor_mensal"));
                c.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                c.setDataFim(rs.getDate("data_fim").toLocalDate());
                c.setAtivo(rs.getBoolean("ativo"));

                lista.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar contratos ativos: " + e.getMessage());
        }
        return lista;
    }

    public List<Contrato> listarExpirando30Dias() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contrato WHERE ativo = TRUE AND data_fim BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato();
                c.setIdContrato(rs.getInt("id_contrato"));
                c.setIdImovel(rs.getInt("id_imovel"));
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setValorMensal(rs.getDouble("valor_mensal"));
                c.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                c.setDataFim(rs.getDate("data_fim").toLocalDate());
                c.setAtivo(rs.getBoolean("ativo"));

                lista.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar contratos expirando: " + e.getMessage());
        }
        return lista;
    }
}
