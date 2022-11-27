package banheirounissex;

import java.util.LinkedList;
import java.util.Queue;

public class Bathroom {
    	
	private int capacity;

	private Queue<Person> bathroom;


	public Bathroom(int capacity) {
		this.capacity = capacity;
		bathroom = new LinkedList<Person>();
	}


	public synchronized void insert(Person person) {
		while (bathroom.size() == capacity) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Vai entrar no banheiro o gênero: " + person.getGender());
		// TODO: adicionar condição de qual gênero entra
		bathroom.add(person);
		System.out.println("Entrou no banheiro: " + person.getId() + ". Qtd no banheiro: " + bathroom.size());
		notify();
	}

	
	public synchronized void remove(Person person) {
		while (bathroom.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Boolean personRemoved = bathroom.remove(person);
        if(personRemoved == true){
            System.out.println("Saiu do banheiro " + person.getId() + " do gênero " + person.getGender() + ". Qtd no banheiro: " + bathroom.size());
        }
		notify();
	}
}
