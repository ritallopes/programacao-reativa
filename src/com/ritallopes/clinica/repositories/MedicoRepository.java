package com.ritallopes.clinica.repositories;


import com.ritallopes.entities.Medico;

import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Getter
public class MedicoRepository {
	private static MedicoRepository medicoRepository;
	private ArrayList<Medico> medicos = new ArrayList<>();
	
	
	public static MedicoRepository getInstance() {
		if(medicoRepository == null) {
			medicoRepository = new MedicoRepository();
		}
		return medicoRepository;		
	}
	
	
	public Flux<Medico> getAll() {
		return Flux.fromIterable(medicos);
	}
	
	public void save(Medico medico) {
		medicos.add(medico);
	}


	public Mono<Medico> getByCpf(String cpf) {
		return Flux.fromIterable(medicos).filter((medico) -> medico.getCpf().equals(cpf)).take(1).single();
	}
	public Flux<Medico> getByEspecialidade(String especialidade) {
		return Flux.fromIterable(medicos).filter((medico) -> medico.getEspecialidade().equals(especialidade));
	}
	public Mono<Boolean> deleteByCpf(String cpf) {
		return Mono.just(medicos.remove(getByCpf(cpf)));
	}
	
}
