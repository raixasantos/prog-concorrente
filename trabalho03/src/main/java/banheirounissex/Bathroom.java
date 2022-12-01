package banheirounissex;

import java.util.LinkedList;

public class Bathroom {
    	
	private int capacity;
	private LinkedList<Person> peopleInBathroom;

	private char currentGender = 'N';
	private LinkedList<Person> waitingList;


	public Bathroom(int capacity) {
		this.capacity = capacity;
		waitingList = new LinkedList<>();
		peopleInBathroom = new LinkedList<>();
	}


	public synchronized void insert(Person person) {
		System.out.println("Vai entrar na fila do banheiro. gênero: " + person.getGender() + " id: " + person.getId());
		waitingList.add(person);

		if(peopleInBathroom.isEmpty()) {
			currentGender = waitingList.peek().getGender();
			Person headPerson = waitingList.poll();
			peopleInBathroom.add(headPerson);

			System.out.println("Banheiro vazio. gênero: " + person.getGender() + " id: " + person.getId());
			System.out.println("Começou a usar o banheiro. gênero: " + person.getGender() + " id: " + person.getId()
				+ ". Qtd no banheiro: " + peopleInBathroom.size());
		}
		else {
			if(peopleInBathroom.size() < capacity && currentGender == person.getGender()) {
				System.out.println("Genero atual: " + currentGender + " Genero de quem entrou: " + waitingList.peek().getGender());
				Person headPerson = waitingList.poll(); // trocar para remover a pessoa em especifíco
				peopleInBathroom.add(headPerson);
				System.out.println("Começou a usar o banheiro. gênero: " + person.getGender() + " id: " + person.getId()
					+ ". Qtd no banheiro: " + peopleInBathroom.size());	
			}
		}

		while (peopleInBathroom.size() == capacity) {
			System.out.println("Banheiro cheio! Ids: ");
			for (Person per : peopleInBathroom) {
				System.out.print(per.getId() + " ");
			}
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
			
		notify();
	}

	public synchronized void remove(Person person) {
		System.out.println("Tentando sair do banheiro. id " + person.getId());
		/* 
		while (peopleInBathroom.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}		
		*/
		Boolean personRemoved = peopleInBathroom.remove(person);
        if(Boolean.TRUE.equals(personRemoved)){
            System.out.println("Saiu do banheiro " + person.getId() 
				+ " do gênero " + person.getGender() 
				+ ". Qtd no banheiro: " + peopleInBathroom.size());
        }
		notify();
		// return;
	}
}
