package com.ritallopes.clinica.services;

import java.util.ArrayList;
import java.util.UUID;

import com.ritallopes.clinica.repositories.ConsultaRepository;
import com.ritallopes.clinica.repositories.MedicoRepository;
import com.ritallopes.clinica.repositories.PacienteRepository;
import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;

import java.util.Scanner;


public class ConsultaServico implements IServico {

	public void add() {
		Scanner scannesr = new Scanner(System.in);
		ArrayList<Medico> medicos =  new ArrayList<>();
		medicos.addAll(MedicoRepository.getInstance().getAll());
		ArrayList<Paciente> pacientes = new ArrayList<>();
		pacientes.addAll(PacienteRepository.getInstance().getAll());
		
		int c = 1;
		System.out.println("Qual médico?");
		
		
		for (Medico m : medicos) {
			System.out.println(c + " - " + m.toString());
			c++;
		}
		
		
		int index = scannesr.nextInt();
		Medico medico = medicos.get(index - 1);
		
		
		System.out.println("Qual paciente?");
		for (Paciente p : pacientes) {
			System.out.println(c + " - " + p.toString());
			c++;
		}
		
		
		index = scannesr.nextInt();
		Paciente paciente = pacientes.get(index - 1);
		System.out.print("Inicio em:");
		String inicio = scannesr.nextLine();
		System.out.print("Fim em:");
		String fim = scannesr.nextLine();
		Consulta consulta = new Consulta(UUID.randomUUID().toString(), paciente, medico, inicio, fim,
				false);
		ConsultaRepository.getInstance().save(consulta);
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}
