package com.ritallopes.clinica.services;
import java.util.UUID;

import com.ritallopes.clinica.repositories.ConsultaRepository;
import com.ritallopes.clinica.repositories.MedicoRepository;
import com.ritallopes.clinica.repositories.PacienteRepository;
import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Scanner;

public class ConsultaServico implements IServico {
	ConsultaRepository consultaRepository = ConsultaRepository.getInstance();
	MedicoRepository medicoRepository = MedicoRepository.getInstance();
	PacienteRepository pacienteRepository = PacienteRepository.getInstance();
	

	public void add() {
		Scanner scanner = new Scanner(System.in);
		int c = 1;
		Consulta consulta = new Consulta();
		System.out.println("Digite o CPF do médico: ");	
		String cpfMedico = scanner.next();
		Medico medico;
		medicoRepository.getByCpf(cpfMedico).subscribe(m ->{
			consulta.setMedico(m);
		});
		System.out.println("Digite o CPF do paciente: ");
		String cpfPaciente= scanner.next();
		pacienteRepository.getByCpf(cpfPaciente).subscribe(p ->{
			consulta.setPaciente(p);
		});
		
		System.out.print("Inicio em:");
		String inicio = scanner.next();
		System.out.print("Fim em:");
		String fim = scanner.next();
		consulta.setInicio(inicio);
		consulta.setFim(fim);
		consulta.setConcluida(false);
		consulta.setId(UUID.randomUUID().toString());
		
		
		consultaRepository.save(consulta).subscribe();
		consultaRepository.getById(consulta.getId()).subscribe(co -> System.out.println(co.toString()));
		
	}
	
	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID: ");
		String id= scanner.next();
		consultaRepository.deleteById(id);
		scanner.close();
	}

	

	public void listAll() {
		consultaRepository.getAll().subscribe(c-> {
			System.out.println(c.toString());
		});
	}
	public void getByMedico() {
		System.out.print("Médico: ");
		Scanner scanner = new Scanner(System.in);
		String op = scanner.next();
		getByMedico(op).subscribe(c -> {
			System.out.println(c.toString());
		});	
	}
	private Flux<Consulta> getByMedico(String cpf) {	
		return consultaRepository.getByMedico(medicoRepository.getByCpf(cpf).block());
	}

}
