package com.online.menu.connection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class TestConnection implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(TestConnection.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1)) {
                System.out.println("Conexión exitosa a PostgreSQL.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}
