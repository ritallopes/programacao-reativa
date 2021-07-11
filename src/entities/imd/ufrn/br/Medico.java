/**
 * 
 */
package entities.imd.ufrn.br;

import java.util.Date;
import java.util.List;

/**
 * @author Rita Lopes
 *
 */
import lombok.*;
@Data
@Builder
public class Medico extends Funcionario{
	private String crm;
	private String especialidade;
	private List<FilaEspera> filasMedico;
}
