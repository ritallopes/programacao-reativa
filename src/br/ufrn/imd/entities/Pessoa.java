package br.ufrn.imd.entities;

import java.util.List;

import lombok.*;
import lombok.experimental.NonFinal;

@Getter
@Setter
@NonFinal
@NoArgsConstructor
public class Pessoa {
	
	protected String nome;
	
	protected String cpf;
	
	protected String telefone;
	
	public Pessoa(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

}
