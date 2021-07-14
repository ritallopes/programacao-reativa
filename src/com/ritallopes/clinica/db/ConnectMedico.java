package com.ritallopes.clinica.db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ritallopes.clinica.db.ConnectConsulta;
import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;


public class ConnectMedico extends Connect{
	public ConnectMedico() {
		this.conectar();
		this.createTable();
		this.desconectar();
	}
	 public Boolean createTable(){
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                String sql = "CREATE TABLE IF NOT EXISTS MEDICO" +
	                        "(CPF TEXT PRIMARY KEY NOT NULL," +
	                        " NOME          TEXT    NOT NULL, " +
	                        " TELEFONE          TEXT     NOT NULL,"
	                        + "DATACONTRATACAO TEXT,"
	                        + "CRM TEXT,"
	                        + "ESPECIALIDADE TEXT);";

	                statement.executeUpdate(sql);
	                statement.close();
	                return true;
	            }else{
	            	this.conectar();
	                this.createTable();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao criar tabela Medico");
	            return false;
	        }

	        return null;
	    }
	 
	 public Boolean createMedico(Medico medico){
	        try {
	            if (!connection.isClosed()){
	                statement = connection.createStatement();
	                String sql ="INSERT INTO MEDICO ( CPF, NOME,TELEFONE, DATACONTRATACAO, CRM, ESPECIALIDADE) " +
	                        "VALUES (\""+medico.getCpf()+"\",\""+medico.getNome()+"\",\""+medico.getTelefone()+"\",\""+medico.getDataContratacao()+"\",\""+medico.getCrm()+"\",\""+medico.getEspecialidade()+"\");";
	                statement.executeUpdate(sql);
	                statement.close();
	                return true;
	            }else{
	                conectar();
	                createTable();
	                createMedico(medico);
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao cadastrar");
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	 
	 public ArrayList<Medico> listAllMedico(){
	        ArrayList<Medico> medicos = null; 
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                connection.setAutoCommit(false);
	                statement = connection.createStatement();

	                ResultSet rs = statement.executeQuery( "SELECT * FROM MEDICO;" );


	                medicos = new ArrayList<>();

	                while ( rs.next() ) {

	                    Medico medico = null;
	                    String  cpf = rs.getString("cpf");
	                    String nome  = rs.getString("nome");
	                    String  telefone = rs.getString("telefone");
	                    String dataContratacao  = rs.getString("datacontratacao");  
	                    String crm = rs.getString("crm");
	                    String especialidade = rs.getString("especialidade");
	                    
	                    ConnectConsulta cc = new ConnectConsulta();
	                    ArrayList<Consulta> consultas = cc.listAllConsultaMedico(cpf);


	                    medico = new Medico(cpf, nome, telefone,dataContratacao, crm, especialidade, consultas);

	                    medicos.add(medico);
	                }
	                rs.close();
	                statement.close();

	            }else{
	                
	                return listAllMedico();
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao listar");
	            e.printStackTrace();

	        }
	        return medicos;
	    }
	 
	 public Medico selectMedico(String cpf){
	        Medico medico = null; 
	        try {
	            if (!connection.isClosed()){

	                statement = connection.createStatement();
	                connection.setAutoCommit(false);
	                statement = connection.createStatement();

	                ResultSet rs = statement.executeQuery( "SELECT * FROM MEDICO WHERE CPF="+cpf+";" );




	                while ( rs.next() ) {

	                    String  cpf2 = rs.getString("cpf");
	                    String nome  = rs.getString("nome");
	                    String  telefone = rs.getString("telefone");
	                    String dataContratacao  = rs.getString("datacontratacao");  
	                    String crm = rs.getString("crm");
	                    String especialidade = rs.getString("especialidade");

	                    ConnectConsulta cc = new ConnectConsulta();
	                    ArrayList<Consulta> consultas = cc.listAllConsultaMedico(cpf);

	                    medico = new Medico(cpf, nome, telefone,dataContratacao, crm, especialidade, consultas);

	                }
	                rs.close();
	                statement.close();

	            }else{
	                
	                return selectMedico(cpf);
	            }
	        }catch (SQLException e){
	            System.out.println("Erro ao listar");
	            e.printStackTrace();

	        }
	        return medico;
	    }


}
