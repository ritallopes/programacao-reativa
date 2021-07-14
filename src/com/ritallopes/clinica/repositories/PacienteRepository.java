package com.ritallopes.clinica.repositories;

import java.util.List;

import com.ritallopes.entities.Paciente;

import java.util.ArrayList;
import java.util.Collections;


public class PacienteRepository {
	private static PacienteRepository pacienteRepository;
	private List<Paciente> pacientes = new ArrayList<>();
	
	
	public static PacienteRepository getInstance() {
		if(pacienteRepository == null) {
			pacienteRepository = new PacienteRepository();
		}
		return pacienteRepository;		
	}
	
	
	public List getAll() {
		return Collections.unmodifiableList(pacientes);
	}
	
	public void save(Paciente paciente) {
		pacientes.add(paciente);
	}	

}
