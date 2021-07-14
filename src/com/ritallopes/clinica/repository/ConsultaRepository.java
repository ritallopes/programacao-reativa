package com.ritallopes.clinica.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.ritallopes.entity.Consulta;


public class ConsultaRepository {
	private static ConsultaRepository consultaRepository;
	private List<Consulta> consultas = new ArrayList<>();
	
	
	public static ConsultaRepository getInstance() {
		if(consultaRepository == null) {
			consultaRepository = new ConsultaRepository();
		}
		return consultaRepository;		
	}
	
	
	public List getAll() {
		return Collections.unmodifiableList(consultas);
	}
	
	public void save(Consulta consulta) {
		consultas.add(consulta);
	}	

}
