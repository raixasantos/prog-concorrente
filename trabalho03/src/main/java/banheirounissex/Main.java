package banheirounissex;

import java.util.Random;

public class Main 
{
    /** Capacity of the bathroom */
	private static final int CAPACITY = 5;

	/** Number of person threads */
	private static final int NUM_THREADS = 100;

	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Bathroom bathroom = new Bathroom(CAPACITY);
        
        Person[] persons = new Person[NUM_THREADS];
		ThreadPerson[] threadsPerson = new ThreadPerson[NUM_THREADS];

        String setOfCharacters = "FM";
        Random random = new Random();
        for (int i = 0; i < NUM_THREADS; i++) {
            int randomInt = random.nextInt(setOfCharacters.length());
            char randomGender = setOfCharacters.charAt(randomInt);
            int randomTime = random.nextInt(120);
            Person person = new Person();
            person.setId(i);
            person.setGender(randomGender);
            person.setTime(Long.valueOf(randomTime));
            persons[i] = person;
			threadsPerson[i] = new ThreadPerson(persons[i], bathroom);
        }
		
		for (int i = 0; i < NUM_THREADS; i++) {
			threadsPerson[i].start();
		}
		
		try {
			for (int i = 0; i < NUM_THREADS; i++) {
				threadsPerson[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
