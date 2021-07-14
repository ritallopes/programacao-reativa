/**
 * 
 */
package com.ritallopes.entity;

import lombok.*;

/**
 * @author Rita Lopes
 *
 */

@Data
@NoArgsConstructor
public class Paciente extends Pessoa {
	private String convenio;
	private String dataCadastro;
	public Paciente(String cpf, String nome, String telefone, String convenio, String dataCadastro) {
		super(nome, cpf, telefone);
		this.convenio = convenio;
		this.dataCadastro = dataCadastro;
	}
}
