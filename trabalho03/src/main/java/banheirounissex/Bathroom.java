package banheirounissex;

import java.util.ArrayList;
import java.util.List;

public class Bathroom {
    	
	private int capacity;
	private List<Person> peopleInBathroom;

	private char currentGender = 'N';


	public Bathroom(int capacity) {
		this.capacity = capacity;
		peopleInBathroom = new ArrayList<>();
	}


	public synchronized void enter(Person person) {
		System.out.println("Quer entrar no banheiro. gênero: " + person.getGender() + " id: " + person.getId());

		while (peopleInBathroom.size() == capacity) {
			System.out.println("Banheiro cheio! Ids:");
			for (Person per : peopleInBathroom) {
				System.out.print(" " + per.getId() + "  gênero: " + person.getGender());
			}
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

		while (currentGender != person.getGender() && currentGender != 'N') {
			System.out.println("Não posso entrar, gen: " + person.getGender() + " genero atual: " + currentGender);
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

		peopleInBathroom.add(person);
		if(currentGender == 'N') {
			currentGender = person.getGender();
		}
		System.out.println("Começou a usar o banheiro. gênero: " + person.getGender() + " id: " + person.getId()
				+ ". Qtd no banheiro: " + peopleInBathroom.size());
		notify();
	}

	public synchronized void leave(Person person) {
		System.out.println("Tentando sair do banheiro. id " + person.getId());
		Boolean personRemoved = peopleInBathroom.remove(person);
        if(Boolean.TRUE.equals(personRemoved)){
            System.out.println("Saiu do banheiro " + person.getId() 
				+ " do gênero " + person.getGender() 
				+ ". Qtd no banheiro: " + peopleInBathroom.size());
        }
		if(peopleInBathroom.isEmpty()) {
			currentGender = 'N';
		}
		notify();
	}
}
