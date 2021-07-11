import java.util.Calendar;
import java.util.Date;

import lombok.extern.java.Log;

@Log
public class Main {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2021, 07, 10, 21, 10, 00);
		System.out.println(c.getTime());
		
		
	}

}
