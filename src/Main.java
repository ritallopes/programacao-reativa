import java.util.ArrayList;

import br.ufrn.imd.db.Connect;
import br.ufrn.imd.db.ConnectMedico;
import br.ufrn.imd.entities.Medico;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;


@Slf4j
public class Main {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2021, 07, 10, 21, 10, 00);
		System.out.println(c.getTime());
		
		ConnectMedico co = new ConnectMedico();

		co.conectar();
		co.createMedico(new Medico( "353466","Davi", "483573485",  "21/05/2021", "3234523", "geriatra", null));
		co.createMedico(new Medico("35347", "Jose","483573485","21/05/2021","34234", "neurologista", null));

		for(Medico p:co.listAllMedico()) {
			System.out.println(p.toString());
		}
		co.desconectar();
		Medico m = new Medico();
		
		
	}

}
