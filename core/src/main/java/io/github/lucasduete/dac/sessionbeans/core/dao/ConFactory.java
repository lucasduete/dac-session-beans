package io.github.lucasduete.dac.sessionbeans.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConFactory {
    private final String host;
    Properties props;

    public ConFactory(){
        this.host = "jdbc:postgresql://banco:5432/atividade-dac";
        props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(host, props);
    }
}
