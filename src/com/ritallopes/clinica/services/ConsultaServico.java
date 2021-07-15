package com.ritallopes.clinica.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.ritallopes.clinica.repositories.ConsultaRepository;
import com.ritallopes.clinica.repositories.MedicoRepository;
import com.ritallopes.clinica.repositories.PacienteRepository;
import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;

import reactor.core.publisher.Mono;

import java.util.Scanner;

public class ConsultaServico implements IServico {
	ConsultaRepository consultaRepository = ConsultaRepository.getInstance();
	MedicoRepository medicoRepository = MedicoRepository.getInstance();
	PacienteRepository pacienteRepository = PacienteRepository.getInstance();
	

	public void add() {
		Scanner scanner = new Scanner(System.in);
		int c = 1;
		System.out.println("Qual médico?");

		for (Medico m : medicoRepository.getAll()) {
			System.out.println(c + " - " + m.toString());
			c++;
		}

		int index = scanner.nextInt();
		Medico medico = medicoRepository.getAll().get(index - 1);

		System.out.println("Qual paciente?");
		for (Paciente p : pacienteRepository.getAll()) {
			System.out.println(c + " - " + p.toString());
			c++;
		}

		index = scanner.nextInt();
		Paciente paciente = pacienteRepository.getAll().get(index - 1);
		System.out.print("Inicio em:");
		String inicio = scanner.next();
		System.out.print("Fim em:");
		String fim = scanner.next();
		
		consultaRepository.save(new Consulta(UUID.randomUUID().toString(), paciente, medico, inicio, fim, false));
		
	}
	
	
	public void delete() {

	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void listAll() {
		// TODO Auto-generated method stub

	}

	public void get() {
		System.out.print("Médico: ");
		Scanner scanner = new Scanner(System.in);
		String op = scanner.next();
		getByMedico(op);		
	}
	private void getByMedico(String cpf) {
		consultaRepository.get
	}

}
