package com.diogo.dao;

import com.diogo.model.Imovel;
import com.diogo.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {

    public void salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel (tipo, endereco, cidade, estado, cep, quartos, banheiros, area_m2, valor_aluguel_sugerido, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, imovel.getTipo());
            stmt.setString(2, imovel.getEndereco());
            stmt.setString(3, imovel.getCidade());
            stmt.setString(4, imovel.getEstado());
            stmt.setString(5, imovel.getCep());
            stmt.setInt(6, imovel.getQuartos());
            stmt.setInt(7, imovel.getBanheiros());
            stmt.setDouble(8, imovel.getAreaM2());
            stmt.setDouble(9, imovel.getValorAluguelSugerido());
            stmt.setString(10, imovel.getStatus());

            stmt.executeUpdate();
            System.out.println("Imóvel cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar imóvel: " + e.getMessage());
        }
    }

    public List<Imovel> listarDisponiveis() {
        List<Imovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM imovel WHERE status = 'DISPONIVEL'";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setIdImovel(rs.getInt("id_imovel"));
                imovel.setTipo(rs.getString("tipo"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getString("estado"));
                imovel.setCep(rs.getString("cep"));
                imovel.setQuartos(rs.getInt("quartos"));
                imovel.setBanheiros(rs.getInt("banheiros"));
                imovel.setAreaM2(rs.getDouble("area_m2"));
                imovel.setValorAluguelSugerido(rs.getDouble("valor_aluguel_sugerido"));
                imovel.setStatus(rs.getString("status"));

                lista.add(imovel);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar imóveis: " + e.getMessage());
        }
        return lista;
    }
}