import java.util.Calendar;

import br.ufrn.imd.db.Connect;
import br.ufrn.imd.db.ConnectConsulta;
import br.ufrn.imd.db.ConnectMedico;
import br.ufrn.imd.entities.Medico;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;



public class Main {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2021, 07, 10, 21, 10, 00);
		System.out.println(c.getTime());
		
		
		
		
	}

}
