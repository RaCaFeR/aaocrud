package me.crud.database;

import java.sql.*;
public class DatabaseManager {

    private DatabaseManager instance;
    private Connection connection;

    public void connect() throws SQLException, ClassNotFoundException {
        System.out.println("Trying to connect to the database");
        Class.forName("org.mariadb.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/crud_prods", "root", "mysql");
        System.out.println("Successfully connected to the database");
    }

    public void close() throws SQLException {
        System.out.println("Closing database connection");
        connection.close();
        System.out.println("Successfully closed the database");
    }
    
    public DatabaseManager getInstance() {
        return this.instance;
    }
    
    public void setInstance(DatabaseManager instance) {
        this.instance = instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isClosed() {
        if (this.connection == null) return true;

        try {
            return this.connection.isClosed();
        }
        catch (Exception e) {
            return true;
        }
    }

    public void setupDatabase() throws Exception {
        PreparedStatement statement = connection.prepareStatement("""
        CREATE TABLE IF NOT EXISTS products(
            id INTEGER,
            name VARCHAR(100) NOT NULL,
            price DECIMAL(10, 2) NOT NULL,
            quantity INTEGER,
            
            CONSTRAINT pk_id_product PRIMARY KEY (id)
        );""");
        statement.execute();
    }
}
