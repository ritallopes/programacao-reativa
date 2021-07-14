package com.ritallopes.clinica.db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ritallopes.entity.Consulta;
import com.ritallopes.entity.Medico;
import com.ritallopes.entity.Paciente;

public class ConnectConsulta extends Connect{
	public ConnectConsulta() {
		this.conectar();
		this.createTable();
		this.desconectar();
	}
	
	 public Boolean createTable(){
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                String sql = "CREATE TABLE IF NOT EXISTS CONSULTA" +
	                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
	                        + "CPFPACIENTE TEXT NOT NULL," +
	                        " CPFMEDICO TEXT NOT NULL, " +
	                        " INICIO TEXT  NOT NULL,"
	                        + "FIM  TEXT NOT NULL,"
	                        + "CONCLUIDA TEXT);";
	                statement.executeUpdate(sql);
	                statement.close();
	                return true;
	            }else{
	            	this.conectar();
	                this.createTable();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao criar tabela Consulta");
	            return false;
	        }

	        return null;
	    }
	 
	 public Boolean createConsulta(Consulta consulta){
	        try {
	            if (!connection.isClosed()){
	                statement = connection.createStatement();
	                String sql ="INSERT INTO CONSULTA (CPFPACIENTE, CPFMEDICO,INICIO,FIM,CONCLUIDA) " +
	                        "VALUES (\""+consulta.getPaciente().getCpf()+"\",\""+consulta.getMedico().getCpf()+"\",\""+consulta.getInicio()+"\",\""+consulta.getFim()+"\",\""+consulta.getConcluida().toString()+"\");";
	                statement.executeUpdate(sql);
	                statement.close();
	               
	                
	                
	                return true;
	            }else{
	                conectar();
	                createTable();
	                createConsulta(consulta);
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao cadastrar");
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	 
	 public ArrayList<Consulta> listAllConsulta(){
	        ArrayList<Consulta> consultas = null; 
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                connection.setAutoCommit(false);
	                statement = connection.createStatement();

	                ResultSet rs = statement.executeQuery( "SELECT * FROM CONSULTA;" );


	                consultas = new ArrayList<>();

	                while ( rs.next() ) {

	                    Consulta consulta = null;
	                    String id = rs.getString("id");
	                    String  cpfPaciente = rs.getString("cpfpaciente");
	                    String  cpfMedico = rs.getString("cpfMedico");
	                    String inicio  = rs.getString("inicio");
	                    String  fim = rs.getString("fim");
	                    String concluida  = rs.getString("concluida");  
	                    
	                    
	                    ConnectPaciente p = new ConnectPaciente();
	            		p.conectar();
	            		Paciente paciente = p.selectPaciente(cpfPaciente);
	            		p.desconectar();
	            		
	            		
	            		ConnectMedico m = new ConnectMedico();
	            		m.conectar();
	            		Medico medico = m.selectMedico(cpfMedico);
	            		p.desconectar();
	            		
	            		
	                    consulta = new Consulta(id,paciente, medico, inicio, fim, Boolean.valueOf(concluida));

	                    consultas.add(consulta);
	                }
	                rs.close();
	                statement.close();

	            }else{
	                conectar();
	                return listAllConsulta();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao listar");
	            e.printStackTrace();

	        }
	        return consultas;
	    }
	 
	 public ArrayList<Consulta> listAllConsultaMedico(String cpf){
	        ArrayList<Consulta> consultas = null; 
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                connection.setAutoCommit(false);
	                statement = connection.createStatement();

	                ResultSet rs = statement.executeQuery( "SELECT * FROM CONSULTA WHERE CPFMEDICO="+cpf+";");


	                consultas = new ArrayList<>();

	                while ( rs.next() ) {

	                    Consulta consulta = null;
	                    String id = rs.getString("id");
	                    String  cpfPaciente = rs.getString("cpfpaciente");
	                    String  cpfMedico = rs.getString("cpfMedico");
	                    String inicio  = rs.getString("inicio");
	                    String  fim = rs.getString("fim");
	                    String concluida  = rs.getString("concluida");  

	                    ConnectPaciente p = new ConnectPaciente();
	            		p.conectar();
	            		Paciente paciente = p.selectPaciente(cpfPaciente);
	            		p.desconectar();
	            		
	            		
	            		ConnectMedico m = new ConnectMedico();
	            		m.conectar();
	            		Medico medico = m.selectMedico(cpfMedico);
	            		p.desconectar();
	            	 		
	                    consulta = new Consulta(id, paciente, medico, inicio, fim, Boolean.valueOf(concluida));
	                    
	                    

	                    consultas.add(consulta);
	                }
	                rs.close();
	                statement.close();

	            }else{
	                
	                return listAllConsulta();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao listar");
	            e.printStackTrace();

	        }
	        return consultas;
	    }

}
