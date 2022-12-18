package banheirounissex;

import java.util.ArrayList;
import java.util.List;

public class Bathroom {
    	
	private int capacity;
	private List<Person> peopleInBathroom;
	private char currentGender = 'N';

	/**
	 * Parameterized constructor
	 * @param capacity Bathroom limit capacity
	 */
	public Bathroom(int capacity) {
		this.capacity = capacity;
		peopleInBathroom = new ArrayList<>();
	}

	/**
	 * Add people in the bathroom
	 * @param person Person who wants to use the bathroom
	 */
	public synchronized void enter(Person person) {
		System.out.println("Pessoa " + person.getId() + 
			"(" + person.getGender() + ") quer entrar no banheiro.");

		while (peopleInBathroom.size() == capacity || (currentGender != person.getGender() && currentGender != 'N')) {
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
		System.out.println("Pessoa " + person.getId() + 
			"(" + person.getGender() + ") começou a usar o banheiro." +
			" Qtd de pessoas no banheiro: " + peopleInBathroom.size());
		
		notify();
	}
	

	/**
	 * Remove people from the bathroom
	 * @param person Person who wants to leave the bathroom
	 */
	public synchronized void leave(Person person) {
		System.out.println("Pessoa " + person.getId() + 
			"(" + person.getGender() + ") tentando sair do banheiro.");
		Boolean personRemoved = peopleInBathroom.remove(person);
        if(Boolean.TRUE.equals(personRemoved)){
            
			System.out.println("Pessoa " + person.getId() + 
				"(" + person.getGender() + ") saiu do banheiro" + 
				". Qtd no banheiro: " + peopleInBathroom.size());

        }
		if(peopleInBathroom.isEmpty()) {
			currentGender = 'N';
		}
		notify();
	}
}
