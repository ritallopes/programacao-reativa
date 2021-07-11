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

@Data
@Builder
public class Paciente extends Pessoa {
	private String convenio;
	private Date dataCadastro;
}
