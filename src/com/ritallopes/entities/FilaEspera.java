/**
 * 
 */
package com.ritallopes.entities;

import java.util.*;

/**
 * @author Rita Lopes
 *
 */
import lombok.*;
@Data
@Builder
@AllArgsConstructor
public class FilaEspera {
	private List<Consulta> consultas;
	private Date dia;
	
	public Boolean addConsulta(Consulta consulta) {
		try {
			//TODO verificar consultas existentes
			consultas.add(consulta);
			
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
