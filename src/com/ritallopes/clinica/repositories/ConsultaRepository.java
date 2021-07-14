package com.ritallopes.clinica.repositories;

import java.util.List;

import com.ritallopes.entities.Consulta;

import java.util.ArrayList;
import java.util.Collections;


public class ConsultaRepository {
	private static ConsultaRepository consultaRepository;
	private List<Consulta> consultas = new ArrayList<>();
	
	
	public static ConsultaRepository getInstance() {
		if(consultaRepository == null) {
			consultaRepository = new ConsultaRepository();
		}
		return consultaRepository;		
	}
	
	
	public List<Consulta> getAll() {
		return Collections.unmodifiableList(consultas);
	}
	
	public void save(Consulta consulta) {
		consultas.add(consulta);
	}	

}
