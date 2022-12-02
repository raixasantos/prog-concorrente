package banheirounissex;

public class ThreadPerson extends Thread {
    private Bathroom bathroom;
    private Person person;

    public ThreadPerson (Person person, Bathroom bathroom) {
        this.person = person;
        this.bathroom = bathroom;
    }

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
