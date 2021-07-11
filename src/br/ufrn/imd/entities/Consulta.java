package br.ufrn.imd.entities;

import java.util.Date;

import br.ufrn.imd.db.ConnectPaciente;
import br.ufrn.imd.db.ConnectMedico;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
public class Consulta {
	
	
	private Paciente paciente;
	private Medico medico;
	private String inicio;
	private String fim;
	private Boolean concluida;

}
