import java.util.Calendar;

import com.ritallopes.clinica.db.Connect;
import com.ritallopes.clinica.db.ConnectConsulta;
import com.ritallopes.clinica.db.ConnectMedico;
import com.ritallopes.entity.Medico;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;



public class Main {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2021, 07, 10, 21, 10, 00);
		System.out.println(c.getTime());
		
		
		
		
	}

}
