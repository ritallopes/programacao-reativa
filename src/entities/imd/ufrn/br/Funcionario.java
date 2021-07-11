/**
 * 
 */
package entities.imd.ufrn.br;

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
	private Date dataContratacao;
	
}
