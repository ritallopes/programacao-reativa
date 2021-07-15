package com.ritallopes.clinica.repositories;

import java.util.List;

import com.ritallopes.entities.Paciente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;


public class PacienteRepository {
	private static PacienteRepository pacienteRepository;
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	
	public static PacienteRepository getInstance() {
		if(pacienteRepository == null) {
			pacienteRepository = new PacienteRepository();
		}
		return pacienteRepository;		
	}
	
	
	public Flux<Paciente> getAll() {
		return Flux.fromIterable(pacientes);
	}
	
	public void save(Paciente paciente) {
		pacientes.add(paciente);
	}	
	
	public Mono<Paciente> getByCpf(String cpf) {
		return Flux.fromIterable(pacientes).filter((paciente) -> paciente.getCpf().equals(cpf)).take(1).single();
	}
	public Mono<Boolean> deleteByCpf(String cpf) {
		return Mono.just(pacientes.remove(getByCpf(cpf)));
	}

}
