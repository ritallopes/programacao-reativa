package com.ritallopes.clinica.services;
import java.util.Calendar;
import java.util.Scanner;

import com.ritallopes.clinica.repositories.MedicoRepository;
import com.ritallopes.clinica.services.IServico;
import com.ritallopes.entities.Medico;

import lombok.ToString;
import reactor.core.publisher.Mono;

@ToString
public class MedicoServico implements IServico {
	MedicoRepository medicoRepository = MedicoRepository.getInstance();
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("CPF: ");
		String cpf = scanner.next();
		System.out.print("Nome: ");
		String nome = scanner.next();
		System.out.print("Especialidade: ");
		String especialidade = scanner.next();
		System.out.print("CRM: ");
		String crm = scanner.next();
		System.out.print("Contato: ");
		String telefone  = scanner.next();
		
		medicoRepository.save(new Medico(cpf, nome, telefone, Calendar.getInstance().getTime().toString(), crm, especialidade, null));
		
		
		medicoRepository.getByCpf(cpf).subscribe(m -> {
			System.out.println(m.toString());
		});
		
	}

	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("CPF: ");
		String cpf = scanner.next();
		medicoRepository.deleteByCpf(cpf);
	}

	public void listAll() {
		medicoRepository.getAll().subscribe(c-> {
			System.out.println(c.toString());
		});		
	}

}
