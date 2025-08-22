package br.edu.fatecpg.crudsimpes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class Banco {

    private static final String url = "jdbc:postgresql://localhost:5432/db_clinica";
    private static final String user = "postgres";
    private static final String password = "kalebemmj";

    //conectando ao banco de dados

    public static Connection conectar() throws SQLException{

        try{
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            throw new SQLException();
        }

    }
}
