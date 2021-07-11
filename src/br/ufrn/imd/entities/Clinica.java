/**
 * 
 */
package br.ufrn.imd.entities;

import java.util.Date;
import java.util.List;

/**
 * @author Rita Lopes
 *
 */
import lombok.*;
@Data
@Builder
public class Clinica {
	@NonNull
	private String nome;
	private List<Funcionario> funcionarios;

}
