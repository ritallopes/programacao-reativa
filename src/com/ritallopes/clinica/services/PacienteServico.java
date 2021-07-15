package com.ritallopes.clinica.services;

import java.util.Calendar;
import java.util.Scanner;

import com.ritallopes.clinica.repositories.PacienteRepository;
import com.ritallopes.entities.Paciente;

public class PacienteServico implements IServico {
	PacienteRepository pacienteRepository = PacienteRepository.getInstance();
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("CPF: ");
		String cpf = scanner.next();
		System.out.print("Nome: ");
		String nome = scanner.next();
		System.out.print("Convenio: ");
		String convenio = scanner.next();
		System.out.print("Contato: ");
		String telefone  = scanner.next();
		
		pacienteRepository.save(new Paciente(cpf, nome, telefone, convenio, Calendar.getInstance().getTime().toString()));
		
		pacienteRepository.getByCpf(cpf).subscribe(m -> {
			System.out.println(m.toString());
		});
		
	}

	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("CPF: ");
		String cpf = scanner.next();
		pacienteRepository.deleteByCpf(cpf);

	}


	public void listAll() {
		pacienteRepository.getAll().subscribe(c-> {
			System.out.println(c.toString());
		});
		
	}

}
