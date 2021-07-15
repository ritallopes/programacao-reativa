import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ritallopes.clinica.db.Connect;
import com.ritallopes.clinica.db.ConnectConsulta;
import com.ritallopes.clinica.db.ConnectMedico;
import com.ritallopes.clinica.repositories.ConsultaRepository;
import com.ritallopes.clinica.repositories.MedicoRepository;
import com.ritallopes.clinica.repositories.PacienteRepository;
import com.ritallopes.clinica.services.ConsultaServico;
import com.ritallopes.clinica.services.MedicoServico;
import com.ritallopes.clinica.services.PacienteServico;
import com.ritallopes.entities.Consulta;
import com.ritallopes.entities.Medico;
import com.ritallopes.entities.Paciente;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import java.util.Scanner;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {

		boolean repeat = true;
		boolean repeatSubmenu = true;
		Scanner scanner = new Scanner(System.in);
		int ent = 0;
		int submenu = 0;
	
		
		while (repeat) {
			System.out.println("Gerenciar...");
			System.out.println("1 - Consultas");
			System.out.println("2 - Pacientes");
			System.out.println("3 - Médicos");
			System.out.println("0 - sair");
			ent = scanner.nextInt();
			System.out.println("========================");
			switch (ent) {
			case 1: {
				while (repeatSubmenu) {
					printSubmenu();
					submenu = scanner.nextInt();
					ConsultaServico cs = new ConsultaServico();								
					switch (submenu) {
					case 1:
						cs.add();
						break;
					case 2:
						cs.delete();
						break;
					case 3:
						cs.update();
						break;
					case 4:
						cs.listAll();
						break;

					default:
						repeatSubmenu = false;
						break;
					}
				}

			}
			case 2: {
				while (repeatSubmenu) {
					printSubmenu();
					submenu = scanner.nextInt();
					PacienteServico ps = new PacienteServico();								
					switch (submenu) {
					case 1:
						ps.add();
						break;
					case 2:
						ps.delete();
						break;
					case 3:
						ps.update();
						break;
					case 4:
						ps.listAll();
						break;
					default:
						repeatSubmenu = false;
						break;
					}
				}

			}
			case 3: {
				while (repeatSubmenu) {
					printSubmenu();
					submenu = scanner.nextInt();
					MedicoServico ms = new MedicoServico();								
					switch (submenu) {
					case 1:
						ms.add();
						break;
					case 2:
						ms.delete();
						break;
					case 3:
						ms.update();
						break;
					case 4:
						ms.listAll();
						break;

					default:
						repeatSubmenu = false;
						break;
					}
				}

			}
			default:
				repeat = false;
			}
		}

	}

	public static void printSubmenu() {
		System.out.println("1 - adicionar");
		System.out.println("2 - remover");
		System.out.println("3 - atualizar");
		System.out.println("4 - listar");
		System.out.println("0 - voltar");
	}
}
