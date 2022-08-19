package tasks.classes;

import java.util.Scanner;

import tasks.dao.DaoTasks;
import tasks.dao.DaoUsers;
import tasks.entity.Tasks;
import tasks.entity.Users;
import tasks.utils.TasksConnect;

public class MainApplication {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		if (TasksConnect.connect() != null) {
			System.out.println("Conectado");
		} else {
			System.out.println("Não foi possivel se conectar");
		}
		DaoUsers du = new DaoUsers();
		DaoTasks dt = new DaoTasks();
	
		while(true) {
			System.out.println("Ola! Você possui cadastro?(s/n)");
			String entry = keyboard.nextLine();
			if(entry.equals("s")) {
				System.out.println("Otimo, entre agora!");
				String email = keyboard.nextLine();
				System.out.println("O que deseja fazer!");
				System.out.println("Vê notas(a),Escrever notas(b),Sair(e)");
				while(true) {
					String verify = keyboard.nextLine();
					if(verify.equals("b")) {
						System.out.println("Nome da nota: ");
						String taskName = keyboard.nextLine();
						System.out.println("Descrição: ");
						String taskDescription = keyboard.nextLine();
						System.out.println("Seu numero de indentificação: ");
						int taskUserReference = keyboard.nextInt();
						Tasks task = new Tasks(taskName,taskDescription,taskUserReference);
						if(dt.create(task)) {
							System.out.println("Nota criada");
						};
						System.out.println("O que deseja fazer agora!");
						System.out.println("Vê notas(a),Escrever notas(b),Sair(e)");
					}if(verify.equals("a")) {
						System.out.println(dt.readAll(1));
						System.out.println("O que deseja fazer agora!");
						System.out.println("Vê notas(a),Escrever notas(b),Sair(e)");
						
					}
					if(verify.equals("e")) {
						break;
					}
					
	
				}
				System.out.println("Tchau!");
				keyboard.close();
				break;

			}
			else {
				System.out.println("Tchau!");
				keyboard.close();
				break;
			}
		}
	}

}
