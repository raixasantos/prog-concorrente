package banheirounissex;

public class Consumer extends Thread {
    private Bathroom bathroom;
    private Person person;

    public Consumer (Person person, Bathroom bathroom) {
        this.person = person;
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        // bathroom.remove(person);
    }
}
