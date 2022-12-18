package banheirounissex;

public class ThreadPerson extends Thread {

    private Bathroom bathroom;
    private Person person;

    /**
	 * Parameterized constructor
	 * @param person Person who will use the bathroom
     * @param bathroom Bathroom to be used
	 */
    public ThreadPerson (Person person, Bathroom bathroom) {
        this.person = person;
        this.bathroom = bathroom;
    }

    /**
	 * Controls the time the person stays in the bathroom
	 */
    @Override
    public void run() {
        bathroom.enter(person);
        try {
			Thread.sleep(person.getTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
        bathroom.leave(person);
    }    
}
