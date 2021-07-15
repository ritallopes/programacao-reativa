import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ritallopes.clinica.services.ConsultaServico;
import com.ritallopes.clinica.services.MedicoServico;
import com.ritallopes.clinica.services.PacienteServico;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import java.util.Scanner;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		ConsultaServico cs = new ConsultaServico();
		PacienteServico ps = new PacienteServico();
		MedicoServico ms = new MedicoServico();
		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.println("==================\nGerenciar...");
			System.out.println("1 - Consultas");
			System.out.println("2 - Pacientes");
			System.out.println("3 - Médicos");
			System.out.println("0 - sair");
			int ent = 0;
			ent = scanner.nextInt();
			System.out.println("========================");
			switch (ent) {
			case 1: {
				System.out.println("Consultas");
				printSubmenu();
				int submenu = scanner.nextInt();
				switch (submenu) {
				case 1:
					cs.add();
					break;
				case 2:
					cs.delete();
					break;
				case 3:
					cs.listAll();
					break;
				default:
					break;
				}
				break;

			}
			case 2: {
				System.out.println("Pacientes");
				printSubmenu();
				int submenu = scanner.nextInt();
				switch (submenu) {
				case 1:
					ps.add();
					break;
				case 2:
					ps.delete();
					break;
				case 3:
					ps.listAll();
					break;
				default:
					break;
				}
				break;
			}
			case 3: {
				System.out.println("Médicos");
				printSubmenu();
				int submenu = scanner.nextInt();
				switch (submenu) {
				case 1:
					ms.add();
					break;
				case 2:
					ms.delete();
					break;
				case 3:
					ms.listAll();
					break;

				default:
					break;
				}
				break;
			}
			default:
				repeat = false;
				break;
			}
		}
		

	}

	public static void printSubmenu() {
		System.out.println("1 - adicionar");
		System.out.println("2 - remover");
		System.out.println("3 - listar");

	}
}
