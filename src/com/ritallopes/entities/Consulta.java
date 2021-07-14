package com.ritallopes.entities;
import io.reactivex.annotations.NonNull;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
	
	@NonNull
	private String id;
	private Paciente paciente;
	private Medico medico;
	private String inicio;
	private String fim;
	private Boolean concluida;

}
