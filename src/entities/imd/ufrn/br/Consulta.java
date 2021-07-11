package entities.imd.ufrn.br;

import java.util.Date;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
public class Consulta {
	
	private Paciente paciente;
	private Medico medico;
	private Date inicio;
	private Date fim;
	private Boolean concluida;

}
