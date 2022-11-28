package banheirounissex;

import java.util.LinkedList;
import java.util.Queue;

public class Bathroom {
    	
	private int capacity;

	private Queue<Person> bathroom;

	private char currentGender = 'N';
	private Queue<Person> queue;


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
		//se o banheiro está cheio de mulheres e uma mulher quer entrar, vai pra fila?
		if(bathroom.size() == 0 && currentGender == 'N') {
			bathroom.add(person);
			currentGender = person.getGender();
		}
		else if(bathroom.size() == 0 && (currentGender == 'F' || currentGender == 'N') && queue.peek().getGender() == 'F' ){
			bathroom.add(person);
			currentGender = queue.peek().getGender();
			queue.poll();
		}
		else if(bathroom.size() == 0 && (currentGender == 'M' || currentGender == 'N') && queue.peek().getGender() == 'M' ){
			bathroom.add(person);
			currentGender = queue.peek().getGender();
			queue.poll();
		}
		else if(bathroom.size() < 5 && (currentGender == 'F' || currentGender == 'N') && queue.peek().getGender() == 'F' ){
			bathroom.add(person);
			currentGender = queue.peek().getGender();
			queue.poll();
		}
		else if(bathroom.size() < 5 && (currentGender == 'M' || currentGender == 'N') && queue.peek().getGender() == 'M' ){
			bathroom.add(person);
			currentGender = queue.peek().getGender();
			queue.poll();
		}
		else if(bathroom.size() < 5 && currentGender == 'F' && person.getGender() == 'F'){
			bathroom.add(person);
			currentGender = person.getGender();
		}
		else if(bathroom.size() < 5 && currentGender == 'M' && person.getGender() == 'M'){
			bathroom.add(person);
			currentGender = person.getGender();
		}
		else {
			queue.add(person);
		}
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
