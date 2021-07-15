package com.ritallopes.clinica.repositories;

import java.util.List;

import com.ritallopes.entities.Medico;

import java.util.ArrayList;
import java.util.Collections;


public class MedicoRepository {
	private static MedicoRepository medicoRepository;
	private ArrayList<Medico> medicos = new ArrayList<>();
	
	
	public static MedicoRepository getInstance() {
		if(medicoRepository == null) {
			medicoRepository = new MedicoRepository();
		}
		return medicoRepository;		
	}
	
	
	public ArrayList<Medico> getAll() {
		return medicos;
	}
	
	public void save(Medico medico) {
		medicos.add(medico);
	}	

}
