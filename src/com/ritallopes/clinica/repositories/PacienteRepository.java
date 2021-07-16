package com.ritallopes.clinica.repositories;

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
	
	public Mono<Boolean> save(Paciente paciente) {
		return Mono.just(pacientes.add(paciente));
	}	
	
	public Mono<Paciente> getByCpf(String cpf) {
		return Flux.fromIterable(pacientes).filter((paciente) -> paciente.getCpf().equals(cpf)).take(1).single();
	}
	public Mono<Boolean> deleteByCpf(String cpf1) {
		return Mono.just(pacientes.remove(getByCpf(cpf1).block()));
	}

}
