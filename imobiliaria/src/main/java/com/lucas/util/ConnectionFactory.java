package com.diogo.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = ConnectionFactory.class.getResourceAsStream("/application.properties")) {
            if (in == null) throw new RuntimeException("application.properties não encontrado em resources/");
            props.load(in);
            // Driver é carregado automaticamente no Java moderno, mas não custa:
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException("Falha ao carregar configuração do banco", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        // permite sobrescrever por variáveis de ambiente em produção/CI
        String url  = System.getenv().getOrDefault("DB_URL",      props.getProperty("db.url"));
        String user = System.getenv().getOrDefault("DB_USER",     props.getProperty("db.user"));
        String pass = System.getenv().getOrDefault("DB_PASSWORD", props.getProperty("db.password"));
        return DriverManager.getConnection(url, user, pass);
    }
}