package entities.imd.ufrn.br;

import java.util.List;

import lombok.*;
import lombok.experimental.NonFinal;


@Data
@NonFinal
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Pessoa {
	@NonNull
	protected String nome;
	@NonNull
	protected String cpf;
	@NonNull
	protected String telefone;
	
	protected String email;
	protected String endereco;
	

}
