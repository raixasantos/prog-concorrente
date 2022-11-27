package banheirounissex;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class Main 
{
    /** Capacity of the bounded buffer */
	private static final int CAPACITY = 5;

	/** Number of producer and consumer threads */
	private static final int NUM_THREADS = 20;

	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Bathroom bathroom = new Bathroom(CAPACITY);
        
        Person[] persons = new Person[NUM_THREADS];
		Producer[] producers = new Producer[NUM_THREADS];
		Consumer[] consumers = new Consumer[NUM_THREADS];

        String setOfCharacters = "FM";
        Random random = new Random();
        for (int i = 0; i < NUM_THREADS; i++) {
            int randomInt = random.nextInt(setOfCharacters.length());
            char randomGender = setOfCharacters.charAt(randomInt);
            int randomTime = random.nextInt(120000);
            Person person = new Person();
            person.setId(i);
            person.setGender(randomGender);
            person.setTime(randomTime);
            persons[i] = person;
        }

		for (int i = 0; i < NUM_THREADS; i++) {
			producers[i] = new Producer(persons[i], bathroom);
			consumers[i] = new Consumer(persons[i], bathroom);
		}
		
		for (int i = 0; i < NUM_THREADS; i++) {
			producers[i].start();
			consumers[i].start();
		}
		
		try {
			for (int i = 0; i < NUM_THREADS; i++) {
				producers[i].join();
				consumers[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
