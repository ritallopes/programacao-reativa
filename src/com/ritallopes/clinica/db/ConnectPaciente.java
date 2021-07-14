package com.ritallopes.clinica.db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ritallopes.entities.Paciente;

public class ConnectPaciente extends Connect{
	public ConnectPaciente() {
		this.conectar();
		this.createTable();
		this.desconectar();
	}
	 public Boolean createTable(){
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                String sql = "CREATE TABLE IF NOT EXISTS PACIENTE" +
	                        "(CPF TEXT PRIMARY KEY NOT NULL," +
	                        " NOME          TEXT    NOT NULL, " +
	                        " TELEFONE          TEXT     NOT NULL,"
	                        + "CONVENIO TEXT,"
	                        + "DATACADASTRO TEXT);";


	                statement.executeUpdate(sql);
	                statement.close();
	                return true;
	            }else{
	            	this.conectar();
	                this.createTable();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao criar tabela paciente");
	            return false;
	        }

	        return null;
	    }
	 
	 public Boolean createPaciente(Paciente paciente){
	        try {
	            if (!connection.isClosed()){
	                statement = connection.createStatement();
	                String sql ="INSERT INTO PACIENTE ( CPF, NOME,TELEFONE, CONVENIO, DATACADASTRO) " +
	                        "VALUES (\""+paciente.getCpf()+"\",\""+paciente.getNome()+"\",\""+paciente.getTelefone()+"\",\""+paciente.getConvenio()+"\",\""+paciente.getDataCadastro()+"\");";
	                statement.executeUpdate(sql);
	                statement.close();
	                return true;
	            }else{
	                conectar();
	                createTable();
	                createPaciente(paciente);
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao cadastrar");
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	 
	 public ArrayList<Paciente> listAllPaciente(){
	        ArrayList<Paciente> pacientes = null; 
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                connection.setAutoCommit(false);
	                statement = connection.createStatement();

	                ResultSet rs = statement.executeQuery( "SELECT * FROM PACIENTE;" );


	                pacientes = new ArrayList<>();

	                while ( rs.next() ) {

	                    Paciente paciente = null;
	                    String  cpf = rs.getString("cpf");
	                    String nome  = rs.getString("nome");
	                    String  telefone = rs.getString("telefone");
	                    String convenio  = rs.getString("convenio");  
	                    String dataCadastro = rs.getString("datacadastro");

	                    paciente = new Paciente(cpf, nome, telefone, convenio, dataCadastro);

	                    pacientes.add(paciente);
	                }
	                rs.close();
	                statement.close();

	            }else{
	                
	                return listAllPaciente();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao listar");
	            e.printStackTrace();

	        }
	        return pacientes;
	    }
	 
	 public Paciente selectPaciente(String cpf){
	        Paciente paciente = null; 
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                connection.setAutoCommit(false);
	                statement = connection.createStatement();

	                ResultSet rs = statement.executeQuery( "SELECT * FROM PACIENTE WHERE CPF="+cpf+";" );



	                while ( rs.next() ) {
	                    String  cpf2 = rs.getString("cpf");
	                    String nome  = rs.getString("nome");
	                    String  telefone = rs.getString("telefone");
	                    String convenio  = rs.getString("convenio");  
	                    String dataCadastro = rs.getString("datacadastro");

	                    paciente = new Paciente(cpf2, nome, telefone, convenio, dataCadastro);
	                }
	                rs.close();
	                statement.close();

	            }else{
	                
	                return selectPaciente(cpf);
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao listar");
	            e.printStackTrace();

	        }
	        return paciente;
	    }

}
