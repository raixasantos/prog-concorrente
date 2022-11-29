package banheirounissex;

import java.util.LinkedList;
import java.util.Queue;

public class Bathroom {
    	
	private int capacity;

	private Queue<Person> peopleInBathroom;

	// private char currentGender = 'N';
	private Queue<Person> waitingQueue;


	public Bathroom(int capacity) {
		this.capacity = capacity;
		peopleInBathroom = new LinkedList<>();
	}


	public synchronized void insert(Person person) {
		System.out.println("Tentando entrar no banheiro. id " + person.getId());
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
		System.out.println("Vai entrar no banheiro o gênero: " + person.getGender() + " id " + person.getId());
		peopleInBathroom.add(person);
		System.out.println("Entrou no banheiro: " + person.getId() + ". Qtd no banheiro: " + peopleInBathroom.size());
		// notifyAll();
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
            System.out.println("Saiu do banheiro " + person.getId() + " do gênero " + person.getGender() + ". Qtd no banheiro: " + peopleInBathroom.size());
        }
		// notifyAll();
	}
}
