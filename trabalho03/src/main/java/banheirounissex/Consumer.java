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
        try {
            sleep(person.getTime());
            bathroom.remove(person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
