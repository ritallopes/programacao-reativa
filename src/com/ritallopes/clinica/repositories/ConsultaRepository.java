package com.ritallopes.clinica.repositories;

import java.util.ArrayList;

import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public class ConsultaRepository {
	private static ConsultaRepository consultaRepository;
	private ArrayList<Consulta> consultas = new ArrayList<>();
	
	
	public static ConsultaRepository getInstance() {
		if(consultaRepository == null) {
			consultaRepository = new ConsultaRepository();
		}
		return consultaRepository;		
	}
	
	
	public ArrayList<Consulta> getAll() {
		return consultas;
	}
	
	public void save(Consulta consulta) {
		consultas.add(consulta);
	}
	
	public Mono<Consulta> getById(String id){
		return Flux.fromIterable(consultas).filter((consulta)->(consulta.getId() == id)).single();
	}
	public Flux<Consulta> getByMedico(Medico medico){
		return Flux.fromIterable(consultas).filter((consulta)->(consulta.getMedico().getCpf() == medico.getCpf()));
	}
	public Flux<Consulta> getByPaciente(Paciente paciente){
		return Flux.fromIterable(consultas).filter((consulta)->(consulta.getPaciente().equals(paciente)));
	}
	public Mono<Boolean> deleteByMedico(Medico medico){
		return getByMedico(medico).collectList().map((consultaL) -> (consultas.remove(consultaL.get(0))));
	}

}
