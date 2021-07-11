/**
 * 
 */
package br.ufrn.imd.entities;

import java.util.Date;

import lombok.*;

/**
 * @author Rita Lopes
 *
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Funcionario extends Pessoa{
	private String dataContratacao;
	public Funcionario(String nome, String  cpf, String  telefone, String  dataContratacao) {
		super(nome, cpf, telefone);		
	}
	
}
