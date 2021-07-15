package com.ritallopes.clinica.repositories;

import java.util.List;

import com.ritallopes.entities.Paciente;

import java.util.ArrayList;
import java.util.Collections;


public class PacienteRepository {
	private static PacienteRepository pacienteRepository;
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	
	
	public static PacienteRepository getInstance() {
		if(pacienteRepository == null) {
			pacienteRepository = new PacienteRepository();
		}
		return pacienteRepository;		
	}
	
	
	public ArrayList<Paciente> getAll() {
		return pacientes;
	}
	
	public void save(Paciente paciente) {
		pacientes.add(paciente);
	}	

}
