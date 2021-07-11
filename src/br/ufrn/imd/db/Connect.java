package br.ufrn.imd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rita Lopes
 */
public class Connect {
	//Variaveis com padrão default para que as classes filhas possam herdar as variaveis de conexão
    Connection connection = null;
    Statement statement = null;

    public Boolean conectar() {
        try {
            // arquivo do banco de dados
            String url = "jdbc:sqlite:src/br/ufrn/imd/db/data.db";
            // create a connection to the database
            connection = DriverManager.getConnection(url);
            System.out.println("Conectado ao banco de dados");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Conexão não foi estabelecida corretamente");

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar o banco");
            }
            return false;
        }
    }

    public Boolean desconectar() {
        try {
        	if(connection == null) {
        		return true;
        	}
            if (!connection.isClosed()){
                connection.close();
            }
            System.out.println("Desconectado ao banco de dados");
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao fechar banco");
            return false;
        }

    }
}