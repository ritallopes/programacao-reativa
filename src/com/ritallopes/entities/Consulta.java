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
	
	
	public String toString() {
		return "ID: "+this.id+", Inicio: "+this.inicio+", Fim: "+this.fim+" Paciente:\n\t"+this.paciente.toString()+"\n\t M�dico:"+this.medico.toString();
	}

}
