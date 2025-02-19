package Banco.de.dados.com.br.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    
    private static final String URL = "jdbc:mysql://localhost:3306/dbtarefa";
    private static final String USUARIO = "LPOO";
    private static final String SENHA = "south";

    public static Connection obterConexao() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
    
